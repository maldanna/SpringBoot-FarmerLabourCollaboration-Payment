package com.farmer.labour.collabaration.farmerlabour.utility;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notifications{

    int test;

    public String notifySubscribedLaboursOnWorkActions(){
        return "done";
    }



}