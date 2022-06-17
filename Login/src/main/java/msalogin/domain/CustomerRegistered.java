package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.infra.AbstractEvent;

@Data
public class CustomerRegistered extends AbstractEvent {

    private Long CustomerId;
    private String Status;
    public Object getCustomerId() {
        return null;
    }
    public Long getId() {
        return null;
    }
}
