package msalogin.infra;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import msalogin.domain.Balance;
import msalogin.domain.BalanceService;

@RestController
@RequestMapping(value ="/balances")
@Transactional
public class BalanceController {
    
    @Autowired
    BalanceService balanceService;

    //입금
    @RequestMapping(value = "/deposit/{customerId}/{money}", method = RequestMethod.POST)
    public void increasedBalanceSvc (@PathVariable(value = "customerId") String customerId, @PathVariable(value = "money") Integer money){
        System.out.println("#############customerId############"+customerId);
        System.out.println("#############money ############"+money);
        balanceService.increasedBalance(customerId, money);
    }
    //출금
    @RequestMapping(value = "/withdraw/{customerId}/{money}", method = RequestMethod.POST)
    public void decreasedBalanceSvc (@PathVariable(value = "customerId") String customerId, @PathVariable(value = "money") Integer money){
        System.out.println("#############customerId############"+customerId);
        System.out.println("#############money ############"+money);
        balanceService.decreasedBalance(customerId, money);
    }
    //@RestResource(exported = true)
    @RequestMapping(value = "/check/{customerId}", method = RequestMethod.GET)
    public Balance getBalance(@PathVariable(value = "customerId") String customerId){
        System.out.println("#############getBalnce method############"+customerId);
        return  this.balanceService.getBalance(customerId);
    }

}
