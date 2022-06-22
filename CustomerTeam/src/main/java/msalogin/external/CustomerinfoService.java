package msalogin.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "Customerinfo", url = "${api.url.Customerinfo}")
public interface CustomerinfoService {
    @RequestMapping(
        method = RequestMethod.GET,
        path = "/customerinfos/{CustomerId}"
    )
    public Customerinfo getCustomerinfo(
        @PathVariable("CustomerId") Long CustomerId
    );
    // keep

}
