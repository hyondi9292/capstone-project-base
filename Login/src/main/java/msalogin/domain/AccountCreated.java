package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.infra.AbstractEvent;

@Data
public class AccountCreated extends AbstractEvent {

    private Long CustomerId;
    private String AccountNo;
    private String AccountBal;
    private String AccountStatus;
    public Long getId() {
        return null;
    }
    public Object getAccountNo() {
        return null;
    }
}
