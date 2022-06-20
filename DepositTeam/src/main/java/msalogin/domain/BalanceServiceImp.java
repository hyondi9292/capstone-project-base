package msalogin.domain;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BalanceServiceImp implements BalanceService {

    @Autowired
    private final BalanceRepository balanceRepository;

    public void increasedBalance(String customerId, int money) {

        /**
         * 계좌 잔액을 감소시킨다.
         */
        Optional<Balance> balanceOptional = balanceRepository.findBycustomerId(customerId);
        Balance balance = balanceOptional.get();
        Integer oldmoney = balance.getaccountBal();
        balance.setaccountBal(oldmoney + money);

        balanceRepository.save(balance);

    }

    public void decreasedBalance(String customerId, int money) {
        /**
         * 계좌 잔액을 감소시킨다.
         */
        Optional<Balance> balanceOptional = balanceRepository.findBycustomerId(customerId);
        Balance balance = balanceOptional.get();
        balance.setaccountBal(balance.getaccountBal() - money);
        balance.setaccountBal();

        balanceRepository.save(balance);
    }

    /**
     * 계좌 조회
     */
    public Balance getBalance(String customerId){
        System.out.println("#########BalanceServiceImp#######"+customerId);
        Optional<Balance> balanceOptional = balanceRepository.findBycustomerId(customerId);
        System.out.println("#########balanceOptional#######"+balanceOptional);
        Balance balance = balanceOptional.get();

        return balance;
    }
    
    public Balance save(String data){
        ObjectMapper mapper = new ObjectMapper();
        Balance balance = null;
        try {
            balance = mapper.readValue(data, Balance.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        List<BalanceOption> balanceOptions = balance.getBalanceOptions();
        for(BalanceOption b : balanceOptions){
            b.setBalance(balance);
        }
        */

        return balanceRepository.save(balance);
    }
    
}
