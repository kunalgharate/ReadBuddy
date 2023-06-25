package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress {
	@Id
    private String smbaddressuserId;
    private String smbAdressLine1;
    private String smbAddressLine2;
    private String smbCity;
    private String smbState;
    private String smbCountry;
    private String smbpin;
    private String smblatitude;
    private String smblongititude;
    private int smbcount;
    
	

}
