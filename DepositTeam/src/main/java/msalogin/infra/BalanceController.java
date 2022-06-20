package msalogin.infra;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public void increasedBalanceSvc (String customerId, Integer money){
        balanceService.increasedBalance(customerId, money);
    }

    @RequestMapping(value = "/check/{customerId}", method = RequestMethod.GET)
    public Balance getBalance(@PathVariable(value = "customerId") String customerId){
        System.out.println("#############getBalnce method############"+customerId);
        return  this.balanceService.getBalance(customerId);
    }
}
