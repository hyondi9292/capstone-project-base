package msalogin.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "DepositTeam", url = "${api.url.DepositTeam}")
public interface AccountService {
    @RequestMapping(method = RequestMethod.POST, path = "/accounts")
    public void deposit(@RequestBody Account account);
    // keep

}
