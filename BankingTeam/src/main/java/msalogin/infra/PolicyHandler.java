package msalogin.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import msalogin.config.kafka.KafkaProcessor;
import msalogin.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler {

    @Autowired
    SmartbankingRepository smartbankingRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCustomerCancelled_CustomerStatusCanceledCancle(
        @Payload CustomerCancelled customerCancelled
    ) {
        if (!customerCancelled.validate()) return;
        CustomerCancelled event = customerCancelled;
        System.out.println(
            "\n\n##### listener CustomerStatusCanceledCancle : " +
            customerCancelled.toJson() +
            "\n\n"
        );

        // Sample Logic //
        Smartbanking.customerStatusCanceledCancle(event);
    }
    // keep

}
