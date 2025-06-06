package de.pka.flottenmanagement.controller;

import de.pka.flottenmanagement.model.Mission;
import de.pka.flottenmanagement.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    MissionRepository missionRepository;

    @PostMapping
    public ResponseEntity<Mission> assignMission(@RequestParam long id) {
        Optional<Mission> m = (id % 2 == 0)
                ? missionRepository.findById(1L)
                : missionRepository.findById(2L);

        return m.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
