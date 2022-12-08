package com.farmer.labour.collabaration.farmerlabour.utility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.farmer.labour.collabaration.farmerlabour.model.Work;
import com.farmer.labour.collabaration.farmerlabour.repo.FarmerLabourRepository;
import com.farmer.labour.collabaration.farmerlabour.service.interfaces.UserServiceInf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notifications{

    @Autowired
    UserServiceInf userServiceInf;

    public String notifySubscribedLaboursOnWorkActions(Work work){

        List<String> emailIds=
      
    return null;
    }



}