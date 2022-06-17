package msalogin.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "CustomerTeam", url = "${api.path.CustomerTeam}")
public interface CustomerService {
    @RequestMapping(
        method = RequestMethod.GET,
        path = "/customers/{CustomerId}"
    )
    public Customer getCustomer(@PathVariable("CustomerId") Long CustomerId);
    // keep

}
