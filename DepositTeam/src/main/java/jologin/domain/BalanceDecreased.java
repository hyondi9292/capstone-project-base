package jologin.domain;

import java.util.Date;
import jologin.domain.*;
import jologin.infra.AbstractEvent;
import lombok.Data;

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
