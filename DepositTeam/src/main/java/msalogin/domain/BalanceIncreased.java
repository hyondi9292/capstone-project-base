package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Data
public class BalanceIncreased extends AbstractEvent {

    private String customerId;
    private String accountNo;
    private String accountBal;

    public BalanceIncreased() {
        super();
    }
    // keep

}
