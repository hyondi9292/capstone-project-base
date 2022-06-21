package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.infra.AbstractEvent;

@Data
public class BalanceDecreased extends AbstractEvent {

    private String CustomerId;
    private String AccountNo;
    private String AccountBal;
    public String getAccountNo() {
        return AccountNo;
    }
    public String getCustomerId() {
        return CustomerId;
    }
    public String getAccountBal() {
        return AccountBal;
    }
}
