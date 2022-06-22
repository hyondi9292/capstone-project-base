package msalogin.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import msalogin.LoginApplication;
import msalogin.domain.LoginSucceeded;

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
        LoginSucceeded loginSucceeded = new LoginSucceeded(this);
        loginSucceeded.publishAfterCommit();
    }

    public static LoginRepository repository() {
        LoginRepository loginRepository = LoginApplication.applicationContext.getBean(
            LoginRepository.class
        );
        return loginRepository;
    }

    public static void updatelogintable(
        SmartBankingUpdated smartBankingUpdated
    ) {
        /** Example 1:  new item 
        Login login = new Login();
        repository().save(login);

        */

        /** Example 2:  finding and process
        
        repository().findById(smartBankingUpdated.get???()).ifPresent(login->{
            
            login // do something
            repository().save(login);


         });
        */

    }

    public static void updatelogintable(AccountUpdated accountUpdated) {
        /** Example 1:  new item 
        Login login = new Login();
        repository().save(login);

        */

        /** Example 2:  finding and process
        
        repository().findById(accountUpdated.get???()).ifPresent(login->{
            
            login // do something
            repository().save(login);


         });
        */

    }

    public static void updatelogintable(CustomerRegistered customerRegistered) {
        /** Example 1:  new item 
        Login login = new Login();
        repository().save(login);

        */

        /** Example 2:  finding and process
        
        repository().findById(customerRegistered.get???()).ifPresent(login->{
            
            login // do something
            repository().save(login);


         });
        */

    }

    public static void updatelogintable(CustomerCancelled customerCancelled) {
        /** Example 1:  new item 
        Login login = new Login();
        repository().save(login);

        */

        /** Example 2:  finding and process
        
        repository().findById(customerCancelled.get???()).ifPresent(login->{
            
            login // do something
            repository().save(login);


         });
        */

    }
}
