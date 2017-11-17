package me.jrmensah.internetbank.dataLoader;
;
import me.jrmensah.internetbank.entities.UserRole;
import me.jrmensah.internetbank.repositories.RoleRepository;
import me.jrmensah.internetbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.management.relation.Role;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String...strings) throws Exception{
        System.out.println("Loading data...");

        roleRepository.save(new UserRole("USER"));
        roleRepository.save(new UserRole("ADMIN"));

        UserRole adminRole = roleRepository.findByRole("ADMIN");
        UserRole userRole = roleRepository.findByRole("USER");
    }
}
