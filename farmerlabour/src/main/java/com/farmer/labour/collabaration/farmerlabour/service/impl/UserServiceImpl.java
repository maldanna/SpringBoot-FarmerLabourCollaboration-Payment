package com.farmer.labour.collabaration.farmerlabour.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.farmer.labour.collabaration.farmerlabour.model.FarmerLabourUser;
import com.farmer.labour.collabaration.farmerlabour.repo.FarmerLabourRepository;
import com.farmer.labour.collabaration.farmerlabour.service.interfaces.UserServiceInf;

@Service
public class UserServiceImpl implements UserServiceInf,UserDetailsService{

    @Autowired
    FarmerLabourRepository userRepo;

    @Autowired
    BCryptPasswordEncoder pswEncoder;
    

    @Override
    public String save(FarmerLabourUser user){
        // encode password
        user.setPassword(pswEncoder.encode(user.getPassword()));
        String userName = userRepo.save(user).getName();
        return userName;
    }

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername method called");
        FarmerLabourUser user= userRepo.findByPhone(phone);//get model user but we should have userrdetailes serrvice
        // prepare security user
        System.out.println("security user is: "+user.getPhone() +"  password is:"+user.getPassword());
        return new User(phone,user.getPassword(),user.getRoles().stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList()));
    }

    @Override
    public String update(FarmerLabourUser user) {
        String userName = userRepo.save(user).getName();
        return userName + " user updated successfully!!";
    }

    @Override
    public FarmerLabourUser getUser(String phone) {
        System.out.println("came into get user");
        FarmerLabourUser user=userRepo.findByPhone(phone);
        System.out.println("get user is: "+user.getPhone());
        return user;
    }

    @Override
    public List<FarmerLabourUser> getAlluser() {
        List<FarmerLabourUser> users=userRepo.findAll();
        return users;
    }

    @Override
    public String deleteUser(String phone) {
        FarmerLabourUser user=userRepo.findByPhone(phone);
        userRepo.delete(user);
        return "user deleted successfully!!";
    }

    @Override
    public String register(FarmerLabourUser user) {
        String userName=userRepo.save(user).getName();
        return userName;
    }


}
