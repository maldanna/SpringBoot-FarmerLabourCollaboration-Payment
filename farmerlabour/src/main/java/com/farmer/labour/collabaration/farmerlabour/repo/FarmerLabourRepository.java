package com.farmer.labour.collabaration.farmerlabour.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmer.labour.collabaration.farmerlabour.model.FarmerLabourUser;

public interface FarmerLabourRepository extends JpaRepository<FarmerLabourUser,Integer> {

    FarmerLabourUser findByUsername(String username);
    
}
