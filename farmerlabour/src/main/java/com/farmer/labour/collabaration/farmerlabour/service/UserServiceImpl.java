package com.farmer.labour.collabaration.farmerlabour.service;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder.In;

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

@Service
public class UserServiceImpl implements UserServiceInf,UserDetailsService{

    @Autowired
    FarmerLabourRepository userRepo;

    @Autowired
    BCryptPasswordEncoder pswEncoder;
    

    @Override
    public Integer save(FarmerLabourUser user){
        // encode password
        user.setPassword(pswEncoder.encode(user.getPassword()));
        Integer userId = userRepo.save(user).getId();
        return userId;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername method called");
        FarmerLabourUser user= userRepo.findByUsername(username);//get model user but we should have userrdetailes serrvice
        // prepare security user
        System.out.println("security user is: "+user.getUsername() +"  password is:"+user.getPassword());

        return new User(username,user.getPassword()
                    ,user.getRoles().stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList()));
    }
    
}
