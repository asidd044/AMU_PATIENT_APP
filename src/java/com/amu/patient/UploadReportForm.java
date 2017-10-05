package com.amu.patient;

import org.apache.struts.upload.FormFile;

/**
 *
 * @author Amulya
 */
public class UploadReportForm extends org.apache.struts.action.ActionForm {
    
    private String patientId;
    private String signaltype;
    private String description;
    private FormFile report;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getSignaltype() {
        return signaltype;
    }

    public void setSignaltype(String signaltype) {
        this.signaltype = signaltype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FormFile getReport() {
        return report;
    }

    public void setReport(FormFile report) {
        this.report = report;
    }
    
    
    
}
