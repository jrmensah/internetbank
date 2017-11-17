package me.jrmensah.internetbank.security;


import me.jrmensah.internetbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration and @EnableWebSecurity indicates the compiler that the file is a configuration file and
//Spring Security is enabled

//This file extends WebSecurityConfigurerAdapter, which has all methods need to include security
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    SSUserDetailsService userDetailsService;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception{
        return new SSUserDetailsService(userRepository);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**","/js/**","/img/**",".h2-console/**","/register").permitAll()
                .antMatchers("/").access("hasAuthority('USER') or hasAuthority('ADMIN')")
                .antMatchers("/admin", "admin").access("hasAuthority('ADMIN')")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                //Login successfully
                .formLogin().defaultSuccessUrl("/login",true)
                //Logout successfully
                .and()
                .logout()
                .logoutRequestMatcher( new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login").permitAll().permitAll()
                .and()
                .httpBasic();
        http
                .csrf().disable();
        http
                .headers().frameOptions().disable();

    }
    @Override
    //Determines whether details has passed and sees whether information is passable
    protected void configure(AuthenticationManagerBuilder auth)
        throws Exception{
        auth.inMemoryAuthentication().withUser("dave").password("begreat").authorities("ADMIN")
                .and().withUser("user").password("password").roles("USER");
                auth.userDetailsService(userDetailsServiceBean());




    }
}
