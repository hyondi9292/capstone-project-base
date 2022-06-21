package msalogin.domain;

public interface CustomerService {
    void createCustomer (String customerId, String Address, String Telno, String Name, String JuminNo);
    void deleteCustomer (String customerId);
    Customer getCustomer(String customerId);
    Customer save(String data);
}
