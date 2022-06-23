package msalogin.infra;

import msalogin.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

import javax.naming.NameParser;
import javax.transaction.Transactional;
import msalogin.config.kafka.KafkaProcessor;
import msalogin.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    AccountRepository accountRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void when_CustomerRegister_then_CREATE_1(@Payload CustomerRegistered customerRegistered) {
        
        System.out.println("#############when_CustomerRegister_then_CREATE_1Start###############");
        if (!customerRegistered.validate()) return;

        Account Accountdata = new Account();

        //DB에 저장할 정보 셋팅
        Accountdata.setCustomerId(customerRegistered.getCustomerId());

        //DB저장
        accountRepository.save(Accountdata);
        System.out.println("#############when_CustomerRegister_then_CREATE_1_END###############");

    }

}
