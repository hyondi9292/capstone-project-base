package msalogin.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import msalogin.LoginApplication;
import msalogin.domain.BalanceRequested;
import msalogin.domain.LoginSucceeded;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "Login_table")
@Data
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bankingId;

    private String password;

    private String customerStatus;

    private String bankingStatus;

    private String customerId;

    private String accountNum;

    private String accountBal;

    private String accountStatus;

    private String islogin;

    @PostPersist
    public void onPostPersist() {
        LoginSucceeded loginSucceeded = new LoginSucceeded();
        BeanUtils.copyProperties(this, loginSucceeded);
        loginSucceeded.publishAfterCommit();

        BalanceRequested balanceRequested = new BalanceRequested();
        BeanUtils.copyProperties(this, balanceRequested);
        balanceRequested.publishAfterCommit();
        // Get request from Account
        //msalogin.external.Account account =
        //    Application.applicationContext.getBean(msalogin.external.AccountService.class)
        //    .getAccount(/** mapping value needed */);

    }

    public static LoginRepository repository() {
        LoginRepository loginRepository = LoginApplication.applicationContext.getBean(
            LoginRepository.class
        );
        return loginRepository;
    }
    // keep

}
