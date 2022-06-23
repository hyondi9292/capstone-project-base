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
    @Column(name = "customer_id")
    private String customerId;

    private String bankingId;

    private String password;

    private String status;
}
