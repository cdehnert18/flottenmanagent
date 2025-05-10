package de.pka.flottenmanagement.repository;

import java.util.List;

import de.pka.flottenmanagement.model.Ugv;
import org.springframework.data.repository.CrudRepository;

public interface UgvRepository extends CrudRepository<Ugv, Long> {
    List<Ugv> findByBatteryLevelLessThan(Integer batteryLevel);
}
