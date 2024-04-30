package db;

import java.sql.*;
import java.util.Arrays;

//"jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS_LIST =(ADDRESS =(PROTOCOL=TCP)"
//        + "(HOST=" + this.dbIp + ")(PORT=1521)))(CONNECT_DATA=(SID=rpgzdb)(SERVER=DEDICATED)))";

public class DbConection {



    private final static String urlDb1 = "jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS_LIST =(ADDRESS =(PROTOCOL=TCP)"
            + "(HOST=" + "192.168.233.51" + ")(PORT=1521)))(CONNECT_DATA=(SID=pgzdb)(SERVER=DEDICATED)))";


    public final static String getOrganization = "SELECT ORGANIZATION_CODE, MAIN_ORG_ID," +
            "SVR_ID, ORGANIZATION_TYPE_ID, SUBORDINATION_TYPE_ID FROM ZAKUPKI_DEV.ORGANIZATION where inn ='0997395962'";


    private DbConection() {
    }

    public static Connection open(String url, String username, String password) {
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.get(url),
                    PropertiesUtil.get(username),
                    PropertiesUtil.get(password)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public static void getResult(String query) {
//        try (Connection conn = DriverManager.getConnection(urlDb1, USERNAME_KEY, PASSWORD_KEY);
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(query)) {
//
//
//            while (rs.next()) {
//                System.out.println(rs.getString("ORGANIZATION_CODE"));
//                System.out.println(rs.getInt("MAIN_ORG_ID"));
//                System.out.println(rs.getInt("SVR_ID"));
//                System.out.println(rs.getInt("ORGANIZATION_TYPE_ID"));
//                System.out.println(rs.getInt("SUBORDINATION_TYPE_ID"));
//            }
//
//        } catch (Exception e) {
//            System.out.println(e.fillInStackTrace());
//            System.out.println(e.getMessage());
//        }
//    }

    public static void getConnection() {


    }


}

