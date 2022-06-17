package msalogin.domain;

import java.util.Date;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Entity
@Table(name = "AccountList_Base")
@Data
@Getter
@Setter
public class Balance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column
    private String accountNo;
    @Column
    private String accountBal;
    @Column
    private String accountStatus;
    @Column
    private String customerId;

    @PostPersist
    public void onPostPersist(){
        BalanceIncreased balanceIncreased = new BalanceIncreased();
        BeanUtils.copyProperties(this, balanceIncreased);
        balanceIncreased.publishAfterCommit();
    }

}

