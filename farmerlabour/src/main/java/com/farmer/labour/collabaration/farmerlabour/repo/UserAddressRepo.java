package com.farmer.labour.collabaration.farmerlabour.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmer.labour.collabaration.farmerlabour.model.Address;


public interface  UserAddressRepo extends JpaRepository<Address,String>{

    List<Address> findByPhone(String phone);
    Address findByPhoneAndAddressNumber(String phone,String addressNumber);
   

}

