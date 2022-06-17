package msalogin.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import msalogin.CustomerTeamApplication;
import msalogin.domain.CustomerCancelled;
import msalogin.domain.CustomerRegistered;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "Customer_table")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    private String status;

    private String address;

    private String telNo;

    private String name;

    private String juminNo;

    @PostPersist
    public void onPostPersist() {
        CustomerRegistered customerRegistered = new CustomerRegistered();
        BeanUtils.copyProperties(this, customerRegistered);
        customerRegistered.publishAfterCommit();

        CustomerCancelled customerCancelled = new CustomerCancelled();
        BeanUtils.copyProperties(this, customerCancelled);
        customerCancelled.publishAfterCommit();
        // Get request from Account
        //msalogin.external.Account account =
        //    Application.applicationContext.getBean(msalogin.external.AccountService.class)
        //    .getAccount(/** mapping value needed */);

    }

    public static CustomerRepository repository() {
        CustomerRepository customerRepository = CustomerTeamApplication.applicationContext.getBean(
            CustomerRepository.class
        );
        return customerRepository;
    }
    // keep

}
