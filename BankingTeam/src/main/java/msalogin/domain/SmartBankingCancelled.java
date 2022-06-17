package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;


@Data

public class SmartBankingCancelled extends AbstractEvent {

  
    private Long customerId;
    private String status;

    public SmartBankingCancelled() {

        super();
    }
    // keep

}
