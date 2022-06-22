package msalogin.infra;

import java.util.List;
import msalogin.domain.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerinfoRepository
    extends CrudRepository<Customerinfo, Long> {
    List<Customerinfo> findByAccountNo(String accountNo);
    List<Customerinfo> findByAccountNo(String accountNo);
    // keep

}
