package com.farmer.labour.collabaration.farmerlabour.service.interfaces;

import java.util.List;

import com.farmer.labour.collabaration.farmerlabour.model.Work;

public interface WorkInf {
    public String addWork(Work work);
    public String updateWork(Work work);
    public List<Work> getWorks(String phone);
    public Work getWorkById(int workId,String phone);
    public Work deleteWork(Work work);
    public List<Work> getAllWorks();
    public String notifySubscribedLaboursOnWorkActions();
    public String notifyAcceptedLaboursOnUpdateOrDelete();
    

}
