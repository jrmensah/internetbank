package me.jrmensah.internetbank.entities;

import me.jrmensah.internetbank.repositories.RoleRepository;
import me.jrmensah.internetbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
     this.userRepository = userRepository;
    }
    public UserData findbyEmail(String email)
    {
        return userRepository.findByEmail(email);
    }
    public Long countByEmail(String email)
    {
        return userRepository.countByEmail(email);
    }
    public UserData findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }
    public void saveUserData(UserData user){
        user.setRoles(Arrays.asList(roleRepository.findByRole("USER")));
        user.setEnabled(true);
        userRepository.save(user);
    }
    public void saveAdmin(UserData user){
        user.setRoles(Arrays.asList(roleRepository.findByRole("ADMIN")));
        user.setEnabled(true);
        userRepository.save(user);
    }

    public void saveUserData(User user) {
    }
}
