package com.farmer.labour.collabaration.farmerlabour.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.boot.jaxb.hbm.spi.SubEntityInfo;
import org.springframework.beans.factory.annotation.Autowired;

import com.farmer.labour.collabaration.farmerlabour.model.Subscription;
import com.farmer.labour.collabaration.farmerlabour.repo.SubscriptionRepo;
import com.farmer.labour.collabaration.farmerlabour.service.interfaces.SubscriptionInf;

public class SubscriptionImpl implements SubscriptionInf{
    
    @Autowired
    SubscriptionRepo subscriptionRepo;

    @Override
    public List<String> getSubscribedLaboursEmailIds(String farmerPhone) {
        
        List<Subscription> subscribedLabours=subscriptionRepo.findByFarmerPhone(farmerPhone);
        List<String> laboursPhoneNumbers=subscribedLabours.stream().map(obj->obj.getLabourPhone()).collect(Collectors.toList());
        return null;
    }
    
}
