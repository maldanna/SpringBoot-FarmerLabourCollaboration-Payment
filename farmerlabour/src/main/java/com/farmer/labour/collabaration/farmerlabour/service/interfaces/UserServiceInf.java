package com.farmer.labour.collabaration.farmerlabour.service.interfaces;

import java.util.List;

import com.farmer.labour.collabaration.farmerlabour.model.FarmerLabourUser;
import com.farmer.labour.collabaration.farmerlabour.model.Subscription;

public interface UserServiceInf {
    public String save(FarmerLabourUser user);
    public String register(FarmerLabourUser user);
    public String update(FarmerLabourUser user);
    public FarmerLabourUser getUser(String phone);
    public List<FarmerLabourUser> getAlluser();
    public String deleteUser(String userName);
    public Subscription subscribe(Subscription subscribtion);
    public List<Subscription> getSubscribers(String farmerphone);
}
