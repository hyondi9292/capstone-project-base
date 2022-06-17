package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.PostPersist;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "Login_Base")
@Data
public class LoginSucceeded extends AbstractEvent {

    private Long bankingId;
    private String islogin;

    public LoginSucceeded() {
        super();
    }
    // keep

}
