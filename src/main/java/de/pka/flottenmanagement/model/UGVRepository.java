import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface UGVRepository extends CrudRepository<Position, Long> {

UGV findByid(Long id);


@Query("select ugv from UGV where UGV.batteryLevel <= ?1")
List<UGV> findByBatteryLevelLower(Integer batteryLevel);




}
