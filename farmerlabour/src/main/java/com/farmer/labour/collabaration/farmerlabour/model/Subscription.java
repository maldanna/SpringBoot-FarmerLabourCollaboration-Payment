package com.farmer.labour.collabaration.farmerlabour.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(SubscriptionPrimaryKey.class)
public class Subscription {

    @Id
    private String farmerPhone;
    @Id
    private String  labourPhone;

    
}
