package com.farmer.labour.collabaration.farmerlabour.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmer.labour.collabaration.farmerlabour.model.Address;
import com.farmer.labour.collabaration.farmerlabour.service.interfaces.AddressInf;
import com.farmer.labour.collabaration.farmerlabour.repo.UserAddressRepo;

@Service
public class AddressImpl implements AddressInf {

    @Autowired
    UserAddressRepo userAddressRepo;

    @Override
    public String addAddress(Address address) {
        Address addressObj= userAddressRepo.save(address);
        return "successfully "+addressObj.getPhone() + addressObj.getAddressNumber() +" address added !!";
    }

    @Override
    public String updateAddress(Address address) {
        Address addressObj= userAddressRepo.save(address);
        return "successfully "+addressObj.getPhone() + addressObj.getAddressNumber() +" address updated !!";
    }

    @Override
    public List<Address> getAddress(String phone) {
        List<Address> address=userAddressRepo.findByPhone(phone);
        return address;
    }

    @Override
    public Address getAddressById(String phone, String addressNumber) {
        Address addrress=userAddressRepo.findByPhoneAndAddressNumber(phone,addressNumber);
        return addrress;
    }
    
}
