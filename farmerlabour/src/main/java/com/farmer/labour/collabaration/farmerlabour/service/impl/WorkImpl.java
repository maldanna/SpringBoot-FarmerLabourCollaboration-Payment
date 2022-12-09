package com.farmer.labour.collabaration.farmerlabour.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmer.labour.collabaration.farmerlabour.model.Work;
import com.farmer.labour.collabaration.farmerlabour.repo.WorkRepo;
import com.farmer.labour.collabaration.farmerlabour.service.interfaces.SubscriptionInf;
import com.farmer.labour.collabaration.farmerlabour.service.interfaces.WorkInf;

@Service
public class WorkImpl implements WorkInf {

    @Autowired
    WorkRepo workRepo;

    @Autowired
    SubscriptionInf subscriptionInf;


    @Override
    public Work addWork(Work work,String phone,int addressnumber) {
        // update address filed based on phone and workNumber
        work.setWorkAddress(phone+"-"+addressnumber);
        Work resWork=workRepo.save(work);
        subscriptionInf.notifySubscribedLaboursOnWorkActions(null); 
        return resWork;       
    }

    @Override
    public Work updateWork(Work work,String phone,int addressnumber) {
        work.setWorkAddress(phone+"-"+addressnumber);
        Work resWork=workRepo.save(work);
        return resWork;
    }

    @Override
    public List<Work> getWorksByPhone(String phone) {
        List<Work> worksByphone=workRepo.findByFarmerPhone(phone);
        return worksByphone;
    }


    @Override
    public Work getWorkById(int workId, String phone) {
        Work work=workRepo.findByWorkIdAndFarmerPhone(workId,phone);
        return work;
    }


    @Override
    public Work deleteWork(Work work) {
        workRepo.delete(work);
        return null;
    }


    @Override
    public List<Work> getAllWorks() {
        List<Work> allWorks=workRepo.findAll();
        return allWorks;
    }


   /*  @Override
    public String notifySubscribedLaboursOnWorkActions(Work work) {
        subscriptionInf.notifySubscribedLaboursOnWorkActions(null);   
        return null;
    }


    @Override
    public String notifyAcceptedLaboursOnUpdateOrDelete() {
        return null;
    }
*/


  /*   @Override
    public String notifySubscribedLaboursOnWorkActions() {
        
        return null;
    }


    @Override
    public String notifyAcceptedLaboursOnUpdateOrDelete() {
        // TODO Auto-generated method stub
        return null;
    }
    */



    
}
