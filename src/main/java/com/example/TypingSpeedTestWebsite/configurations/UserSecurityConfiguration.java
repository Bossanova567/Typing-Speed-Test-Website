package com.example.TypingSpeedTestWebsite.configurations;

import com.example.TypingSpeedTestWebsite.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;

@EnableWebSecurity
@Configuration
@Order(1)
public class UserSecurityConfiguration {

    @Autowired
    private AccountService accountService;


    @Autowired
    private AuthenticationEntryPoint unauthorizedHandler;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().and().cors().disable();

        http.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                 .authorizeRequests()
                .requestMatchers("/paragraph").access("hasRole('ROLE_USER')")
                .requestMatchers("/add_paragraph").access("hasRole('ROLE_ADMIN')")
                 .requestMatchers("/**").permitAll()
                .and()
                .formLogin().loginPage("/user-panel")
                .loginProcessingUrl("/user/process_login")
                .defaultSuccessUrl("/user-panel/welcome", true)
                .failureUrl("/user-panel/login?error")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutUrl("/user/process-logout")
                .logoutSuccessUrl("/user-panel/login?logout")
                .deleteCookies("JSESSIONID");
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(accountService);
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityContextHolderAwareRequestFilter awareRequestFilter() {
        return new SecurityContextHolderAwareRequestFilter();
    }

    @Bean
    public SecurityContextPersistenceFilter persistenceFilter() {
        return new SecurityContextPersistenceFilter();
    }
}
