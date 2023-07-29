//package com.example.demo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.example.demo.services.CustomUserDetailService;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//public class SecurityConfig {
//
//
//    @Autowired
//    private JwtAuthenticationEntryPoint point;
//    @Autowired
//    private JwtAuthenticationFilter filter;
//    
//    @Autowired
//    private UserDetailsService userDetailsService;
//    
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http.csrf(csrf -> csrf.disable())
//                .authorizeRequests().
//                requestMatchers("/test").authenticated().requestMatchers("/auth/login").permitAll().requestMatchers("/users/register").permitAll().requestMatchers("/book/getAllBook").permitAll()
//                .requestMatchers("/updateBook/{bookid}").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and().exceptionHandling(ex -> ex.authenticationEntryPoint(point))
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
//    
//    @Bean
//    public DaoAuthenticationProvider doDaoAuthenticationProvider()
//    {
//    	DaoAuthenticationProvider doDaoAuthenticationProvider= new DaoAuthenticationProvider();
//    	doDaoAuthenticationProvider.setUserDetailsService(userDetailsService);
//    	doDaoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
//    	return doDaoAuthenticationProvider;
//    }
//
//
//}