package msalogin.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Logincqrs_table")
@Data
public class Logincqrs {

    @Id
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "customer_status")
    private String customerStatus;
    @Column(name = "banking_status")
    private String bankingStatus;
    @Column(name = "account_status")
    private String accountStatus;
    @Column(name = "account_no")
    private String accountNo;
    @Column(name = "account_bal")
    private String accountBal;
}
