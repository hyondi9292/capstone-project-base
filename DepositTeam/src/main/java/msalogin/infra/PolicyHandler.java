package msalogin.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import msalogin.config.kafka.KafkaProcessor;
import msalogin.domain.*;

import org.hibernate.validator.internal.engine.validationcontext.BaseBeanValidationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler {

    @Autowired
<<<<<<< HEAD
    BalanceRepository balanceRepository;
=======
    AccountRepository accountRepository;
>>>>>>> upstream/main

    @StreamListener(KafkaProcessor.INPUT)
    public void whateverBalance_change(@Payload String eventString) {
        System.out.println("##### Balance Change####");
        /*
        Balance balance = new Balance();
        balance.setId(1234567);
        balance.setaccountNo(12345678911223);
        balance.setaccountBal(10000);
        balance.setaccountStatus("TRUE");
        balance.setcustomerId(1234567);
        balanceRepository.save(balance);
        */

    }
    // keep

}
