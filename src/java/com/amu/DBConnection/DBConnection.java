package com.amu.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Amulya
 */
public class DBConnection {
   
////  
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/amu_patient_app";
//    //Database credentials
    static final String USER = "root";
    static final String PASS = "root";
   
    private static Connection conn;

    private static Connection CreateNewConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("Problem in connecting to DataBase :" + e);
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = CreateNewConnection();
        }
        return conn;
    }

    public static void main(String[] asd) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement preparedStatementPSTMT = null;
            String country = "Afghanistan,Albania,Algeria,Andorra,Angola,Antigua and Barbuda,Argentina,Armenia,Australia,Austria,Azerbaijan,Bahamas,Bahrain,Bangladesh,Barbados,Belarus,Belgium,Belize,Benin,Bhutan,Bolivia,BosniaandHerzegovina,Botswana,Brazil,Brunei,Bulgaria,BurkinaFaso,Burundi,CaboVerde,Cambodia,Cameroon,Canada,CentralAfricanRepublic,Chad,Chile,China,Colombia,Comoros,Congo,Republicofthe,Congo,DemocraticRepublicofthe,CostaRica,Coted'Ivoire,Croatia,Cuba,Cyprus,CzechRepublic,Denmark,Djibouti,Dominica,DominicanRepublic,Ecuador,Egypt,ElSalvador,EquatorialGuinea,Eritrea,Estonia,Ethiopia,Fiji,Finland,France,Gabon,Gambia,Georgia,Germany,Ghana,Greece,Grenada,Guatemala,Guinea,Guinea-Bissau,Guyana,Haiti,Honduras,Hungary,Iceland,India,Indonesia,Iran,Iraq,Ireland,Israel,Italy,Jamaica,Japan,Jordan,Kazakhstan,Kenya,Kiribati,Kosovo,Kuwait,Kyrgyzstan,Laos,Latvia,Lebanon,Lesotho,Liberia,Libya,Liechtenstein,Lithuania,Luxembourg,Macedonia,Madagascar,Malawi,Malaysia,Maldives,Mali,Malta,MarshallIslands,Mauritania,Mauritius,Mexico,Micronesia,Moldova,Monaco,Mongolia,Montenegro,Morocco,Mozambique,Myanmar(Burma),Namibia,Nauru,Nepal,Netherlands,NewZealand,Nicaragua,Niger,Nigeria,NorthKorea,Norway,Oman,Pakistan,Palau,Palestine,Panama,PapuaNewGuinea,Paraguay,Peru,Philippines,Poland,Portugal,Qatar,Romania,Russia,Rwanda,St.KittsandNevis,St.Lucia,St.VincentandTheGrenadines,Samoa,SanMarino,SaoTomeandPrincipe,SaudiArabia,Senegal,Serbia,Seychelles,SierraLeone,Singapore,Slovakia,Slovenia,SolomonIslands,Somalia,SouthAfrica,SouthKorea,SouthSudan,Spain,SriLanka,Sudan,Suriname,Swaziland,Sweden,Switzerland,Syria,Taiwan,Tajikistan,Tanzania,Thailand,Timor-Leste,Togo,Tonga,TrinidadandTobago,Tunisia,Turkey,Turkmenistan,Tuvalu,Uganda,Ukraine,UnitedArabEmirates,UK(UnitedKingdom),USA(UnitedStatesofAmerica),Uruguay,Uzbekistan,Vanuatu,VaticanCity(HolySee),Venezuela,Vietnam,Yemen,Zambia,Zimbabwe";
           // String [] arrCountry =  country.split(",");
            
            List<String> list =  Arrays.asList(country.split(","));
            
            for (String list1 : list) {
            
                String query = "INSERT INTO"
                        + " amu_patient_app.country "
                        + "(country_id, country_name)"
                        + "VALUES "
                        + "("+0+", '"+list1+"');";
                
                preparedStatementPSTMT = con.prepareStatement(query);
               
                preparedStatementPSTMT.executeUpdate();
            }
            System.out.println(""+ con);
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
