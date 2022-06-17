package msalogin.domain;

import javax.persistence.Column;
import javax.persistence.Id;


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
