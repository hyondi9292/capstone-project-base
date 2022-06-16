package jologin.domain;

import java.util.Date;
import jologin.domain.*;
import jologin.infra.AbstractEvent;
import lombok.Data;

@Data
public class CustomerCanceled extends AbstractEvent {

    private Long id;

    public CustomerCanceled() {
        super();
    }
    // keep

}
