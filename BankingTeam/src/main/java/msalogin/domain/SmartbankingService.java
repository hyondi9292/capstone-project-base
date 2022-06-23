package msalogin.domain;

public interface SmartbankingService {
    void createSmartBanking (String customerId, String bankingId, String password, String status);
    void deleteSmartBanking (String customerId);
    Smartbanking getSmartBanking(String customerId);
    Smartbanking save(String data);
}

