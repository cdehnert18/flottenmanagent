package de.pka.flottenmanagement.repository;
import java.util.List;

import de.pka.flottenmanagement.model.Position;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, Long>{
    Position findByid(Long id );

    @Query("select pos from Postition Postiion.latitude = ?1 and Posititon.longitude = ?2")
    List<Position> findBylatlong(Integer latitude,Integer longitude);
}

