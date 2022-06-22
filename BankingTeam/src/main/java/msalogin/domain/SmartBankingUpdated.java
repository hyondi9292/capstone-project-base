package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Data
public class SmartBankingUpdated extends AbstractEvent {

    private Long customerId;
    private String status;

    public SmartBankingUpdated(Smartbanking aggregate) {
        super(aggregate);
    }

    public SmartBankingUpdated() {
        super();
    }
    // keep

}
