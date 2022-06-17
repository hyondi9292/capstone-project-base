package msalogin.domain;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.Id;


=======
import java.util.Date;
>>>>>>> upstream/main
import lombok.Data;
import msalogin.infra.AbstractEvent;

@Data
public class BalanceDecreased extends AbstractEvent {

<<<<<<< HEAD

=======
>>>>>>> upstream/main
    private Long customerId;
    private String accountNo;
    private String accountBal;

    public BalanceDecreased() {
        super();
    }
    // keep

}
