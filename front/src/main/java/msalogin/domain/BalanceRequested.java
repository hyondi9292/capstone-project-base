package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Data
public class BalanceRequested extends AbstractEvent {

    private Long id;
    private String accountNo;
    private String accountBal;

    public BalanceRequested() {
        super();
    }
    // keep

}
