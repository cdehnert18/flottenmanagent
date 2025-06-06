package de.pka.flottenmanagement.controller;

import de.pka.flottenmanagement.model.Ugv;
import de.pka.flottenmanagement.repository.UgvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UgvController {

    @Autowired
    UgvRepository ugvRepository;

    @GetMapping("/ugvs")
    public long getUgvs(){
        return ugvRepository.count();
    }
}
