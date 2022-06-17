package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Data
public class CustomerCancelled extends AbstractEvent {

    private Long CustomerId;
    private String Status;
    // keep

}
