package com.amu.mainaction;

import com.amu.doctor.DoctorVo;
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
public class MainAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static String jspPage = "mainlayout";

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
        if ("doctormodule".equals(action)) {
            request.setAttribute("doctormodule", "doctormodule");
            jspPage = "loginpage";
        } else if ("patientmodule".equals(action)) {
            request.setAttribute("patientmodule", "patientmodule");
            jspPage = "loginpage";
        }else if ("doctorsignin".equals(action)) {
            request.setAttribute("doctorsignin", "doctorsignin");
            jspPage = "loginpage";
        }else if ("patientsignin".equals(action)) {
            request.setAttribute("patientsignin", "patientsignin");
            jspPage = "loginpage";
        }else if ("doctorregistrationPage".equals(action)) {
             List<Country> countryList = AMUMAINDAO.getConutryList();
              if(countryList.size() > 0 ){
              request.setAttribute("countryList", countryList);
              }
            request.setAttribute("doctorregistrationPage", "doctorregistrationPage");
            jspPage = "loginpage";
        }else if ("patientregistrationPage".equals(action)) {
             List<DoctorVo> doctorList = AMUMAINDAO.getDoctorList();
             List<Country> countryList = AMUMAINDAO.getConutryList();
            if(doctorList.size() > 0 ){
                request.setAttribute("doctorList", doctorList);
            }
            
            if(countryList.size() > 0 ){
              request.setAttribute("countryList", countryList);
              }
            request.setAttribute("patientregistrationPage", "patientregistrationPage");
            jspPage = "loginpage";
        }else if ("docregistration".equals(action)) {
            AMUMainActionForm amuForm = (AMUMainActionForm) form;
            int insertSucess = AMUMAINDAO.doctorRegistration(amuForm);
            if(insertSucess == 1) {
                request.setAttribute("success", "success");
                jspPage = "success";
            }else {
                System.out.println("fail----");
                request.setAttribute("doctorregistrationPage", "doctorregistrationPage");
                request.setAttribute("fail", "fail");
                jspPage = "loginpage";
            }
            
        }else if ("patientregistration".equals(action)) {
            AMUMainActionForm amuForm = (AMUMainActionForm) form;
            String insertSucess = AMUMAINDAO.patientRegistration(amuForm);
            if(insertSucess != null) {
                request.setAttribute("success", "success");
                request.setAttribute("patientId", insertSucess);
                jspPage = "success";
            }else {
                List<DoctorVo> doctorList = AMUMAINDAO.getDoctorList();
                if(doctorList.size() > 0 ){
                    request.setAttribute("doctorList", doctorList);
                }
                 
                request.setAttribute("patientregistrationPage", "patientregistrationPage");
                request.setAttribute("fail", "fail");
                jspPage = "loginpage";
            }
           
        }else if ("doctorlogin".equals(action)) {
            HttpSession session = request.getSession();
            AMUMainActionForm amuForm = (AMUMainActionForm) form;
            String loginSucess = AMUMAINDAO.validateDoctorLogin(amuForm);
            System.out.println("Docotr loginSucess--"+ loginSucess);
            if(loginSucess != null) { 
                session.setAttribute("docId", loginSucess);
                jspPage = "doctorHomePage";
            }else {
                request.setAttribute("doctorsignin", "doctorsignin");
                request.setAttribute("doctorsignfail", "doctorsignfail");
                jspPage = "loginpage";
            }
             
        }else if ("patientlogin".equals(action)) {
            AMUMainActionForm amuForm = (AMUMainActionForm) form;
            String patientId = AMUMAINDAO.validatePatientLogin(amuForm);
            if(patientId != null) {
                HttpSession session = request.getSession();
                session.setAttribute("patientId", patientId);
                jspPage = "patientHomePage";                
            }else {
                request.setAttribute("patientsignin", "patientsignin");
                request.setAttribute("patientloginFail", "patientloginFail");
                jspPage = "loginpage";
            }
        }else if ("logout".equals(action)) {                
            // ivalidate all the session
            request.getSession().invalidate();             
            jspPage = "mainlayout";

        }else {
            jspPage ="mainlayout";
        }
        return mapping.findForward(jspPage);
    }
}
