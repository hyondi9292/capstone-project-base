package msalogin.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import msalogin.BankingTeamApplication;
import msalogin.domain.SmartBankingUpdated;

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
        SmartBankingUpdated smartBankingUpdated = new SmartBankingUpdated(this);
        smartBankingUpdated.publishAfterCommit();
    }

    public static SmartbankingRepository repository() {
        SmartbankingRepository smartbankingRepository = BankingTeamApplication.applicationContext.getBean(
            SmartbankingRepository.class
        );
        return smartbankingRepository;
    }

    public static void cusRegistered(CustomerRegistered customerRegistered) {
        /** Example 1:  new item 
        Smartbanking smartbanking = new Smartbanking();
        repository().save(smartbanking);

        */

        /** Example 2:  finding and process
        
        repository().findById(customerRegistered.get???()).ifPresent(smartbanking->{
            
            smartbanking // do something
            repository().save(smartbanking);


         });
        */

    }
}
