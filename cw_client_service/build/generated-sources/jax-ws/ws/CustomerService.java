
package ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Customer_service", targetNamespace = "http://ws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CustomerService {


    /**
     * 
     * @param birthday
     * @param address
     * @param balance
     * @param accountType
     * @param name
     * @param mobile
     * @param accountNumber
     * @param sortCode
     * @param card
     * @param eMail
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "create_customer")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "create_customer", targetNamespace = "http://ws/", className = "ws.CreateCustomer")
    @ResponseWrapper(localName = "create_customerResponse", targetNamespace = "http://ws/", className = "ws.CreateCustomerResponse")
    @Action(input = "http://ws/Customer_service/create_customerRequest", output = "http://ws/Customer_service/create_customerResponse")
    public boolean createCustomer(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "birthday", targetNamespace = "")
        String birthday,
        @WebParam(name = "address", targetNamespace = "")
        String address,
        @WebParam(name = "mobile", targetNamespace = "")
        int mobile,
        @WebParam(name = "eMail", targetNamespace = "")
        String eMail,
        @WebParam(name = "accountType", targetNamespace = "")
        String accountType,
        @WebParam(name = "accountNumber", targetNamespace = "")
        String accountNumber,
        @WebParam(name = "sortCode", targetNamespace = "")
        String sortCode,
        @WebParam(name = "balance", targetNamespace = "")
        String balance,
        @WebParam(name = "card", targetNamespace = "")
        String card);

    /**
     * 
     * @param name
     * @param accountNumber
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "delete_customer")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "delete_customer", targetNamespace = "http://ws/", className = "ws.DeleteCustomer")
    @ResponseWrapper(localName = "delete_customerResponse", targetNamespace = "http://ws/", className = "ws.DeleteCustomerResponse")
    @Action(input = "http://ws/Customer_service/delete_customerRequest", output = "http://ws/Customer_service/delete_customerResponse")
    public boolean deleteCustomer(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "accountNumber", targetNamespace = "")
        String accountNumber);

    /**
     * 
     * @param birthday
     * @param address
     * @param balance
     * @param accountType
     * @param name
     * @param mobile
     * @param accountNumber
     * @param sortCode
     * @param email
     * @param card
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "update_customer")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "update_customer", targetNamespace = "http://ws/", className = "ws.UpdateCustomer")
    @ResponseWrapper(localName = "update_customerResponse", targetNamespace = "http://ws/", className = "ws.UpdateCustomerResponse")
    @Action(input = "http://ws/Customer_service/update_customerRequest", output = "http://ws/Customer_service/update_customerResponse")
    public boolean updateCustomer(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "birthday", targetNamespace = "")
        String birthday,
        @WebParam(name = "address", targetNamespace = "")
        String address,
        @WebParam(name = "mobile", targetNamespace = "")
        int mobile,
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "accountType", targetNamespace = "")
        String accountType,
        @WebParam(name = "sortCode", targetNamespace = "")
        String sortCode,
        @WebParam(name = "balance", targetNamespace = "")
        String balance,
        @WebParam(name = "card", targetNamespace = "")
        String card,
        @WebParam(name = "accountNumber", targetNamespace = "")
        String accountNumber);

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod(operationName = "display_cus_list")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "display_cus_list", targetNamespace = "http://ws/", className = "ws.DisplayCusList")
    @ResponseWrapper(localName = "display_cus_listResponse", targetNamespace = "http://ws/", className = "ws.DisplayCusListResponse")
    @Action(input = "http://ws/Customer_service/display_cus_listRequest", output = "http://ws/Customer_service/display_cus_listResponse")
    public List<String> displayCusList();

}
