package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Data
public class AccountUpdated extends AbstractEvent {

    private Long customerId;
    private String accountNo;
    private String accountBal;
    private String accountStatus;
    private String trnsCode;

    public AccountUpdated(Account aggregate) {
        super(aggregate);
    }

    public AccountUpdated() {
        super();
    }
    // keep

}
