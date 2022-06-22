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

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCustomerRegistered_CusRegistered(
        @Payload CustomerRegistered customerRegistered
    ) {
        if (!customerRegistered.validate()) return;
        CustomerRegistered event = customerRegistered;
        System.out.println(
            "\n\n##### listener CusRegistered : " +
            customerRegistered.toJson() +
            "\n\n"
        );

        // Sample Logic //
        Smartbanking.cusRegistered(event);
    }
    // keep

}
