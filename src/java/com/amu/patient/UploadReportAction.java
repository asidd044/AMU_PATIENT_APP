package com.amu.patient;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Amulya
 */
public class UploadReportAction extends org.apache.struts.action.Action {

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
        UploadReportForm reportForm = (UploadReportForm) form;
        
        int success = PatientDAO.uploadReport(reportForm);
         if(success > 0 ) {
             request.setAttribute("reportSuccess", "reportSuccess");
             jspPage = "success";
         }
        return mapping.findForward(jspPage);
    }
}
