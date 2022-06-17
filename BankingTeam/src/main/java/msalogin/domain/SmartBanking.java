package msalogin.domain;

import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;
import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Banking_Base")
@Data

public class SmartBanking {

    @Id
    private Long CustomerId;
    @Column
    private Long BankingId;
    @Column
    private String Password;
    @Column
    private String Status;

}

    
