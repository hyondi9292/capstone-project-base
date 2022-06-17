package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Data
public class AccountCreated extends AbstractEvent {

    private Long customerId;
    private String accountNo;
    private String accountBal;
    private String accountStatus;

    public AccountCreated() {
        super();
    }
    // keep

}
