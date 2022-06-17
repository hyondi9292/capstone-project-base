package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerList_Base")
@Data
public class CustomerCancelled extends AbstractEvent {

    @Id
    private Long customerId;
    @Column
    private String status;

    public CustomerCancelled() {
        super();
    }
    // keep

}
