package app.dao.api;

import app.model.ProductionBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by User on 18.7.2017 г..
 */
@Repository
public interface ProductionBatchDao  extends JpaRepository<ProductionBatch, Long> {
    List<ProductionBatch> findByName (String name);
}
