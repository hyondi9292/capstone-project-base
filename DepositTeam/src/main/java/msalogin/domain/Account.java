package msalogin.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import msalogin.DepositTeamApplication;
import msalogin.domain.AccountUpdated;

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

    private String trnsCode;

    @PostPersist
    public void onPostPersist() {
        AccountUpdated accountUpdated = new AccountUpdated(this);
        accountUpdated.publishAfterCommit();
    }

    public static AccountRepository repository() {
        AccountRepository accountRepository = DepositTeamApplication.applicationContext.getBean(
            AccountRepository.class
        );
        return accountRepository;
    }
}
