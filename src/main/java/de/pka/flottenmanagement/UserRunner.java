package de.pka.flottenmanagement;

import de.pka.flottenmanagement.model.Mission;
import de.pka.flottenmanagement.model.Position;
import de.pka.flottenmanagement.repository.MissionRepository;
import de.pka.flottenmanagement.repository.PositionRepository;
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

        // Missionsplanung Rot
        Mission mission = new Mission("shortMission1", "Das ist eine Mission1.", demoFirma);
        missionRepository.save(mission);

        Position posA = new Position(20, 20);
        Position posB = new Position(60, 20);
        Position posC = new Position(60, 60);
        Position posD = new Position(20, 60);
        posA.setMission(mission);
        posB.setMission(mission);
        posC.setMission(mission);
        posD.setMission(mission);
        positionRepository.save(posA);
        positionRepository.save(posB);
        positionRepository.save(posC);
        positionRepository.save(posD);

        // Missionsplanung Blau
        mission = new Mission("shortMission2", "Das ist eine Mission2.", demoFirma);
        missionRepository.save(mission);

        posA = new Position(40, 40);
        posB = new Position(100, 70);
        posC = new Position(60, 60);
        posD = new Position(95, 15);
        posA.setMission(mission);
        posB.setMission(mission);
        posC.setMission(mission);
        posD.setMission(mission);
        positionRepository.save(posA);
        positionRepository.save(posB);
        positionRepository.save(posC);
        positionRepository.save(posD);

        // Missionsplanung Grün
        mission = new Mission("shortMission3", "Das ist eine Mission3.", demoFirma);
        missionRepository.save(mission);

        posA = new Position(30, 40);
        posB = new Position(110, 20);
        posC = new Position(70, 10);
        posD = new Position(45, 25);
        posA.setMission(mission);
        posB.setMission(mission);
        posC.setMission(mission);
        posD.setMission(mission);
        positionRepository.save(posA);
        positionRepository.save(posB);
        positionRepository.save(posC);
        positionRepository.save(posD);


    }
    
}
