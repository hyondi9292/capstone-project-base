package msalogin.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
//@RepositoryRestResource(collectionResourceRel = "balances", path = "balances")
public interface BalanceRepository extends JpaRepository<Balance, Long>{
    
    @RestResource(path="customerId", rel="customerId", exported=true)
    Optional<Balance> findBycustomerId(@Param("customerId") String customer_id);

}

