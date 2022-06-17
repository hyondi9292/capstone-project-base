package msalogin.domain;

import msalogin.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "smartbankings",
    path = "smartbankings"
)
public interface SmartbankingRepository
    extends PagingAndSortingRepository<Smartbanking, Long> {}
