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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    private String customerStatus;
    private String bankingStatus;
    private String accountStatus;
    private String accountNo;
    private String accountBal;
    public void setCustomerId(Object customerId2) {
    }
    public void setCustomerStatus(int i) {
    }
    public void setAccountBal(Object accountBal2) {
    }
    public void setAccountNo(Object accountNo2) {
    }
}
