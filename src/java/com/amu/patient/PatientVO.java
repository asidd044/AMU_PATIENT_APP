package com.amu.patient;

import java.io.InputStream;

/**
 *
 * @author Amulya
 */
public class PatientVO {
    
    private String patid;
    private String docid;
    private String patientName;
    private String emergcon;
    private String gender;
    private String age;
    private String email;
    
    // Report Data
    private String physioid;
    private String signaltype;
    private String description;
    private String uploadDate;
    private InputStream report;
    private String fileName;

    private String phoneNumber;
    private String country;
    private String province;
    private String city; 
    private String zipcode;
    
    private String street;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
     
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getReport() {
        return report;
    }

    public void setReport(InputStream report) {
        this.report = report;
    }
     
    public String getPhysioid() {
        return physioid;
    }

    public void setPhysioid(String physioid) {
        this.physioid = physioid;
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

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    } 
    
    public String getPatid() {
        return patid;
    }

    public void setPatid(String patid) {
        this.patid = patid;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getEmergcon() {
        return emergcon;
    }

    public void setEmergcon(String emergcon) {
        this.emergcon = emergcon;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
