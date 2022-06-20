package msalogin.domain;

public interface BalanceService {
    void increasedBalance (String customerId, int money);
    void decreasedBalance (String customerId, int money);
    Balance getBalance(String customerId);
    Balance save(String data);
}