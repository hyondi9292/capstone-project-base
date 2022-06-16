package jologin.domain;

import java.util.Date;
import jologin.domain.*;
import jologin.infra.AbstractEvent;
import lombok.Data;

@Data
public class LoginSucceeded extends AbstractEvent {

    private Long id;
    private String islogin;

    public LoginSucceeded() {
        super();
    }
    // keep

}
