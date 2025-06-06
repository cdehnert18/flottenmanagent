package de.pka.flottenmanagement.controller;

import de.pka.flottenmanagement.model.Ugv;
import de.pka.flottenmanagement.repository.PositionRepository;
import de.pka.flottenmanagement.repository.UgvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/positions")
public class TelemetryController {
    PositionRepository positionRepository;


}