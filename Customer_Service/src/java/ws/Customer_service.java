package ws;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author isurianuradha
 */
@WebService(serviceName = "Customer_service")
public class Customer_service {

    DatabaseConnectionTest db = new DatabaseConnectionTest();//creating a new DatabaseConnection objrct
    Statement stmt;

    /**
     * Web service operation
     *
     * @param name
     * @param birthday
     */
    @WebMethod(operationName = "create_customer")
    public boolean create_customer(@WebParam(name = "name") String name, @WebParam(name = "birthday") String birthday,
            @WebParam(name = "address") String address, @WebParam(name = "mobile") int mobile, @WebParam(name = "eMail") String eMail, @WebParam(name = "accountType") String accountType,
            @WebParam(name = "accountNumber") String accountNumber, @WebParam(name = "sortCode") String sortCode, @WebParam(name = "balance") String balance, @WebParam(name = "card") String card) {

        //TODO write your implementation code here:
        try {
            PreparedStatement state = db.db_Connect().prepareStatement("insert into customer values(?,?,?,?,?,?,?,?,?,?)");//insert data
            state.setString(1, name);
            state.setString(2, birthday);
            state.setString(3, address);
            state.setInt(4, mobile);
            state.setString(5, eMail);
            state.setString(6, accountType);
            state.setString(7, accountNumber);
            state.setString(8, sortCode);
            state.setString(9, balance);
            state.setString(10, card);
            state.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "display_cus_list")
    public String[] display_cus_list() {

        String[] cust;

        try {
            //try{
            Statement state = db.db_Connect().createStatement();//retrieves data
            ResultSet rs = state.executeQuery("SELECT COUNT(*) FROM customer");
            rs.next();

            int rowCount = rs.getInt(1);
            System.out.println(rowCount);

            String sql = "SELECT * FROM customer";
            ResultSet rs1 = state.executeQuery(sql);
            rs1.next();

            cust = new String[rowCount];

            int x = 0;
            while (x < rowCount) {

                cust[x] = rs1.getString("name") + "-" + rs1.getString("accountNumber") + "-" + rs1.getString("birthday") + "-" + rs1.getString("address")
                        + "-" + rs1.getString("mobile") + "-" + rs1.getString("email") + "-" + rs1.getString("accountType")
                        + "-" + rs1.getString("sortCode") + "-" + rs1.getString("balance")
                        + "-" + rs1.getString("card");
                rs1.next();

                x++;

            }
            return cust;
        } catch (SQLException ex) {
            Logger.getLogger(Customer_service.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "delete_customer")
    public boolean delete_customer(@WebParam(name = "name") String name, @WebParam(name = "accountNumber") String accountNumber) {
        try {
            PreparedStatement state = db.db_Connect().prepareStatement("delete from customer where name=? AND accountNumber=?"); //delete specific row
            state.setString(1, name);
            state.setString(2, accountNumber);
            state.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "update_customer")
    public boolean update_customer(@WebParam(name = "name") String name, @WebParam(name = "birthday") String birthday,
            @WebParam(name = "address") String address, @WebParam(name = "mobile") int mobile, @WebParam(name = "email") String mail,
            @WebParam(name = "accountType") String accountType, @WebParam(name = "sortCode") String sortCode,
            @WebParam(name = "balance") String balance, @WebParam(name = "card") String card, @WebParam(name = "accountNumber") String acNumber) {
        try {

            stmt = db.db_Connect().createStatement();
            

            String sql_command = "Update customer set name=?, birthday=?, address=?, mobile=?, email=?, accountType=?,sortCode=?,balance=?,card=? WHERE accountNumber=?";
            PreparedStatement pst = db.db_Connect().prepareStatement(sql_command);

            pst.setString(1, name);
            pst.setString(2, birthday);
            pst.setString(3, address);
            pst.setInt(4, mobile);
            pst.setString(5, mail);
            pst.setString(6, accountType);
            pst.setString(7, sortCode);
            pst.setString(8, balance);
            pst.setString(9, card);
            pst.setString(10, acNumber);

            int updateResult = pst.executeUpdate();

            if (updateResult == 1) {
            } else {
            }
            // return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
