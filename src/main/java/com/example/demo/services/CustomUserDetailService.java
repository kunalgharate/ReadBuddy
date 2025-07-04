//package com.example.demo.services;
//
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.model.UserRegistration;
//import com.example.demo.repository.UserRepository;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService {
//
//	 private final UserRepository userRepository;
//
//
//    CustomUserDetailService(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserRegistration user=userRepository.findUserByEmail(username).orElseThrow(()-> new RuntimeException("User not found"));
//		return user;
//	}
//}
