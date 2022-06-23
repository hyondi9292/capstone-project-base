package msalogin.domain;

public interface CustomerService {
    void createCustomer (String customerId, String address, String telNo, String name, String juminNo);
    void deleteCustomer (String customerId);
    Customer getCustomer(String customerId);
    Customer save(String data);

}
