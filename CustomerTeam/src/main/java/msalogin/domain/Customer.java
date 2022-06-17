package msalogin.domain;

import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    
}
