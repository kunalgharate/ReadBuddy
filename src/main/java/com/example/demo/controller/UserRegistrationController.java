/*
 * package com.example.demo.controller;
 * 
 * import com.example.demo.model.Task; import
 * com.example.demo.model.UserRegistration; import
 * com.example.demo.services.TaskService; import
 * com.example.demo.services.UserService;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.*;
 * 
 * @RestController
 * 
 * @RequestMapping("/users") public class UserRegistrationController {
 * 
 * @Autowired private UserService service;
 * 
 * @PostMapping("/register") //@ResponseStatus(HttpStatus.CREATED) public
 * UserRegistration createUser(@RequestBody UserRegistration user) {
 * System.out.println("aaaaa"); return service.addUserRegistration(user); }
 * 
 * 
 * // @DeleteMapping("/delete-user") // public ResponseEntity<String>
 * deleteUser(@RequestHeader("Authorization") String authorizationHeader) // {
 * System.out.println("deleter-user handler is called here"); //
 * System.out.println("user"); // boolean id
 * =service.deleteUserByuserId(authorizationHeader); // if(id) { // return new
 * ResponseEntity("User delted Sucessfully ",HttpStatus.OK); // } // else{ //
 * return new ResponseEntity("Cant delete this user",HttpStatus.OK); // } // }
 * 
 * 
 * @PostMapping("/demo") public String getName() { return "rupesh"; }
 * 
 * }
 */
