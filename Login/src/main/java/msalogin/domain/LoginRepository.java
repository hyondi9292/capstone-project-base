package msalogin.domain;

import msalogin.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "logins", path = "logins")
public interface LoginRepository
    extends PagingAndSortingRepository<Login, Long> {}
