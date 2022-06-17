package msalogin.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import msalogin.DepositTeamApplication;
import msalogin.domain.AccountCreated;
import msalogin.domain.BalanceDecreased;
import msalogin.domain.BalanceIncreased;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "Account_table")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    private String accountNo;

    private String accountBal;

    private String accountStatus;

    @PostPersist
    public void onPostPersist() {
        /*
        BalanceDecreased balanceDecreased = new BalanceDecreased();
        BeanUtils.copyProperties(this, balanceDecreased);
        balanceDecreased.publishAfterCommit();

        BalanceIncreased balanceIncreased = new BalanceIncreased();
        BeanUtils.copyProperties(this, balanceIncreased);
        balanceIncreased.publishAfterCommit();
        */
        AccountCreated accountCreated = new AccountCreated();
        BeanUtils.copyProperties(this, accountCreated);
        accountCreated.publishAfterCommit();
    }

    public static AccountRepository repository() {
        AccountRepository accountRepository = DepositTeamApplication.applicationContext.getBean(
            AccountRepository.class
        );
        return accountRepository;
    }
    // keep

}
