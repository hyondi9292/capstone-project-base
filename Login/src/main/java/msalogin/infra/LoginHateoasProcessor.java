package msalogin.infra;

import msalogin.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class LoginHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Login>> {

    @Override
    public EntityModel<Login> process(EntityModel<Login> model) {
        return model;
    }
}
