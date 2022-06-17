package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Data
public class SmartBankingCanceled extends AbstractEvent {

    private Long customerId;
    private String status;

    public SmartBankingCanceled() {
        super();
    }
    // keep

}
