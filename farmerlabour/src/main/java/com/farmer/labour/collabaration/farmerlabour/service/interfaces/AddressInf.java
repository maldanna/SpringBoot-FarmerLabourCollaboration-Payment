package com.farmer.labour.collabaration.farmerlabour.service.interfaces;

import com.farmer.labour.collabaration.farmerlabour.model.Address;

public interface AddressInf {
    public String addAddress(Address address);
    public String updateAddress(Address address);
    public Address getAddress(String phone);
    public Address getAddressById(String phone,String addressNumber);

}
