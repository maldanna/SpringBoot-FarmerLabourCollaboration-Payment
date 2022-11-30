package com.farmer.labour.collabaration.farmerlabour.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmer.labour.collabaration.farmerlabour.model.Address;


public interface  UserAddressRepo extends JpaRepository<Address,String>{

    Address findByPhone(String phone);
    Address findByPhoneAndaddressNumber(String phone,String addressNumber);
   

}

