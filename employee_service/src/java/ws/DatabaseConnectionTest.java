/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CHARITHA
 */
public class DatabaseConnectionTest {

    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static String db_URL = "jdbc:mysql://localhost:3306/sys";
    public String db_Username = "root";
    public String db_Password = "root";
    public static Connection con;
//    public static void main(String[] args) {
//        SQL_Connection sc = new SQL_Connection();
//        sc.db_Connect();
//    }

    public Connection db_Connect() {

        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(db_URL, db_Username, db_Password);
            if (con != null) {
                System.out.println("Database Connected Successfully !!!");

            }

        } catch (SQLException e) {
            System.out.println(e);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;

    }

    public static void main(String[] args) throws SQLException {
        DatabaseConnectionTest db = new DatabaseConnectionTest();
        db.db_Connect();
  
    }

}
