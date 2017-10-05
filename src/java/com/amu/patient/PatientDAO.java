package com.amu.patient;

import com.amu.DBConnection.DBConnection;
import com.amu.mainaction.AMUMainActionForm;
import com.cmu.utils.AMUUtilClass;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author Amulya
 */
public class PatientDAO {
    
    
    public static List patientList(String docId, int acceptance) {
        Connection con = null;        
        PreparedStatement preparedStatement = null;
        List<PatientVO> patientList = new ArrayList();
        try {
            con = DBConnection.getConnection();
            String patientListSQL = "SELECT patid, patient_name, "
                    + "emergcon, gender, age, "
                    + "email,contactinfo.city, contactinfo.province,contactinfo.phoneno "
                    + "FROM patient "
                    + " INNER JOIN (contactinfo) ON "
                    + "(patient.patid = contactinfo.contact_reference) "
                    + "where docid='"+docId+"' And acceptance="+acceptance+";";
            
            System.out.println("patientListSQL++ "+ patientListSQL);
            
            preparedStatement = con.prepareStatement(patientListSQL);
            // execute select SQL stetement
            ResultSet resulset = preparedStatement.executeQuery();
            while(resulset.next()) {                
                PatientVO vo = new PatientVO();
                vo.setPatid(AMUUtilClass.getString(resulset.getString("patid")));
                vo.setPatientName(AMUUtilClass.getString(resulset.getString("patient_name")));
                vo.setEmergcon(AMUUtilClass.getString(resulset.getString("emergcon")));
                vo.setGender(AMUUtilClass.getString(resulset.getString("gender")));
                vo.setAge(AMUUtilClass.getString(resulset.getString("age")));
                vo.setEmail(AMUUtilClass.getString(resulset.getString("email")));
                vo.setPhoneNumber(AMUUtilClass.getString(resulset.getString("contactinfo.phoneno")));
                vo.setCity(AMUUtilClass.getString(resulset.getString("contactinfo.city")));
                vo.setProvince(AMUUtilClass.getString(resulset.getString("contactinfo.province")));
                patientList.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AMUUtilClass.closeConnection(con);
            AMUUtilClass.closePSTMT(preparedStatement);
        }
        System.out.println("--patientList "+ patientList.size());
        return patientList;
    }
    
    
    public static int uploadReport(UploadReportForm reportform) {
        int insertRemSucess = 0;
        System.out.println("uploadResume ----------------------");
        PreparedStatement preparedStatementPSTMT = null;
        Connection con = null;
        System.out.println("candidateSignup DAO");
        String physioid = AMUUtilClass.getString("DOC000" + AMUUtilClass.getUniqueId().toUpperCase());
        try {
            // String fileName = resume.getFileName();
            String uploadReport = null;
            FormFile report = reportform.getReport();
            InputStream inputStream = null;
            if (reportform != null) {
               con = DBConnection.getConnection();
                uploadReport = "INSERT INTO "
                        + "physiologicaldata "
                        + "(physioid,"
                        + "textfile, "
                        + "patid, "
                        + "signaltype,"
                        + "description, "
                        + "uploadDate, reportName)"
                        + " VALUES"
                        + "(?, ?, ?, ?, ?, ?, ?);";

                preparedStatementPSTMT = con.prepareStatement(uploadReport);
                preparedStatementPSTMT.setString(1, physioid);
                inputStream = report.getInputStream();
                preparedStatementPSTMT.setBlob(2, inputStream);
                preparedStatementPSTMT.setString(3, reportform.getPatientId());
                preparedStatementPSTMT.setString(4, reportform.getSignaltype());
                preparedStatementPSTMT.setString(5, reportform.getDescription());
                preparedStatementPSTMT.setTimestamp(6, AMUUtilClass.getCurrentTimeStamp());
                preparedStatementPSTMT.setString(7, report.getFileName());
                // execute insert SQL stetement
                insertRemSucess = preparedStatementPSTMT.executeUpdate();
            }
            uploadReport = null;
            inputStream = null;

        } catch (Exception e) {
            try {
                con.rollback();
                //e.printStackTrace();
            } catch (SQLException ex) {
                
            }
        } finally {
            AMUUtilClass.closeConnection(con);
            AMUUtilClass.closePSTMT(preparedStatementPSTMT);
        }
        return insertRemSucess;
    }
    
    public static List reportList(String patientId) {
        Connection con = null;        
        PreparedStatement preparedStatement = null;
        List<PatientVO> patientList = new ArrayList();
        try {
             
            con = DBConnection.getConnection();
            String reportListSQL = "SELECT"
                    + "  physioid, "
                    + "  patid,"
                    + "  signaltype,"
                    + "  description,"
                    + "  uploadDate,"
                    + "  textfile "
                    + "  FROM  "
                    + "  physiologicaldata  "
                    + "  where patid='"+patientId+"';";
            System.out.println("patientListSQL++ "+ reportListSQL);
            
            preparedStatement = con.prepareStatement(reportListSQL);
            // execute select SQL stetement
            ResultSet resulset = preparedStatement.executeQuery();
            while(resulset.next()) {                
                PatientVO vo = new PatientVO();
                vo.setPhysioid(AMUUtilClass.getString(resulset.getString("physioid")));
                vo.setPatid(AMUUtilClass.getString(resulset.getString("patid")));
                vo.setSignaltype(AMUUtilClass.getString(resulset.getString("signaltype")));
                vo.setDescription(AMUUtilClass.getString(resulset.getString("description")));
                vo.setUploadDate(AMUUtilClass.getString(resulset.getString("uploadDate")));
                
                patientList.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AMUUtilClass.closeConnection(con);
            AMUUtilClass.closePSTMT(preparedStatement);
        }
        System.out.println("--patientList "+ patientList.size());
        return patientList;
    }
    
    public static List report(String docId) {
        Connection con = null;        
        PreparedStatement preparedStatement = null;
        List<PatientVO> patientList = new ArrayList();
        try {
             
            con = DBConnection.getConnection();
            String reportListSQL = "SELECT"
                    + "  physioid, "
                    + "  patid,"
                    + "  signaltype,"
                    + "  description,"
                    + "  uploadDate,"
                    + "  textfile, reportName "
                    + "  FROM  "
                    + "  physiologicaldata  "
                    + "  where physioid='"+docId+"';";
            System.out.println("patientListSQL++ "+ reportListSQL);
            
            preparedStatement = con.prepareStatement(reportListSQL);
            // execute select SQL stetement
            ResultSet resulset = preparedStatement.executeQuery();
            while(resulset.next()) {                
                PatientVO vo = new PatientVO();
                vo.setPhysioid(AMUUtilClass.getString(resulset.getString("physioid")));
                vo.setPatid(AMUUtilClass.getString(resulset.getString("patid")));
                vo.setSignaltype(AMUUtilClass.getString(resulset.getString("signaltype")));
                vo.setDescription(AMUUtilClass.getString(resulset.getString("description")));
                vo.setUploadDate(AMUUtilClass.getString(resulset.getString("uploadDate")));
                vo.setReport(resulset.getBinaryStream("textfile"));
                vo.setFileName(resulset.getString("reportName"));
                patientList.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AMUUtilClass.closeConnection(con);
            AMUUtilClass.closePSTMT(preparedStatement);
        }
        System.out.println("--patientList "+ patientList.size());
        return patientList;
    }
    
    public static List patientById(String patientId) {
        Connection con = null;        
        PreparedStatement preparedStatement = null;
        List<PatientVO> patientList = new ArrayList();
        try {
             
            con = DBConnection.getConnection();
            String patientListSQL = "SELECT patid, patient_name, "
                    + "emergcon, gender, age, "
                    + "email FROM patient where patid='"+patientId+"';";
            System.out.println("patientListSQL++ "+ patientListSQL);
            
            preparedStatement = con.prepareStatement(patientListSQL);
            // execute select SQL stetement
            ResultSet resulset = preparedStatement.executeQuery();
            while(resulset.next()) {                
                PatientVO vo = new PatientVO();
                vo.setPatid(AMUUtilClass.getString(resulset.getString("patid")));
                vo.setPatientName(AMUUtilClass.getString(resulset.getString("patient_name")));
                vo.setEmergcon(AMUUtilClass.getString(resulset.getString("emergcon")));
                vo.setGender(AMUUtilClass.getString(resulset.getString("gender")));
                vo.setAge(AMUUtilClass.getString(resulset.getString("age")));
                vo.setEmail(AMUUtilClass.getString(resulset.getString("email")));
                patientList.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AMUUtilClass.closeConnection(con);
            AMUUtilClass.closePSTMT(preparedStatement);
        }
        System.out.println("--patientList "+ patientList.size());
        return patientList;
    }
    
    
    public static List patientEditDataById(String patientId) {
        Connection con = null;        
        PreparedStatement preparedStatement = null;
        List<PatientVO> patientList = new ArrayList();
        try {
             
            con = DBConnection.getConnection();
            String patientListSQL = "SELECT  patid, docid, "
                    + "patient_name,contactinfo.phoneno,"
                    + "email,contactinfo.country,"
                    + "contactinfo.province,"
                    + "contactinfo.city,"
                    + "contactinfo.zipcode,contactinfo.street,"
                    + " emergcon, gender, age"
                    + " FROM patient"
                    + " INNER JOIN (contactinfo) ON "
                    + " (patient.patid = contactinfo.contact_reference) "
                    + "  WHERE patid='"+patientId+"';";
            System.out.println("patientListSQL++ "+ patientListSQL);
            
            preparedStatement = con.prepareStatement(patientListSQL);
            // execute select SQL stetement
            ResultSet resulset = preparedStatement.executeQuery();
            while(resulset.next()) {                
                PatientVO vo = new PatientVO();
                vo.setPatid(AMUUtilClass.getString(resulset.getString("patid")));
                vo.setDocid(AMUUtilClass.getString(resulset.getString("docid")));
                vo.setPatientName(AMUUtilClass.getString(resulset.getString("patient_name")));
                vo.setPhoneNumber(AMUUtilClass.getString(resulset.getString("contactinfo.phoneno")));
                vo.setEmail(AMUUtilClass.getString(resulset.getString("email")));
                
                vo.setCountry(AMUUtilClass.getString(resulset.getString("contactinfo.country")));
                vo.setProvince(AMUUtilClass.getString(resulset.getString("contactinfo.province")));
                
                
                vo.setCity(AMUUtilClass.getString(resulset.getString("contactinfo.city")));
                vo.setZipcode(AMUUtilClass.getString(resulset.getString("contactinfo.zipcode")));
                vo.setStreet(AMUUtilClass.getString(resulset.getString("contactinfo.street")));
                
                vo.setEmergcon(AMUUtilClass.getString(resulset.getString("emergcon")));
                vo.setGender(AMUUtilClass.getString(resulset.getString("gender")));
                vo.setAge(AMUUtilClass.getString(resulset.getString("age")));
                
                patientList.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AMUUtilClass.closeConnection(con);
            AMUUtilClass.closePSTMT(preparedStatement);
        }
        System.out.println("--patientList "+ patientList.size());
        return patientList;
    }
    
    public static void updatePatient(AMUMainActionForm amuForm, String pid) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DBConnection.getConnection();
            String flagSQL = "UPDATE patient "
                    + " SET "
                    + " docid = ? , "
                    + " patient_name = ?, "
                    + " emergcon = ?, "
                    + " gender = ? , "
                    + " age = ? "
                    + " WHERE patid = ? ;";

            preparedStatement = con.prepareStatement(flagSQL);
            preparedStatement.setString(1, amuForm.getDocId());
            preparedStatement.setString(2, amuForm.getName());
            preparedStatement.setString(3, amuForm.getEmergcon());
            preparedStatement.setString(4, amuForm.getGender());
            preparedStatement.setString(5, amuForm.getAge());
            preparedStatement.setString(6, pid);
            // execute select SQL stetement
            preparedStatement.executeUpdate();
            preparedStatement = null;
            String updateAddress = "UPDATE contactinfo "
                    + "SET "
                    + " phoneno = ? , street = ? ,"
                    + " city = ? ,"
                    + " province = ?, zipcode = ?, country = ? "
                    + "WHERE contact_reference = ? ;";
              
            preparedStatement = con.prepareStatement(updateAddress);
            preparedStatement.setString(1, amuForm.getPhone());
            preparedStatement.setString(2, amuForm.getStreet());
            preparedStatement.setString(3, amuForm.getCity());
            preparedStatement.setString(4, amuForm.getProvince());
            preparedStatement.setString(5, amuForm.getZipCode());
            preparedStatement.setString(6, amuForm.getCountry());
            
            
            preparedStatement.setString(7, pid);
            // execute select SQL stetement
            preparedStatement.executeUpdate();
            flagSQL = null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AMUUtilClass.closeConnection(con);
            AMUUtilClass.closePSTMT(preparedStatement);
        }
    }
    
    public static void updatePatientAcceptance(int acceptance , List<PatientVO> PatientList) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DBConnection.getConnection();
            String flagSQL = "UPDATE patient "
                    + "SET acceptance = ? WHERE patid = ? ;";
             preparedStatement = con.prepareStatement(flagSQL);
            for (PatientVO PatientList1 : PatientList) {
                preparedStatement.setInt(1, acceptance);
                preparedStatement.setString(2, PatientList1.getPatid());
                // execute select SQL stetement
                preparedStatement.executeUpdate();
            }
           
            flagSQL = null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AMUUtilClass.closeConnection(con);
            AMUUtilClass.closePSTMT(preparedStatement);
        }
    }
    
}
