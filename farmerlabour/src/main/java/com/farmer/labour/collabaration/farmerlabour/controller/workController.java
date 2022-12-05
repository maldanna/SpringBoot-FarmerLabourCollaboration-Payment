package com.farmer.labour.collabaration.farmerlabour.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmer.labour.collabaration.farmerlabour.model.Work;
import com.farmer.labour.collabaration.farmerlabour.service.interfaces.WorkInf;


@RestController
@RequestMapping("/work")
public class workController {

    @Autowired
    WorkInf workInf;

    @PostMapping("/addwork/{phone}/{addressnumber}")
    public ResponseEntity<Work> addWork(@RequestBody Work work, @PathVariable String phone,@PathVariable int addressnumber){
     
        Work resultWork=workInf.addWork(work,phone,addressnumber);
        return ResponseEntity.ok(resultWork);
    }

    @PostMapping("/updatework/{phone}/{addressnumber}")
    public ResponseEntity<Work> updateWork(@RequestBody Work work,@PathVariable String phone,@PathVariable int addressnumber){
     
        Work resultWork=workInf.updateWork(work,phone,addressnumber);
        return ResponseEntity.ok(resultWork);
    }
    
    @GetMapping("/getworkbyid/{workId}/{phone}")  // workId, String phone
    public ResponseEntity<Work> getWorkById(@PathVariable int workId,@PathVariable String phone ){
        Work resWork=workInf.getWorkById(workId, phone);
        return ResponseEntity.ok(resWork);
    } 

    @GetMapping("/getworkbyphone/{phone}")  // workId, String phone
    public ResponseEntity<List<Work>> getWorkByPhone(@PathVariable String phone ){
        List<Work> resWorks=workInf.getWorksByPhone(phone);
        return ResponseEntity.ok(resWorks);
    } 

    @GetMapping("/getAllworks")  // workId, String phone
    public ResponseEntity<List<Work>> getAllworks(){
        List<Work> resWorks=workInf.getAllWorks();
        return ResponseEntity.ok(resWorks);
    } 


}
