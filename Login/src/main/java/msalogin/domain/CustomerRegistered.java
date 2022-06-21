package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.infra.AbstractEvent;

@Data
public class CustomerRegistered extends AbstractEvent {

    private String CustomerId;
    private String Status;

    public String getCustomerId() {
        return CustomerId;
    }

    public String getStatus() {
        return Status;
    }
    
}
