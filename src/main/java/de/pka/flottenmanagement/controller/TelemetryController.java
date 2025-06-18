package de.pka.flottenmanagement.controller;

import de.pka.flottenmanagement.repository.PositionRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/positions")
public class TelemetryController {
    PositionRepository positionRepository;


}