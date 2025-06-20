package de.pka.flottenmanagement.controller;

import de.pka.flottenmanagement.dto.Coordinates;
import de.pka.flottenmanagement.model.Mission;
import de.pka.flottenmanagement.model.Position;
import de.pka.flottenmanagement.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    MissionRepository missionRepository;

    @PostMapping
    public ResponseEntity<Mission> assignMission(@RequestParam(name = "id") long id) {
        Optional<Mission> m = missionRepository.findById(id);

        return m.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Coordinates> getNextCoordinates(
            @RequestParam(name = "missionId") long missionId,
            @RequestParam(name = "x") int currentX,
            @RequestParam(name = "y") int currentY) {

        Optional<Mission> currentMission = missionRepository.findById(missionId);

        if (currentMission.isPresent()) {
            Mission mission = currentMission.get();
            List<Position> positions = mission.getPositions();

            for (int i = 0; i < positions.size(); i++) {
                Position pos = positions.get(i);
                if (pos.getLatitude() == currentX && pos.getLongitude() == currentY) {
                    if (i + 1 < positions.size()) {
                        Position nextPos = positions.get(i + 1);
                        Coordinates coordinates = new Coordinates((int) nextPos.getLatitude(), (int) nextPos.getLongitude());
                        return ResponseEntity.ok(coordinates);
                    } else {
                        // Es gibt keine nächste Position
                        return ResponseEntity.notFound().build();
                    }
                }
            }
            return ResponseEntity.ok(new Coordinates((int) mission.getPositions().get(0).getLatitude(), (int) mission.getPositions().get(0).getLongitude()));
        }

        return ResponseEntity.notFound().build(); // Mission oder Position nicht gefunden
    }

}
