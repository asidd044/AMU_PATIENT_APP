package com.amu.doctor;

import java.io.InputStream;
import java.io.Serializable;

/**
 *
 * @author Amulya
 */
public class DoctorVo  implements Serializable{
    
    private String docId;
    private String docName;
    
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
    
    private String docRegistrationId;   
    private String docorg;
    private String doc_clinic_name;
    private String doc_address;
    
    private String street;

    public String getDocRegistrationId() {
        return docRegistrationId;
    }

    public void setDocRegistrationId(String docRegistrationId) {
        this.docRegistrationId = docRegistrationId;
    }

    public String getDocorg() {
        return docorg;
    }

    public void setDocorg(String docorg) {
        this.docorg = docorg;
    }

    public String getDoc_clinic_name() {
        return doc_clinic_name;
    }

    public void setDoc_clinic_name(String doc_clinic_name) {
        this.doc_clinic_name = doc_clinic_name;
    }

    public String getDoc_address() {
        return doc_address;
    }

    public void setDoc_address(String doc_address) {
        this.doc_address = doc_address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public InputStream getReport() {
        return report;
    }

    public void setReport(InputStream report) {
        this.report = report;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
    

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }
     
}
