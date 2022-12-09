package com.farmer.labour.collabaration.farmerlabour.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.boot.jaxb.hbm.spi.SubEntityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.farmer.labour.collabaration.farmerlabour.model.FarmerLabourUser;
import com.farmer.labour.collabaration.farmerlabour.model.Subscription;
import com.farmer.labour.collabaration.farmerlabour.model.Work;
import com.farmer.labour.collabaration.farmerlabour.repo.FarmerLabourRepository;
import com.farmer.labour.collabaration.farmerlabour.repo.SubscriptionRepo;
import com.farmer.labour.collabaration.farmerlabour.service.interfaces.SubscriptionInf;
import com.farmer.labour.collabaration.farmerlabour.utility.Notifications;

@Component
public class SubscriptionImpl implements SubscriptionInf{
    
    @Autowired
    SubscriptionRepo subscriptionRepo;

    @Autowired
    FarmerLabourRepository farmerLabourRepository;

    @Autowired
    Notifications notifications;
    


    @Override
    public void notifySubscribedLaboursOnWorkActions(Work work) {
        List<String> emails=getLaboursEmailIds(work.getFarmerPhone());
        notifications.sendEmail(emails, "test", "spring boot email testing!!");
        System.out.println("email functionality done");
    }

    public List<String> getLaboursEmailIds(String farmerPhone){
        List<Subscription> subscribedLabours=subscriptionRepo.findByFarmerPhone(farmerPhone);
        List<String> laboursPhoneNumbers=subscribedLabours.stream().map(obj->obj.getLabourPhone()).collect(Collectors.toList());        
        List<String> labourEmails = farmerLabourRepository.findByPhoneIn(laboursPhoneNumbers).
                                stream().map(obj->obj.getEmail()).collect(Collectors.toList());
        return labourEmails;

    }

}
