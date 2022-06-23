package msalogin.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import msalogin.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/accounts")
@Transactional
public class AccountController {

    @Autowired
    AccountService accountService;
    // keep

    //계좌 신규 (String customerId, String bankingId, String password, String status);
    @RequestMapping(value = "/create/{customerId}", method = RequestMethod.POST)
    public void createAccountSvc (@PathVariable(value = "customerId") String customerId){
        System.out.println("#############AccountService Controller : Create############");
        accountService.createAccount(customerId);
    }

    //계좌 해지
    @RequestMapping(value = "/delete/{customerId}", method = RequestMethod.POST)
    public void deleteAccountSvc (@PathVariable(value = "customerId") String customerId){
        System.out.println("#############AccountService Controller : Delete############");
        accountService.deleteAccount(customerId);
    }

    //계좌 조회
    @RequestMapping(value = "/check/{customerId}", method = RequestMethod.GET)
    public void getAccountSvc (@PathVariable(value = "customerId") String customerId){
        System.out.println("#############AccountService Controller : check############");
        accountService.getAccount(customerId);
    }

}
