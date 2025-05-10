package de.pka.flottenmanagement;

import java.util.List;
import java.util.Optional;

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

    @Autowired
    public UserRunner(UserRepository userRepository, TenantRepository tenantRepository) {
        this.userRepository = userRepository;
        this.tenantRepository = tenantRepository;
    }

    @Override
    public void run(String... args) {
        userRepository.deleteAll();
        Tenant tenant1 = new Tenant();
        tenantRepository.save(tenant1);


        // Erstellung von Benutzern
        User User1 = new User("Benutzer 1");
        User1.setTenant(tenant1); // Hier muss die Klasse Tenant existieren

        System.out.println("Zuordnung Tenant und User "+User1);


        User User2 = new User("Benutzer 2");
        User2.setTenant(tenant1); // Hier muss die Klasse Tenant existieren

        userRepository.save(User1);
        userRepository.save(User2);

        // Abfrage aller Benutzer
        List<User> Users = (List<User>) userRepository.findAll();
        Users.forEach(System.out::println);

        // Abfrage eines Benutzers (Rückgabe kann auch null sein)
        Optional<User> user = userRepository.findById(1L);
        System.out.println(user);

        // Aktualisierung eines Benutzers
        user.get().setUserName("Benutzer 1 aktualisiert");
        userRepository.save(user.get()); // Hier wird save() verwendet, um den Benutzer zu aktualisieren

        // Abfrage des aktualisierten Benutzers
        user = userRepository.findById(1L);
        System.out.println(user);

        // Löschen eines Benutzers
        userRepository.delete(User2);
    }
    
}
