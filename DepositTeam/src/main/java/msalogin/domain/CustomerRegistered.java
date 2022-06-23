package msalogin.domain;

import lombok.Data;
import msalogin.infra.AbstractEvent;

@Data
public class CustomerRegistered extends AbstractEvent{

    private String customerId;
    private String status;

    public CustomerRegistered() {
        super();
    }
    // keep
}
