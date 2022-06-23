package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.infra.AbstractEvent;

@Data
public class SmartBankingUpdated extends AbstractEvent {

    private String CustomerId;
    private String Status;
}
