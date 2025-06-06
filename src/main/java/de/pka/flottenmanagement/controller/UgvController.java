package de.pka.flottenmanagement.controller;

import de.pka.flottenmanagement.model.Ugv;
import de.pka.flottenmanagement.repository.UgvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ugvs")
public class UgvController {

    @Autowired
    UgvRepository ugvRepository;

    @GetMapping()
    public long getUgvs(){
        return ugvRepository.count();
    }

    @PostMapping()
    public String createUgv() {
        ugvRepository.save(new Ugv());
        return "1963";
    }

    // TODO: Test
    @DeleteMapping()
    public boolean deleteUgv(@RequestParam int id) {
        Optional<Ugv> ugv = ugvRepository.findById((long) id);
        if(ugv.isPresent()) {
            ugvRepository.delete(ugv.get());
            return true;
        }
        return false;
    }
}
