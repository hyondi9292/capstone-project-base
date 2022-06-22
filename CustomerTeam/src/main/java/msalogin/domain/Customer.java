package msalogin.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import msalogin.CustomerTeamApplication;
import msalogin.domain.CustomerCancelled;
import msalogin.domain.CustomerRegistered;

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
        CustomerRegistered customerRegistered = new CustomerRegistered(this);
        customerRegistered.publishAfterCommit();
        // Get request from Customerinfo
        //msalogin.external.Customerinfo customerinfo =
        //    Application.applicationContext.getBean(msalogin.external.CustomerinfoService.class)
        //    .getCustomerinfo(/** mapping value needed */);

    }

    @PreRemove
    public void onPreRemove() {
        CustomerCancelled customerCancelled = new CustomerCancelled(this);
        customerCancelled.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        msalogin.external.Account account = new msalogin.external.Account();
        // mappings goes here
        CustomerTeamApplication.applicationContext
            .getBean(msalogin.external.AccountService.class)
            .deposit(account);
    }

    public static CustomerRepository repository() {
        CustomerRepository customerRepository = CustomerTeamApplication.applicationContext.getBean(
            CustomerRepository.class
        );
        return customerRepository;
    }
}
