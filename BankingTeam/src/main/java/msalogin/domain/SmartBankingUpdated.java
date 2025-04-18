package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Data
public class SmartBankingUpdated extends AbstractEvent {

    private String customerId;
    private String status;
    private String bankingId;
    private String password;

    public SmartBankingUpdated() {
        super();
    }
    // keep

}
