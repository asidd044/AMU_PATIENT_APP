package com.cmu.utils;
 
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.sql.Connection;
import java.sql.ResultSet;
 

/**
 *
 * @author Amulya
 */
public class AMUUtilClass {
    //static final String LucenDirectory = "C:\\lucene\\test\\index";

    public static String getString(String value) {

        if ("null".equals(value)) {
            return "";
        } else if (value == null) {
            return "";
        } else {
            return value;
        }
    }

    public static boolean isStringEmpty(String value) {
        try {
            if (null == value) {
                System.out.println("return empty ");
                return false;
            }else if ("null".equals(value)) {
                System.out.println("return empty ");
                return false;
            }else if ("".equals(value)) {
                System.out.println("return empty ");
                return false;
            } else {
                System.out.println("getvalue " + value);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static String getStringArray(String[] value) {
        try {
            String newValue = "";
            if (value.length == 0 || value == null) {
                return "";
            } else {
                int length = value.length;
                for (int valueIndex = 0; valueIndex < length; valueIndex++) {
                    newValue += value[valueIndex] + ",";
                }
                return newValue;
            }
        } catch (Exception e) {
            return "";
        }
    }

    public static int getIntValue(String value) {

        if (value == null || "".equals(value)) {
            return 0;
        } else {
            return (int) Integer.parseInt(value);
        }
    }

    public static int getIntValue(int value) {

        if (value == 0) {
            return 0;
        } else {
            return value;
        }
    }

    public static int getCheckBoxValue(String value) {
        if ("on".equalsIgnoreCase(value)) {
            return 1;
        } else {
            return 0;
        }

    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void closePSTMT(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static String getUniqueId() {
        UUID u = UUID.randomUUID();
        return toIDString(u.getMostSignificantBits()) + toIDString(u.getLeastSignificantBits());
    }

    private static String toIDString(long i) {
        char[] buf = new char[32];
        int z = 64; // 1 << 6;
        int cp = 32;
        long b = z - 1;
        do {
            buf[--cp] = DIGITS66[(int) (i & b)];
            i >>>= 6;
        } while (i != 0);
        return new String(buf, cp, (32 - cp)).substring(0, 4).replaceAll("[^a-zA-Z]", "");
    }

    // array de 64+2 digitos 
    private final static char[] DIGITS66 = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '-', '.', '_', '~'
    };

    public static java.sql.Date retunSqlDate(String sdate) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = formatter.parse(sdate);
            return new java.sql.Date(date.getTime());

        } catch (Exception e) {
        }
        return null;
    }

    public static String getErypriptString(String text)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md;
        md = MessageDigest.getInstance("SHA-1");
        byte[] sha1hash = new byte[40];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        sha1hash = md.digest();
        return convertToHex(sha1hash);
    }

    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    /**
     * retrun time stamp of date and time.
     *
     * @return
     */
    public static java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }

    public static String returnNormalDate(String start) {
        String mysqlString = "";
        try {
            SimpleDateFormat startFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat toFormat = new SimpleDateFormat("dd/MMM/yyyy");
            Date date = startFormat.parse(start);
            mysqlString = toFormat.format(date);
        } catch (Exception e) {
        }
        return mysqlString;
    }

}
