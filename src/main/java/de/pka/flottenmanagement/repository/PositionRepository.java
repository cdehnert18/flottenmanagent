package de.pka.flottenmanagement.repository;

import de.pka.flottenmanagement.model.Position;
import de.pka.flottenmanagement.model.PositionId;

import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, PositionId>{

}

