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
    LoginRepository loginRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverSmartBankingUpdated_Updatelogintable(
        @Payload SmartBankingUpdated smartBankingUpdated
    ) {
        if (!smartBankingUpdated.validate()) return;
        SmartBankingUpdated event = smartBankingUpdated;
        System.out.println(
            "\n\n##### listener Updatelogintable : " +
            smartBankingUpdated.toJson() +
            "\n\n"
        );

        // Sample Logic //
        Login.updatelogintable(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverAccountUpdated_Updatelogintable(
        @Payload AccountUpdated accountUpdated
    ) {
        if (!accountUpdated.validate()) return;
        AccountUpdated event = accountUpdated;
        System.out.println(
            "\n\n##### listener Updatelogintable : " +
            accountUpdated.toJson() +
            "\n\n"
        );

        // Sample Logic //
        Login.updatelogintable(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCustomerRegistered_Updatelogintable(
        @Payload CustomerRegistered customerRegistered
    ) {
        if (!customerRegistered.validate()) return;
        CustomerRegistered event = customerRegistered;
        System.out.println(
            "\n\n##### listener Updatelogintable : " +
            customerRegistered.toJson() +
            "\n\n"
        );

        // Sample Logic //
        Login.updatelogintable(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCustomerCancelled_Updatelogintable(
        @Payload CustomerCancelled customerCancelled
    ) {
        if (!customerCancelled.validate()) return;
        CustomerCancelled event = customerCancelled;
        System.out.println(
            "\n\n##### listener Updatelogintable : " +
            customerCancelled.toJson() +
            "\n\n"
        );

        // Sample Logic //
        Login.updatelogintable(event);
    }
    // keep

}
