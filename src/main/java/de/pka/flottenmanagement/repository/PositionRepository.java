package de.pka.flottenmanagement.repository;
import java.util.List;

import de.pka.flottenmanagement.model.Position;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, Long>{
    /*
    @Query("select pos from Position Position.latitude = ?1 and Position.longitude = ?2")
    List<Position> findBylatlong(Integer latitude,Integer longitude);

     */
}

