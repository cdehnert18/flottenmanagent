package de.pka.flottenmanagement;

import java.util.List;
import java.util.Optional;

import de.pka.flottenmanagement.model.Mission;
import de.pka.flottenmanagement.model.Position;
import de.pka.flottenmanagement.repository.MissionRepository;
import de.pka.flottenmanagement.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import de.pka.flottenmanagement.model.Tenant;
import de.pka.flottenmanagement.model.User;
import de.pka.flottenmanagement.repository.TenantRepository;
import de.pka.flottenmanagement.repository.UserRepository;

@Component
public class UserRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final TenantRepository tenantRepository;
    private final MissionRepository missionRepository;
    private final PositionRepository positionRepository;

    public UserRunner(UserRepository userRepository, TenantRepository tenantRepository, MissionRepository missionRepository, PositionRepository positionRepository) {
        this.userRepository = userRepository;
        this.tenantRepository = tenantRepository;
        this.missionRepository = missionRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public void run(String... args) {

        Tenant demoFirma = new Tenant();
        tenantRepository.save(demoFirma);

        User demoUser = new User("DemoUser");
        demoUser.setTenant(demoFirma);
        userRepository.save(demoUser);

        Mission demoMission = new Mission("shortDemoMission", "Das ist eine Demomission.", demoFirma);
        missionRepository.save(demoMission);

        Position posA = new Position(20, 20);
        Position posB = new Position(60, 20);
        Position posC = new Position(60, 60);
        Position posD = new Position(20, 60);
        posA.setMission(demoMission);
        posB.setMission(demoMission);
        posC.setMission(demoMission);
        posD.setMission(demoMission);
        positionRepository.save(posA);
        positionRepository.save(posB);
        positionRepository.save(posC);
        positionRepository.save(posD);
    }
    
}
