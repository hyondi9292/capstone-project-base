package msalogin.domain;

public interface AccountService {
    void createAccount (String customerId, String accountNo, String accountBal, String accountStatus, String trnsCode);
    void deleteAccount (String customerId);
    Account getAccount(String customerId);
    Account save(String data);
}
