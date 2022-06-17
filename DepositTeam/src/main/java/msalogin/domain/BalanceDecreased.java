package msalogin.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Entity
@Table(name = "AccountList_Base")
@Data
public class BalanceDecreased extends AbstractEvent {

    @Id
    private Long customerId;
    @Column
    private String accountNo;
    @Column
    private String accountBal;

    public BalanceDecreased() {
        super();
    }
    // keep

}
