package msalogin.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
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
    SmartbankingRepository smartbankingRepository;

    //고객이 신규되었을때 스마트폰 뱅킹 테이블에 고객 ID만 가지고 데이터 생성
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCustomerRegistered_then_CREATE_1 (@Payload CustomerRegistered customerRegistered) {
        if (!customerRegistered.validate()) return;

        Smartbanking smartbaking = new Smartbanking();

        smartbaking.setCustomerId(customerRegistered.getCustomerId());

        System.out.println("#########Smartbanking Policy handler : CREATE Obj##########" + smartbaking);
        smartbankingRepository.save(smartbaking);

    }
    
}
