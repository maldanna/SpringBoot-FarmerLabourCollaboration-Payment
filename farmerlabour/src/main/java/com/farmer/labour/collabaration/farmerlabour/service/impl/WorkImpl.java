package com.farmer.labour.collabaration.farmerlabour.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.farmer.labour.collabaration.farmerlabour.model.Work;
import com.farmer.labour.collabaration.farmerlabour.repo.WorkRepo;
import com.farmer.labour.collabaration.farmerlabour.service.interfaces.WorkInf;

public class WorkImpl implements WorkInf {

    @Autowired
    WorkRepo workRepo;


    @Override
    public String addWork(Work work) {

        int workId=workRepo.save(work).getWorkId();
        return "successfully work created with Id: "+workId;
        
    }


    @Override
    public String updateWork(Work work) {
        int workId=workRepo.save(work).getWorkId();
        return "work with workId: "+workId + " successfully updated";
    }


    @Override
    public List<Work> getWorks(String phone) {
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
        return null;
    }


    @Override
    public String notifySubscribedLaboursOnWorkActions() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public String notifyAcceptedLaboursOnUpdateOrDelete() {
        // TODO Auto-generated method stub
        return null;
    }


    
}
