package msalogin.external;

import java.util.Date;
import lombok.Data;

@Data
public class Customerinfo {

    private Long customerId;
    private String customerStatus;
    private String bankingStatus;
    private String accountStatus;
    private String accountNo;
    private String accountBal;
    // keep

}
