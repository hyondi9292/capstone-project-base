package msalogin.domain;


import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "AccountList_Base")
@Data
public class Balance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private String customerId;
    @Column
    private String accountNo;
    @Column
    private String accountBal;
    @Column
    private String accountStatus;  


}




