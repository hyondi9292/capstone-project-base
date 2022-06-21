package msalogin.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import msalogin.config.kafka.KafkaProcessor;
import msalogin.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class LogincqrsViewHandler {

    @Autowired
    private LogincqrsRepository logincqrsRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCustomerRegistered_then_CREATE_1(@Payload CustomerRegistered customerRegistered){
        try {
            if (!customerRegistered.validate()) return;
            // view 객체 생성
            Logincqrs logincqrs = new Logincqrs();
            // view 객체에 이벤트의 Value 를 set 함
            System.out.println("#########customerRegistered.getCustomerId##########"+customerRegistered.getCustomerId());
            logincqrs.setCustomerId(customerRegistered.getCustomerId());
            // view 레파지 토리에 save
            logincqrsRepository.save(logincqrs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    @StreamListener(KafkaProcessor.INPUT)
    public void whenSmartBankingRegistered_then_UPDATE_1(
        @Payload SmartBankingRegistered smartBankingRegistered
    ) {
        try {
            if (!smartBankingRegistered.validate()) return;
            // view 객체 조회
            Optional<Logincqrs> logincqrsOptional = logincqrsRepository.findById(
                smartBankingRegistered.getId()
            );

            if (logincqrsOptional.isPresent()) {
                Logincqrs logincqrs = logincqrsOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                logincqrs.setCustomerStatus(1);
                // view 레파지 토리에 save
                logincqrsRepository.save(logincqrs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     */

    /*
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCustomerRegistered_then_UPDATE_2(
        @Payload CustomerRegistered customerRegistered
    ) {
        try {
            if (!customerRegistered.validate()) return;
            // view 객체 조회
            Optional<Logincqrs> logincqrsOptional = logincqrsRepository.findById(
                customerRegistered.getId()
            );

            if (logincqrsOptional.isPresent()) {
                Logincqrs logincqrs = logincqrsOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                logincqrs.setCustomerStatus(1);
                // view 레파지 토리에 save
                logincqrsRepository.save(logincqrs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     */

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBalanceIncreased_then_UPDATE_3(@Payload BalanceIncreased balanceIncreased) {
        try {
            if (!balanceIncreased.validate()) return;
            // view 객체 조회
            System.out.println("#########logincqrsRepository##########"+logincqrsRepository);
            List<Logincqrs> logincqrsList = logincqrsRepository.findBycustomerId(
                balanceIncreased.getCustomerId()
            );
            System.out.println("#########logincqrsList##########"+logincqrsList);
            for (Logincqrs logincqrs : logincqrsList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                logincqrs.setAccountBal(balanceIncreased.getAccountBal());
                // view 레파지 토리에 save
                logincqrsRepository.save(logincqrs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    @StreamListener(KafkaProcessor.INPUT)
    public void whenBalanceIncreased_then_UPDATE_4(
        @Payload BalanceIncreased balanceIncreased
    ) {
        try {
            if (!balanceIncreased.validate()) return;
            // view 객체 조회

            List<Logincqrs> logincqrsList = logincqrsRepository.findByAccountNo(
                balanceIncreased.getAccountNo()
            );
            for (Logincqrs logincqrs : logincqrsList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                logincqrs.setAccountBal(balanceIncreased.getAccountBal());
                // view 레파지 토리에 save
                logincqrsRepository.save(logincqrs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     */
    /*
    @StreamListener(KafkaProcessor.INPUT)
    public void whenAccountCreated_then_UPDATE_5(
        @Payload AccountCreated accountCreated
    ) {
        try {
            if (!accountCreated.validate()) return;
            // view 객체 조회
            Optional<Logincqrs> logincqrsOptional = logincqrsRepository.findById(
                accountCreated.getId()
            );

            if (logincqrsOptional.isPresent()) {
                Logincqrs logincqrs = logincqrsOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                logincqrs.setAccountNo(accountCreated.getAccountNo());
                // view 레파지 토리에 save
                logincqrsRepository.save(logincqrs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     */

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCustomerRegistered_then_DELETE_1(
        @Payload CustomerRegistered customerRegistered
    ) {
        try {
            if (!customerRegistered.validate()) return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // keep

}
