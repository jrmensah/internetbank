package me.jrmensah.internetbank.security;

import me.jrmensah.internetbank.entities.UserData;
import me.jrmensah.internetbank.entities.UserRole;
import me.jrmensah.internetbank.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

//Transactional annotation allows everything to go through, Service is NOT an Entity
@Transactional
@Service

//These are details in database that creates access and takes object from database to check if
//username and password are correct, data passes through if correct otherwise returns to login

//A user object implements Username authorizes just username, not other details like phone number or email
//implementing certain methods that must be valid for user
public class SSUserDetailsService implements UserDetailsService {

    //Information can be passed back
    private UserRepository userRepository;

    public SSUserDetailsService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }


    @Override
    //When creating UserDetailsService file, this method must be included in class
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        //String username returns to userData
        try {
            UserData user = userRepository.findByUsername(username);
            if (user == null)
            {
                return null;
            }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                getAuthorities(user));

    } catch(Exception e) {

    }
    return null;
}

    private Set<GrantedAuthority> getAuthorities(UserData user){
    Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

    for (UserRole role : user.getRoles())
    {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
        authorities.add(grantedAuthority);
        System.out.println("Granted Authority"+grantedAuthority.toString());
    }
    return authorities;

    }
}
