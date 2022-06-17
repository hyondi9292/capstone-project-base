package msalogin.domain;

import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import msalogin.CustomerTeamApplication;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "CustomerList_Base")
@Data
public class Customer {

    @Id
    private Long CustomerId;
    @Column
    private String Status;
    @Column
    private String Address;
    @Column
    private String Telno;
    @Column
    private String Name;
    @Column
    private String JuminNo;

    @PostPersist
    public void onPostPersist() {
        CustomerRegistered customerRegistered = new CustomerRegistered();
        BeanUtils.copyProperties(this, customerRegistered);
        customerRegistered.publishAfterCommit();

        CustomerCancelled customerCancelled = new CustomerCancelled();
        BeanUtils.copyProperties(this, customerCancelled);
        customerCancelled.publishAfterCommit();

    }

    public static CustomerRepository repository() {
        CustomerRepository customerRepository = CustomerTeamApplication.applicationContext.getBean(
            CustomerRepository.class
        );
        return customerRepository;
    }
    
}
