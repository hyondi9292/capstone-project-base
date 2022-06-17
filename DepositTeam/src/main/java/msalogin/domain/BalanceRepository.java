package msalogin.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "balances", path = "balances")
public interface BalanceRepository extends JpaRepository<Balance, Long>{
    
    List<Balance> findByaccountNo(@Param("accountNo") Long accountNo);

}

