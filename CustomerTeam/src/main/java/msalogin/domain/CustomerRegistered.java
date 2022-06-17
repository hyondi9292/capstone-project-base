package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Data
public class CustomerRegistered extends AbstractEvent {

<<<<<<< HEAD
    private Long CustomerId;
    private String Status;
=======
    private Long customerId;
    private String status;
>>>>>>> upstream/main

    public CustomerRegistered() {
        super();
    }
    // keep

}
