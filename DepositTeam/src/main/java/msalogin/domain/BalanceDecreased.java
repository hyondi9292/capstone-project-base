package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.infra.AbstractEvent;

@Data
public class BalanceDecreased extends AbstractEvent {

    private Long customerId;
    private String accountNo;
    private String accountBal;

    public BalanceDecreased() {
        super();
    }
    // keep

}
