package msalogin.domain;

public interface SmartbankingService {
    void createSmartBanking (String customerId, String bankingId, String password);
    void deleteSmartBanking (String customerId);
    Smartbanking getSmartBanking(String customerId);
    Smartbanking save(String data);
}

