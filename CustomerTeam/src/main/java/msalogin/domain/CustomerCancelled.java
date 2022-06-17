package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

<<<<<<< HEAD

@Data
public class CustomerCancelled extends AbstractEvent {

    private Long CustomerId;
    private String Status;
=======
@Data
public class CustomerCancelled extends AbstractEvent {

    private Long customerId;
    private String status;
>>>>>>> upstream/main

    public CustomerCancelled() {
        super();
    }
    // keep

}
