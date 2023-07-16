package com.example.demo.controller;


import com.example.demo.config.JwtRequest;
import com.example.demo.config.JwtResponse;
import com.example.demo.config.JwtTokenUtil;
import com.example.demo.config.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {


    @Autowired
    JwtUserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/authenticate",method = RequestMethod.POST)
    public ResponseEntity generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        try{
            Authentication authenticate = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

        }catch (UsernameNotFoundException exception)
        {
            exception.printStackTrace();
            throw new Exception("Bad Credentials ");
        }
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtTokenUtil.generateToken(userDetails);
        System.out.printf("Tokens is "+token);
        return  ResponseEntity.ok(new JwtResponse(token));

    }

}
