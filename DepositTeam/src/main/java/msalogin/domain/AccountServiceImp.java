package msalogin.domain;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    //스마트폰뱅킹 신규 (String customerId, String accountNo, String accountBal, String accountStatus, String trnsCode)
    public void createAccount (String customerId, String accountNo, String accountBal, String accountStatus, String trnsCode){
        System.out.println("#########Account Service : Start Create Account#######");
        //신규된 고객 obj 확인
        Optional<Account> accountOptional = accountRepository.findById(customerId);
        Account accountCust = accountOptional.get();
        //계좌 신규 가입 정보 셋팅
        accountCust.setAccountNo(accountNo);

        Random ranNum = new Random();
        String midNum = 
        

    }

}

