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

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCustomerCanceled_CustomerStatusCanceledCancle(
        @Payload CustomerCanceled customerCanceled
    ) {
        if (!customerCanceled.validate()) return;
        CustomerCanceled event = customerCanceled;
        System.out.println(
            "\n\n##### listener CustomerStatusCanceledCancle : " +
            customerCanceled.toJson() +
            "\n\n"
        );
        // Sample Logic //

    }
    // keep

}
