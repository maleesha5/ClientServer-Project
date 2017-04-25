/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author isurianuradha
 */
@WebService(serviceName = "employee_ser")
public class employee_ser {

    DatabaseConnectionTest db = new DatabaseConnectionTest();//creating a new DatabaseConnection objrct
    Statement stmt;

    /**
     * This is a sample web service operation
     */
    /*@WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }*/
    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) throws InvalidInputException {
        try {
            PreparedStatement pst = db.db_Connect().prepareStatement("Select * from employee where username=? and password=?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                throw new InvalidInputException("Wrong input credentials!", username + "or" + password + "is incorrect");
            }
            // return false;
        } catch (Exception e) {
            return false;
        }
        /*try{
            stmt = db.db_Connect().createStatement();
            String sql;
            sql = "SELECT * from employee where username = '"+username+"' AND password = '"+password+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next()){
                return true;
            }
            else
                throw new InvalidInputException("Wrong input credentials!", username + "or" + password + "is incorrect");
               // return false;
        }catch(Exception e){
            return false;
        }*/
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "create_employee")
    public boolean create_employee(@WebParam(name = "name") String name, @WebParam(name = "position") String position, @WebParam(name = "username") String username, @WebParam(name = "Password") String Password, @WebParam(name = "repeatpassword") String repeatpassword) {
        try {
            PreparedStatement state = db.db_Connect().prepareStatement("insert into employee values(?,?,?,?,?)");//insert data
            state.setString(1, name);
            state.setString(2, position);
            state.setString(3, username);
            state.setString(4, Password);
            state.setString(5, repeatpassword);
            state.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "delete")
    public boolean delete(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        try {
            PreparedStatement state = db.db_Connect().prepareStatement("DELETE from employee where username=? AND password=?"); //delete specific row
            state.setString(1, username);
            state.setString(2, password);
            int rs = state.executeUpdate();

            if (rs == 1) {

                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "update_emp")
    public boolean update_emp(@WebParam(name = "name") String name, @WebParam(name = "position") String position,
            @WebParam(name = "username") String username, @WebParam(name = "Password") String Password, @WebParam(name = "repeatpassword") String repeatpassword) {

        try {

            stmt = db.db_Connect().createStatement();
            //String sql;
            /* sql = "UPDATE employee SET name = '" + name + "' position = '" + position 
                    + "'password = '" + Password + "' repeatpassword = '" + repeatpassword 
                    + "' WHERE username = '" + username + "'";*/

            String sql_command = "Update employee set name=?, position=?, password=?, repeatpassword=? WHERE username=?";
            PreparedStatement pst = db.db_Connect().prepareStatement(sql_command);

            pst.setString(1, name);
            pst.setString(2, position);
            pst.setString(3, Password);
            pst.setString(4, repeatpassword);
            pst.setString(5, username);

            int updateResult = pst.executeUpdate();

            if (updateResult == 1) {
                return true;
            } else {
                throw new InvalidInputException("Wrong input credentials!", username + "or" + Password + "is incorrect");
            }
            // return false;
        } catch (Exception e) {
            return false;
        }

    }

}
