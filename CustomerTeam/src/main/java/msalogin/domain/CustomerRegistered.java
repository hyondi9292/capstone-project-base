package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Data
public class CustomerRegistered extends AbstractEvent {

    private String CustomerId;
    private String Status;

    public CustomerRegistered() {
        super();
    }
    // keep

}
