package com.farmer.labour.collabaration.farmerlabour.service.interfaces;

import java.util.List;

import com.farmer.labour.collabaration.farmerlabour.model.Work;


public interface WorkInf {
    public Work addWork(Work work,String phone,int addressnumber);
    public Work updateWork(Work work,String phone,int addressnumber);
    public List<Work> getWorksByPhone(String phone);
    public Work getWorkById(int workId,String phone);
    public Work deleteWork(Work work);
    public List<Work> getAllWorks();
   // public String notifySubscribedLaboursOnWorkActions(Work work);
   // public String notifyAcceptedLaboursOnUpdateOrDelete();
    

}
