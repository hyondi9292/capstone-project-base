package msalogin.infra;

import java.util.List;
import msalogin.domain.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LogincqrsRepository extends CrudRepository<Logincqrs, Long> {
    List<Logincqrs> findByAccountNo(String accountNo);
    List<Logincqrs> findByAccountNo(String accountNo);
    // keep

}
