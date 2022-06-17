package msalogin.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import msalogin.BankingTeamApplication;
import msalogin.domain.SmartBankingCancelled;
import msalogin.domain.SmartBankingRegistered;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "Smartbanking_table")
@Data
public class Smartbanking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    private String bankingId;

    private String password;

    private String status;

    @PostPersist
    public void onPostPersist() {
        SmartBankingRegistered smartBankingRegistered = new SmartBankingRegistered();
        BeanUtils.copyProperties(this, smartBankingRegistered);
        smartBankingRegistered.publishAfterCommit();

        SmartBankingCancelled smartBankingCancelled = new SmartBankingCancelled();
        BeanUtils.copyProperties(this, smartBankingCancelled);
        smartBankingCancelled.publishAfterCommit();
        // Get request from Customer
        //msalogin.external.Customer customer =
        //    Application.applicationContext.getBean(msalogin.external.CustomerService.class)
        //    .getCustomer(/** mapping value needed */);

    }

    public static SmartbankingRepository repository() {
        SmartbankingRepository smartbankingRepository = BankingTeamApplication.applicationContext.getBean(
            SmartbankingRepository.class
        );
        return smartbankingRepository;
    }

    public static void customerStatusCanceledCancle(
        CustomerCancelled customerCancelled
    ) {
        Smartbanking smartbanking = new Smartbanking();
        /*
        LOGIC GOES HERE
        */
        // repository().save(smartbanking);

    }
    // keep

}
