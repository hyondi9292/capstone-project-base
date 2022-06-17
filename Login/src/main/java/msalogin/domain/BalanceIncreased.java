package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.infra.AbstractEvent;

@Data
public class BalanceIncreased extends AbstractEvent {

    private Long CustomerId;
    private String AccountNo;
    private String AccountBal;
    public String getAccountNo() {
        return null;
    }
    public Object getAccountBal() {
        return null;
    }
}
