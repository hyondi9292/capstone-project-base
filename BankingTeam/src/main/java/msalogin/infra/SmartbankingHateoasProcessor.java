package msalogin.infra;

import msalogin.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class SmartbankingHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Smartbanking>> {

    @Override
    public EntityModel<Smartbanking> process(EntityModel<Smartbanking> model) {
        return model;
    }
}
