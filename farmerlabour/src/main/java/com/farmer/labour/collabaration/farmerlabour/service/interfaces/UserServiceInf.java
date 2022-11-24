package com.farmer.labour.collabaration.farmerlabour.service.interfaces;

import java.util.List;

import com.farmer.labour.collabaration.farmerlabour.model.FarmerLabourUser;

public interface UserServiceInf {
    public String save(FarmerLabourUser user);
    public String update(FarmerLabourUser user);
    public FarmerLabourUser getUser(String userName);
    public List<FarmerLabourUser> getAlluser();
    public String deleteUser(String userName);

}
