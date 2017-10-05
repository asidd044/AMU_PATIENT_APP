package com.amu.patient;

import com.amu.doctor.DoctorVo;
import com.amu.mainaction.AMUMainActionForm;
import com.amu.maindao.AMUMAINDAO;
import com.cmu.utils.Country;
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
public class PatientMainAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static String jspPage = "patientLayout";

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
        if ("viewReportUrl".equals(action)) {

            String patientId = (String) request.getParameter("patientId");
            List reportList = PatientDAO.reportList(patientId);
            if (reportList.size() > 0) {
                request.setAttribute("reportList", reportList);

            }
            jspPage = "patientReportpage";
        } /*else if ("myProfile".equals(action)) {
            
            HttpSession session = request.getSession();
            String patientId = (String) session.getAttribute("patientId");
            List patientList = PatientDAO.patientById(patientId);
            if (patientList.size() > 0) {
                request.setAttribute("patientList", patientList);
            }
            jspPage = "myProfile";
        } */else if ("myProfile".equals(action)) {
            
            HttpSession session = request.getSession();
            String patientId = (String) session.getAttribute("patientId");
            List patientList = PatientDAO.patientEditDataById(patientId);
            if (patientList.size() > 0) {
                request.setAttribute("patientList", patientList);
            }
             List<Country> countryList = AMUMAINDAO.getConutryList();
              if(countryList.size() > 0 ){
              request.setAttribute("countryList", countryList);
              }
            
            List<DoctorVo> doctorList = AMUMAINDAO.getDoctorList();
                if(doctorList.size() > 0 ){
                    request.setAttribute("doctorList", doctorList);
                }
            jspPage = "peditprofile";
        }else if ("patientupdateaction".equals(action)) {
            
            AMUMainActionForm amuForm = (AMUMainActionForm) form;
            HttpSession session = request.getSession();
            String patientId = (String) session.getAttribute("patientId");
            
            PatientDAO.updatePatient(amuForm, patientId);
            request.setAttribute("successupdate","success");
            List patientList = PatientDAO.patientEditDataById(patientId);
            if (patientList.size() > 0) {
                request.setAttribute("patientList", patientList);
            }
            
             List<Country> countryList = AMUMAINDAO.getConutryList();
              if(countryList.size() > 0 ){
              request.setAttribute("countryList", countryList);
              }
            List<DoctorVo> doctorList = AMUMAINDAO.getDoctorList();
                if(doctorList.size() > 0 ){
                    request.setAttribute("doctorList", doctorList);
                }
            jspPage = "peditprofile";
        } 
        return mapping.findForward(jspPage);
    }
}
