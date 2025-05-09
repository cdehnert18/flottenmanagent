package de.pka.flottenmanagement.repository;

import java.util.List;

import de.pka.flottenmanagement.model.UGV;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UGVRepository extends CrudRepository<UGV, Long> {

    UGV findByUgvId(Long ugvid);

    List<UGV> findByBatteryLevelLessThan(Integer batteryLevel);
}
