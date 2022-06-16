package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Data
public class CustomerCanceled extends AbstractEvent {

    private Long id;

    public CustomerCanceled() {
        super();
    }
    // keep

}
