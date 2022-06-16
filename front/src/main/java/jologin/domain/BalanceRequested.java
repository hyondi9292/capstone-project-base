package jologin.domain;

import java.util.Date;
import jologin.domain.*;
import jologin.infra.AbstractEvent;
import lombok.Data;

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
