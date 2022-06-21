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
    @Column(name = "customer_id")
    private String customerId;
    @Column
    private String status;
    @Column
    private String address;
    @Column
    private String telno;
    @Column
    private String name;
    @Column
    private String Jumin_no;
    
}
