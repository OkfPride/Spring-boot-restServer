package com.example.mytest.mytest.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

/**
 *
 * @author JavaDev
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSourse;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSourse);

//it works but its wrong  pattern
//        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//auth.inMemoryAuthentication().withUser(userBuilder.username("vasia").password("1234").roles("boss")).
//        withUser(userBuilder.username("vasia2").password("1234").roles("boss2"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/actuator/info").hasAnyRole("BOSS").and().
                formLogin();
//        http
                
//                .authorizeRequests()
////                .requestMatchers(EndpointRequest.to("health", "flyway", "info")).permitAll()
//                .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("boss")
//                .and().formLogin()
//                ;
    }

}
