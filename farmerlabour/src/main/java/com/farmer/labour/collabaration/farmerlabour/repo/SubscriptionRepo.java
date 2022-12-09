package com.farmer.labour.collabaration.farmerlabour.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmer.labour.collabaration.farmerlabour.model.Subscription;

public interface SubscriptionRepo extends JpaRepository<Subscription,String>{
    List<Subscription> findByFarmerPhone(String phone);
    List<Subscription> findByLabourPhone(String phone);
    Subscription findByFarmerPhoneAndLabourPhone(String farmerPhone,String LabourPhone);
    
}
