package com.amu.doctor;

import com.amu.mainaction.AMUConstant;
import com.amu.mainaction.AMUMainActionForm;
import com.amu.maindao.AMUMAINDAO;
import com.amu.patient.PatientDAO;
import com.amu.patient.PatientVO;
import com.cmu.utils.Country;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Amulya
 */
public class DoctorMainAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static String jspPage = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String action = (String) request.getParameter("action");
        HttpSession session = request.getSession();
        
        String docId = (String) session.getAttribute("docId");
        if( null == docId  || docId.equals("null") ||"".equals(docId) ) {
            request.setAttribute("doctormodule", "doctormodule");
            jspPage = "loginpage";
        }
        
        
        if ("patientregistrationPage".equals(action)) {
            request.setAttribute("patientregistrationPage", "patientregistrationPage");
            jspPage = "createPatient";
        }else if ("docprofile".equals(action)) {
            
            List docList = DoctorDAO.docEditProfileById(docId);
            if (docList.size() > 0) {
                request.setAttribute("docList", docList);
            }
            
              List<Country> countryList = AMUMAINDAO.getConutryList();
              if(countryList.size() > 0 ){
              request.setAttribute("countryList", countryList);
              }
           
            jspPage = "docprofile";
        }else if ("doctorupdateaction".equals(action)) {
            AMUMainActionForm amuForm = (AMUMainActionForm) form;
            DoctorDAO.updateDoctor(amuForm, docId);
             request.setAttribute("successupdate","success");            
            List docList = DoctorDAO.docEditProfileById(docId);
            if (docList.size() > 0) {
                request.setAttribute("docList", docList);
            }
            
             List<Country> countryList = AMUMAINDAO.getConutryList();
              if(countryList.size() > 0 ){
              request.setAttribute("countryList", countryList);
              }
           
            jspPage = "docprofile";
        }else if ("createpatient".equals(action)) {
            AMUMainActionForm amuForm = (AMUMainActionForm) form;
            String patientId = AMUMAINDAO.createPatient(amuForm, docId);
            if (patientId != null) {
                request.setAttribute("patientId", patientId);
                jspPage = "success";
            }
            amuForm = null;
        } else if ("patientList".equals(action)) {
            List patientList = PatientDAO.patientList(docId, AMUConstant.PATIENT_ACCCPT);
            if (patientList.size() > 0) {
                request.setAttribute("patientList", patientList);
            }
            jspPage = "PatientList";
        } else if ("patientreport".equals(action)) {
            //String patientId = (String) request.getParameter("patientId"); 
            request.setAttribute("patientId", (String) request.getParameter("patientId"));
            jspPage = "patientReportUpload";
        } else if ("uploadReport".equals(action)) {
            request.setAttribute("patientId", (String) request.getParameter("patientId"));
            jspPage = "patientReportUpload";
        } else if ("viewReportUrl".equals(action)) {

            String patientId = (String) request.getParameter("patientId");
            List reportList = PatientDAO.reportList(patientId);
            if (reportList.size() > 0) {
                request.setAttribute("reportList", reportList);

            }
            jspPage = "patientReportpage";
        } else if ("downLoadReport".equals(action)) {

            List reportList = PatientDAO.report(docId);

            try {
                InputStream inputStream = null;
                String fileName = "";
                if (!reportList.isEmpty()) {
                    for (Iterator<PatientVO> iterator = reportList.iterator(); iterator.hasNext();) {
                        PatientVO rep = iterator.next();
                        inputStream = rep.getReport();
                        fileName= rep.getFileName();

                    }

                        //request.setAttribute("appliedCandidateList", candidateDocList);
                    //ServletContext context = request.getServletContext();
                    // gets MIME type of the file
                    String mimeType = "application/octet-stream";
                    int fileLength = inputStream.available();
                    response.setContentType(mimeType);
                    response.setContentLength(fileLength);
                    String headerKey = "Content-Disposition";
                    String headerValue = String.format("attachment; filename=\"%s\"", fileName);
                    response.setHeader(headerKey, headerValue);
                    // obtains response's output stream
                    OutputStream outStream = response.getOutputStream();

                    byte[] buffer = new byte[8000];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outStream.write(buffer, 0, bytesRead);
                    }

                    inputStream.close();
                    outStream.close();
                } else {
                    // no file found
                    response.getWriter().print("File not found for this id: " + docId);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //jspPage = "writeFile";
            return null;

        }else if ("notificationpatientList".equals(action)) {
            
            request.getSession().removeAttribute("notificationpatientList");
            List patientList = PatientDAO.patientList(docId, AMUConstant.PATIENT_ASSIGN);
            if (patientList.size() > 0) {
                request.getSession().setAttribute("notificationpatientList", patientList);
            }
            jspPage = "notification";
        }else if ("acceptall".equals(action)) {
           
            List<PatientVO> patientList= (List<PatientVO>) session.getAttribute("notificationpatientList");
            if (patientList != null &&   patientList.size() > 0) {
                PatientDAO.updatePatientAcceptance(AMUConstant.PATIENT_ACCCPT, patientList);
            }
            request.getSession().removeAttribute("notificationpatientList");
            
            patientList = PatientDAO.patientList(docId, AMUConstant.PATIENT_ASSIGN);
            if (patientList.size() > 0) {
                request.setAttribute("acceptall", "acceptall");
                request.getSession().setAttribute("notificationpatientList", patientList);
            } 
            jspPage = "notification";
        }else if ("declineall".equals(action)) {
           
            List<PatientVO> patientList= (List<PatientVO>) session.getAttribute("notificationpatientList");
            if (patientList != null &&   patientList.size() > 0) {
                PatientDAO.updatePatientAcceptance(AMUConstant.PATIENT_REJECT, patientList);
            }
            request.getSession().removeAttribute("notificationpatientList");
            patientList = PatientDAO.patientList(docId, AMUConstant.PATIENT_ASSIGN);
            if (patientList.size() > 0) {
                 request.setAttribute("declineall", "declineall");
                request.getSession().setAttribute("notificationpatientList", patientList);
            } 
            jspPage = "notification";
        }else if ("Accept".equals(action)) {
            
            request.getSession().removeAttribute("notificationpatientList");
            
            
            AMUMainActionForm amuForm = (AMUMainActionForm) form;
            
            List<PatientVO> patientListnew = new ArrayList();
            String[] list = amuForm.getPatIdnotification();
            for (String list1 : list) {
                PatientVO vo = new PatientVO();
                vo.setPatid(list1);
                patientListnew.add(vo);
            }
            
            if(patientListnew.size() > 0 ) {
                PatientDAO.updatePatientAcceptance(AMUConstant.PATIENT_REJECT, patientListnew);
            }
             
            List patientList = PatientDAO.patientList(docId, AMUConstant.PATIENT_ASSIGN);
            if (patientList.size() > 0) {
                request.setAttribute("accept", "accept");
                request.getSession().setAttribute("notificationpatientList", patientList);
            } 
            jspPage = "notification";
        }else if ("Decline".equals(action)) {
            request.getSession().removeAttribute("notificationpatientList");
            
            AMUMainActionForm amuForm = (AMUMainActionForm) form;
            String[] list = amuForm.getPatIdnotification();
            List<PatientVO> patientListnew = new ArrayList();
            for (String list1 : list) {
                PatientVO vo = new PatientVO();
                vo.setPatid(list1);
                patientListnew.add(vo);
            }
            
            if(patientListnew.size() > 0 ) {
                PatientDAO.updatePatientAcceptance(AMUConstant.PATIENT_REJECT, patientListnew);
            }
            List patientList = PatientDAO.patientList(docId, AMUConstant.PATIENT_ASSIGN);
            if (patientList.size() > 0) {
                request.setAttribute("decline", "decline");
                request.getSession().setAttribute("notificationpatientList", patientList);
            } 
            jspPage = "notification";
        }

        return mapping.findForward(jspPage);
    }
}
