package com.farmer.labour.collabaration.farmerlabour.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmer.labour.collabaration.farmerlabour.model.FarmerLabourUser;

public interface FarmerLabourRepository extends JpaRepository<FarmerLabourUser,Integer> {

    FarmerLabourUser findByPhone(String phone);
    List<FarmerLabourUser> findByPhoneIn(List<String> phone);

}
