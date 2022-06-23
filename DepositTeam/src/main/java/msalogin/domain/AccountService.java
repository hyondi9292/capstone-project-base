package msalogin.domain;

public interface AccountService {
    void createAccount (String customerId);
    void deleteAccount (String customerId);
    Account getAccount(String customerId);
    Account save(String data);
}
