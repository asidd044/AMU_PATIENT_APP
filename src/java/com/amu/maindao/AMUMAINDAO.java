package com.amu.maindao;

import com.amu.DBConnection.DBConnection;
import com.amu.doctor.DoctorVo;
import com.amu.mainaction.AMUMainActionForm;
import com.cmu.utils.AMUUtilClass;
import com.cmu.utils.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amulya
 */
public class AMUMAINDAO {
    
    public static int doctorRegistration(AMUMainActionForm registrationForm) {
        int insertSucess = 0;
        System.out.print("values --"+registrationForm.getName()+ registrationForm.getRegistrationId()
        + registrationForm.getOrganization()+ registrationForm.getPassword());
        Connection con = null;
        PreparedStatement preparedStatementPSTMT = null;
        System.out.println("doctorRegistration DAO");
        try {
            con = DBConnection.getConnection();
            String docSignup = "INSERT INTO "
                    + "doc "
                    + "( docid, "
                    + " doc_registrationId, "
                    + " docname, "
                    + " docorg,"
                    + " doc_clinic_name,"
                    + " doc_address,"
                    + " pass, email)"
                    + " VALUES("
                    + "?, ?, ?, ?, ?, ?, ?, ?);";
            System.out.println(docSignup);
             
            preparedStatementPSTMT = con.prepareStatement(docSignup);
            
            String docId = AMUUtilClass.getString("DOC000" + AMUUtilClass.getUniqueId().toUpperCase());
            
            preparedStatementPSTMT.setString(1, docId);
            preparedStatementPSTMT.setString(2, AMUUtilClass.getString(registrationForm.getRegistrationId()));
            preparedStatementPSTMT.setString(3, AMUUtilClass.getString(registrationForm.getName()));
            preparedStatementPSTMT.setString(4, AMUUtilClass.getString(registrationForm.getOrganization()));
            
            preparedStatementPSTMT.setString(5, AMUUtilClass.getString(registrationForm.getClinic()));
            preparedStatementPSTMT.setString(6, AMUUtilClass.getString(registrationForm.getAddress()));
            
            preparedStatementPSTMT.setString(7, AMUUtilClass.getString(registrationForm.getPassword()));
            preparedStatementPSTMT.setString(8, AMUUtilClass.getString(registrationForm.getEmail()));
            // execute insert SQL stetement
            insertSucess = preparedStatementPSTMT.executeUpdate();
                        
            String addId = AMUUtilClass.getString("ADD000" + AMUUtilClass.getUniqueId().toUpperCase());
            String address = "INSERT INTO contactinfo "
                    + "(contact_info_id,"
                    + " contact_reference,"
                    + " phoneno,"
                    + " street,"
                    + " city,"
                    + " province,"
                    + " country,"
                    + " zipcode)"
                    + "	VALUES	"
                    + " (?, ?, ?, ?, ?, ?, ?, ?);";
            
            preparedStatementPSTMT = con.prepareStatement(address);
            
            preparedStatementPSTMT.setString(1, addId);
            preparedStatementPSTMT.setString(2, docId);
            preparedStatementPSTMT.setString(3, AMUUtilClass.getString(registrationForm.getPhone()));
            preparedStatementPSTMT.setString(4, AMUUtilClass.getString(registrationForm.getStreet()));
            preparedStatementPSTMT.setString(5, AMUUtilClass.getString(registrationForm.getCity()));            
            preparedStatementPSTMT.setString(6, AMUUtilClass.getString(registrationForm.getProvince()));
            preparedStatementPSTMT.setString(7, AMUUtilClass.getString(registrationForm.getCountry()));
            preparedStatementPSTMT.setString(8, AMUUtilClass.getString(registrationForm.getZipCode()));
            // execute insert SQL stetement
            insertSucess = preparedStatementPSTMT.executeUpdate();
            
            
            docSignup = null;
            registrationForm = null;

        } catch (Exception e) {
            insertSucess = 0;
            e.printStackTrace();
        } finally {
            AMUUtilClass.closeConnection(con);
            AMUUtilClass.closePSTMT(preparedStatementPSTMT);
        }
        return insertSucess;
    }
        
    public static String patientRegistration(AMUMainActionForm registrationForm) {
        int insertSucess = 0;
       
        Connection con = null;
        String pateintId = null;
        PreparedStatement preparedStatementPSTMT = null;
        System.out.println("Patient Registration DAO");
        try {
            con = DBConnection.getConnection();
            String docSignup = "INSERT INTO patient " +
            "	(patid, docid,patient_name, emergcon, patcondn, gender, age,"
                    + " cont_info_id, email, pass, acceptance) "+
            "        VALUES" +
            "	(?,?,?,?,?,?,?,?,? ,?, ?);";
            System.out.println(docSignup);
            pateintId = AMUUtilClass.getString("PAT000" + AMUUtilClass.getUniqueId().toUpperCase()); 
            preparedStatementPSTMT = con.prepareStatement(docSignup);
            
            preparedStatementPSTMT.setString(1, pateintId);
            preparedStatementPSTMT.setString(2, AMUUtilClass.getString(registrationForm.getDocId()));
            preparedStatementPSTMT.setString(3, AMUUtilClass.getString(registrationForm.getName()));
            preparedStatementPSTMT.setString(4, "");
            preparedStatementPSTMT.setString(5, "");
            preparedStatementPSTMT.setString(6, "");
            preparedStatementPSTMT.setString(7, "");
            preparedStatementPSTMT.setString(8, "");
            preparedStatementPSTMT.setString(9, AMUUtilClass.getString(registrationForm.getEmail()));
            preparedStatementPSTMT.setString(10, AMUUtilClass.getString(registrationForm.getPassword()));
            preparedStatementPSTMT.setInt(11, 0);
             
            // execute insert SQL stetement
            insertSucess = preparedStatementPSTMT.executeUpdate();
            
            String addId = AMUUtilClass.getString("ADD000" + AMUUtilClass.getUniqueId().toUpperCase());
            String address = "INSERT INTO contactinfo "
                    + "(contact_info_id,"
                    + " contact_reference,"
                    + " phoneno,"
                    + " street,"
                    + " city,"
                    + " province,"
                    + " country,"
                    + " zipcode)"
                    + "	VALUES	"
                    + " (?, ?, ?, ?, ?, ?, ?, ?);";
            
            preparedStatementPSTMT = con.prepareStatement(address);
            
            preparedStatementPSTMT.setString(1, addId);
            preparedStatementPSTMT.setString(2, pateintId);
            preparedStatementPSTMT.setString(3, AMUUtilClass.getString(registrationForm.getPhone()));
            preparedStatementPSTMT.setString(4, AMUUtilClass.getString(registrationForm.getStreet()));
            preparedStatementPSTMT.setString(5, AMUUtilClass.getString(registrationForm.getCity()));            
            preparedStatementPSTMT.setString(6, AMUUtilClass.getString(registrationForm.getProvince()));
            preparedStatementPSTMT.setString(7, AMUUtilClass.getString(registrationForm.getCountry()));
            preparedStatementPSTMT.setString(8, AMUUtilClass.getString(registrationForm.getZipCode()));
            // execute insert SQL stetement
            insertSucess = preparedStatementPSTMT.executeUpdate();
            
            docSignup = null;
            registrationForm = null;

        } catch (Exception e) {
            return pateintId = null;
            //e.printStackTrace();
        } finally {
            AMUUtilClass.closeConnection(con);
            AMUUtilClass.closePSTMT(preparedStatementPSTMT);
        }
        if(insertSucess == 0 ){ 
            pateintId = null;
        }
        return pateintId;
    }
    
    public static String createPatient(AMUMainActionForm registrationForm, String docId) {
        String pateintId = AMUUtilClass.getString("PAT000" + AMUUtilClass.getUniqueId().toUpperCase()); 
        int insertSucess = 0 ;
        Connection con = null;
        PreparedStatement preparedStatementPSTMT = null;
        System.out.println("Patient Registration DAO");
        try {
            con = DBConnection.getConnection();
            String docSignup = "INSERT INTO patient " +
            "	(patid, docid,patient_name, emergcon, patcondn, gender, age,"
                    + " cont_info_id, email, pass) "+
            "        VALUES" +
            "	(?,?,?,?,?,?,?,?,? ,?);";
            System.out.println(docSignup);
            
            preparedStatementPSTMT = con.prepareStatement(docSignup);
            
            preparedStatementPSTMT.setString(1, pateintId);
            preparedStatementPSTMT.setString(2, docId);
            preparedStatementPSTMT.setString(3, AMUUtilClass.getString(registrationForm.getName()));
            preparedStatementPSTMT.setString(4, AMUUtilClass.getString(registrationForm.getEmergcon()));
            preparedStatementPSTMT.setString(5, "");
            preparedStatementPSTMT.setString(6, AMUUtilClass.getString(registrationForm.getGender()));
            preparedStatementPSTMT.setString(7, AMUUtilClass.getString(registrationForm.getAge()));
            preparedStatementPSTMT.setString(8, "");
            preparedStatementPSTMT.setString(9, AMUUtilClass.getString(registrationForm.getEmail()));
            preparedStatementPSTMT.setString(10, AMUUtilClass.getString(registrationForm.getPassword()));
            

            // execute insert SQL stetement
            insertSucess = preparedStatementPSTMT.executeUpdate();
            docSignup = null;
            registrationForm = null;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AMUUtilClass.closeConnection(con);
            AMUUtilClass.closePSTMT(preparedStatementPSTMT);
        }
        
        if(insertSucess == 0) {
            pateintId = null;
        }
        return pateintId;
    }
    
    
    
    public static String validateDoctorLogin(AMUMainActionForm registrationForm) {
        Connection con = null;
        String docInfo = null;
        PreparedStatement preparedStatement = null;
        try {
            
            con = DBConnection.getConnection();
            String loginSQL = "SELECT docid FROM doc"
                    + " where pass='" + AMUUtilClass.getString(registrationForm.getPassword()) + "' "
                    + " AND email='" + AMUUtilClass.getString(registrationForm.getEmail())+ "';";
            System.out.println("Docotr login--"+ loginSQL);
            preparedStatement = con.prepareStatement(loginSQL);
            // execute select SQL stetement
            ResultSet resulset = preparedStatement.executeQuery();
            if (resulset.next()) {                
                docInfo = resulset.getString(1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AMUUtilClass.closeConnection(con);
            AMUUtilClass.closePSTMT(preparedStatement);
        }
        return docInfo;
    }
    
    public static String validatePatientLogin(AMUMainActionForm registrationForm) {
        Connection con = null;
        String docInfo = null;
        PreparedStatement preparedStatement = null;
        try {
            
            con = DBConnection.getConnection();
            String loginSQL = "SELECT patid FROM patient "
                     + " where pass='" + AMUUtilClass.getString(registrationForm.getPassword()) + "' "
                    + " AND email='" + AMUUtilClass.getString(registrationForm.getEmail())+ "';";
            System.out.println("loginSQL++ "+ loginSQL);
            preparedStatement = con.prepareStatement(loginSQL);
            // execute select SQL stetement
            ResultSet resulset = preparedStatement.executeQuery();
            if (resulset.next()) {                
                docInfo = resulset.getString(1) ;             
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AMUUtilClass.closeConnection(con);
            AMUUtilClass.closePSTMT(preparedStatement);
        }
        return docInfo;
    }
    
    
    public static List<DoctorVo> getDoctorList() {
        
        Connection con = null;         
        List<DoctorVo> doctorList  = new ArrayList();
        PreparedStatement preparedStatement = null;
        try {
            con = DBConnection.getConnection();
            String loginSQL = "SELECT docid, docname ,"
                    + " contactinfo.province,"
                    + " contactinfo.city, contactinfo.phoneno FROM doc"
                    + " INNER JOIN (contactinfo) ON "
                    + " (doc.docid = contactinfo.contact_reference)";
            System.out.println("Docotr select--"+ loginSQL);
            preparedStatement = con.prepareStatement(loginSQL);
            // execute select SQL stetement
            ResultSet resulset = preparedStatement.executeQuery();
            while(resulset.next()) { 
                DoctorVo vo = new DoctorVo();
                vo.setDocId(resulset.getString("docid"));
                vo.setDocName(resulset.getString("docname")+", "
                        + resulset.getString("contactinfo.phoneno")+", "
                        + resulset.getString("contactinfo.city")
                        + ", "+resulset.getString("contactinfo.province"));
                doctorList.add(vo);
            }
        } catch (Exception e) {             
        } finally {
            AMUUtilClass.closeConnection(con);
            AMUUtilClass.closePSTMT(preparedStatement);
        }
        return doctorList;
    }
    
    
    public static List<Country> getConutryList() {
        
        Connection con = null;         
        List<Country> countryList  = new ArrayList();
        PreparedStatement preparedStatement = null;
        try {
            con = DBConnection.getConnection();
            String sql = "SELECT country_id, country_name FROM country ";
            System.out.println("Country select--"+ sql);
            preparedStatement = con.prepareStatement(sql);
            // execute select SQL stetement
            ResultSet resulset = preparedStatement.executeQuery();
            while(resulset.next()) { 
                Country vo = new Country();
                vo.setCountryId(resulset.getString("country_id"));
                vo.setCountryName(resulset.getString("country_name"));
                countryList.add(vo);
            }
        } catch (Exception e) {             
        } finally {
            AMUUtilClass.closeConnection(con);
            AMUUtilClass.closePSTMT(preparedStatement);
        }
        return countryList;
    }
}
