package jologin.domain;

import java.util.Date;
import jologin.domain.*;
import jologin.infra.AbstractEvent;
import lombok.Data;

@Data
public class CustomerRegistered extends AbstractEvent {

    private Long customerId;
    private String status;

    public CustomerRegistered() {
        super();
    }
    // keep

}
