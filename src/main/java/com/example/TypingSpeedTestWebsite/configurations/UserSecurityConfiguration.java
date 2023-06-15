package com.example.TypingSpeedTestWebsite.configurations;

import com.example.TypingSpeedTestWebsite.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;

@EnableWebSecurity
@Configuration
@Order(1)
public class UserSecurityConfiguration {

    @Autowired
    private AccountService accountService;

    @Bean
    @Primary
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http.cors().and().csrf().disable();

        http
                .authorizeRequests()
                .requestMatchers("/home").permitAll()
                .requestMatchers("/paragraph").authenticated()
                .requestMatchers("/test").authenticated()
                .requestMatchers("/paragraph/add").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/user-panel").permitAll()
                .loginProcessingUrl("/user/process-login")
                .defaultSuccessUrl("/user-panel/welcome", true)
                .failureUrl("/user-panel/login?error")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutUrl("/user/process-logout")
                .logoutSuccessUrl("/user-panel/login?logout")
                .deleteCookies("JSESSIONID")
                .and()
                .exceptionHandling().accessDeniedPage("/user-panel/accessDenied");

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
