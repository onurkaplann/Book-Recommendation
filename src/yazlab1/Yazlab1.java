package yazlab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Yazlab1 {

    private static String kullaniciadi = "root";
    private static String parola = "";
    private static String host = "127.0.0.1";
    private static String db = "test";
    private static int port = 3306;
    private static Connection conn = null;
    private static ResultSet rs = null;
    private static Statement pst = null;

    public static void main(String[] args) {
        String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("mysql connector yok");
            e.printStackTrace();
        }
        try {
            conn = (Connection) DriverManager.getConnection(url, kullaniciadi, parola);
        } catch (SQLException e) {
            System.out.println("Baglanti basarisiz");
            e.printStackTrace();
        }
        if (conn != null) {
            System.out.println("basardik");
        } else {
            System.out.println("basarisiz");
        }
    }
}
