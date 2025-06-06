package de.pka.flottenmanagement.repository;

import de.pka.flottenmanagement.model.Mission;
import org.springframework.data.repository.CrudRepository;

public interface MissionRepository extends CrudRepository<Mission, Long> {
}
