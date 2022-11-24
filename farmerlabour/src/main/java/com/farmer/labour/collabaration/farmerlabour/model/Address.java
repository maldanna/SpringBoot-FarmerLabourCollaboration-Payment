package com.farmer.labour.collabaration.farmerlabour.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    
@Id
private String userName;
private String village;
private String mandal;
private String district;
private int pinCode;


}
