package msalogin.domain;

import msalogin.domain.*;
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
         * 계좌 잔액을 증가시킨다.
         */
        Optional<Balance> balanceOptional = balanceRepository.findBycustomerId(customerId);
        System.out.println("#########balanceOptional#######"+balanceOptional);
        Balance balance = balanceOptional.get();
        System.out.println("#########balance#######"+balance);
        //기존 계좌 잔액을 가져온다. 
        String oldmoney = balance.getAccountBal();
        System.out.println("#########oldmoney#######"+oldmoney);
        // 새로 들어온 돈(int)와 합산하기 위해서 형변환
        int changeToIntMoney = Integer.parseInt(oldmoney);
        // 새로 들어온 돈과 합산
        int accountBal = changeToIntMoney + money;
        // 계좌 잔액을 업데이트 하기 위한 형변환 (int -> string)
        String newBalanceMoney = Integer.toString(accountBal);
        balance.setAccountBal(newBalanceMoney);
        System.out.println("#########balance#######"+balance);

        //이벤트 발행
        BalanceIncreased increseBal = new BalanceIncreased();
        //이벤트 발행 값 셋팅
        increseBal.setCustomerId(customerId);
        String accountNo = balance.getAccountNo();
        increseBal.setAccountNo(accountNo);
        increseBal.setAccountBal(newBalanceMoney);
        //이벤트발행
        increseBal.publishAfterCommit();
        balanceRepository.save(balance);
    }

    public void decreasedBalance(String customerId, int money) {
        /**
         * 계좌 잔액을 감소시킨다.
         */
        Optional<Balance> balanceOptional = balanceRepository.findBycustomerId(customerId);
        System.out.println("#########balanceOptional#######"+balanceOptional);
        Balance balance = balanceOptional.get();
        System.out.println("#########balance#######"+balance);
        //기존 계좌 잔액을 가져온다. 
        String oldmoney = balance.getAccountBal();
        System.out.println("#########oldmoney#######"+oldmoney);
        // 새로 들어온 돈(int)와 합산하기 위해서 형변환
        int changeToIntMoney = Integer.parseInt(oldmoney);
        //기존 계좌 잔액이 요청한 금액보다 많은지 체크
        if (changeToIntMoney >= money){
            // 새로 들어온 돈과 차액 계산
            int accountBal = changeToIntMoney - money;
            // 계좌 잔액을 업데이트 하기 위한 형변환 (int -> string)
            String newBalanceMoney = Integer.toString(accountBal);
            balance.setAccountBal(newBalanceMoney);
            System.out.println("#########balance#######"+balance);
            balanceRepository.save(balance);

            //이벤트 발행
            BalanceDecreased decreseBal = new BalanceDecreased();
            //이벤트 발행 값 셋팅
            decreseBal.setCustomerId(customerId);
            String accountNo = balance.getAccountNo();
            decreseBal.setAccountNo(accountNo);
            decreseBal.setAccountBal(newBalanceMoney);
            //이벤트발행
            decreseBal.publishAfterCommit();
            balanceRepository.save(balance);
        } else{
            System.out.println("#########지급 가능한 계좌 잔액이 부족합니다.#######");
        }
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
