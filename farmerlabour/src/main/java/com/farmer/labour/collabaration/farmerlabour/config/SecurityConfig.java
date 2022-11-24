package com.farmer.labour.collabaration.farmerlabour.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.farmer.labour.collabaration.farmerlabour.config.filter.SecurityFilter;
import com.farmer.labour.collabaration.farmerlabour.service.impl.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
   
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    SecurityFilter securityFilter;


    // to use loaduserbyusername method to get userdetails
    // why should we use @autowired on method : 
    //https://stackoverflow.com/questions/32381843/autowired-on-method-in-spring
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder){
        try{
            authenticationManagerBuilder.userDetailsService(userServiceImpl).passwordEncoder(passwordEncoder);
        }
        catch(Exception e){
            System.out.println("Exception occurred !!");
        }
    }
    
    //AuthenticationManage is interface
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception { 
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf->csrf.ignoringAntMatchers("/h2-console/**"))
            .authorizeRequests()
            .antMatchers("/h2-console/**","/user/save","/user/login").permitAll()
            .anyRequest().authenticated().and()
            // .userDetailsService(uServiceImpl) for basic or form based authentication
            .exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
             .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
              .and()
            .csrf().disable();
            //.httpBasic(Customizer.withDefaults()); for rhttpbasic authentication // order imporrtant see  spring security doc
        //http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
