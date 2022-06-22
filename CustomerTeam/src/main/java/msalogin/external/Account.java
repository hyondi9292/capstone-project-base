package msalogin.external;

import java.util.Date;
import lombok.Data;

@Data
public class Account {

    private Long customerId;
    private String accountNo;
    private String accountBal;
    private String accountStatus;
    private String trnsCode;
    // keep

}
