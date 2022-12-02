package com.farmer.labour.collabaration.farmerlabour.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmer.labour.collabaration.farmerlabour.model.Work;

public interface WorkRepo extends JpaRepository<Work,String>  {

    List<Work> findByFarmerPhone(String phone);
    Work findByWorkIdAndFarmerPhone(int workId,String phone);
   
}

