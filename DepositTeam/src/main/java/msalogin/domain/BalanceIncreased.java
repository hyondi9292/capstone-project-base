package msalogin.domain;

import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Getter
@Setter
@Data
public class BalanceIncreased extends AbstractEvent {

    private Long customerId;
    private String accountNo;
    private String accountBal;

    public BalanceIncreased() {
        super();
    }
    // keep

}
