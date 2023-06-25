package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistration {
    @Id
    private String smbuserId;
    private String smbuserName;
    private int smbuserMobileNumber;
    private String smbuserPinCode;
     private UserAddress userAddress;
} 
	 
	 

	
	


