package com.farmer.labour.collabaration.farmerlabour.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity

@IdClass(SubscriptionPrimaryKey.class)
public class Subscription {

    @Id
    private String farmerPhone;
    @Id
    private String  LaboourPhone;

    
}
