import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface PostitionRepository extends CrudRepository<Position, Long> {

Position findByid(Long id );

@Query("select pos from Postition Postiion.latitude = ?1 and Posititon.longitude = ?2")
List<Position> findBylatlong(Integer latitude,Integer longitude);

}

