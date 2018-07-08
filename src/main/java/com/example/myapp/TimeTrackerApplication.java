package com.example.myapp;

import com.example.myapp.security.JWTAuthenticationFilter;
import com.example.myapp.security.JWTLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
public class TimeTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeTrackerApplication.class, args);
    }

    @Configuration
    class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

        @Autowired
        AccountRepository accountRepository;

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService());
        }

        @Bean
        UserDetailsService userDetailsService() {
            return new UserDetailsService() {

                @Override
                public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

                    Account account = accountRepository.findByLogin(username);
                    if(account != null) {
                        return new User(account.getLogin(), account.getPassword(), true, true, true, true,
                                AuthorityUtils.createAuthorityList("USER"));
                    } else {
                        throw new UsernameNotFoundException("could not find the user '"
                                + username + "'");
                    }
                }

            };
        }
    }

    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            List<String> accessList = new ArrayList<String>();

            accessList.add("/css/**");
            accessList.add("/js/**");
            accessList.add("/images/**");
            accessList.add("/home");
            accessList.add("/registry");
            accessList.add("/");
            accessList.add("/addUser");
            accessList.add("/favicon.ico");
            accessList.add("/timetest");
            accessList.add("/helloWorld");

            http.csrf().disable().authorizeRequests()
                    .antMatchers(accessList.toArray(new String[accessList.size()])).permitAll()
//                    .antMatchers(HttpMethod.POST, "/login").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    // We filter the api/login requests
                    .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
                            UsernamePasswordAuthenticationFilter.class)
                    // And filter other requests to check the presence of JWT in header
                    .addFilterBefore(new JWTAuthenticationFilter(),
                            UsernamePasswordAuthenticationFilter.class);
        }

    }
}