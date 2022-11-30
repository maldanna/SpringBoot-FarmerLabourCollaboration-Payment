package com.farmer.labour.collabaration.farmerlabour.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(AddressPrimaryKey.class)
public class Address {
    
    @Id
    private String phone;
    @Id
    private String  addressNumber;
    private String village;
    private String mandal;
    private String district;
    private int pinCode;
    private String longitude;
    private String lattitude;
    private String homeOrLand;


}
