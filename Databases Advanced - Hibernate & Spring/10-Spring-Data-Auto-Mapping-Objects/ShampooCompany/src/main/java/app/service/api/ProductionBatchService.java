package app.service.api;

import java.util.List;

/**
 * Created by User on 18.7.2017 г..
 */
public interface ProductionBatchService<ProductionBatch, Long> extends
        ServiceInterface<ProductionBatch, Long> {
    List<ProductionBatch> findBatchByName(String name);
}
