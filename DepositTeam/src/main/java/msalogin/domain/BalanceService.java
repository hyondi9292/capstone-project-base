package msalogin.domain;

public interface BalanceService {
    void increasedBalance (String accountNo, int money);
    void decreasedBalance (String accountNo, int money);
    Balance getBalanceById(String accountNo);
    Balance save(String data);
}