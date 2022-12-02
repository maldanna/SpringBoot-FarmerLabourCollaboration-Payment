package com.farmer.labour.collabaration.farmerlabour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.farmer.labour.collabaration.farmerlabour.model.Address;
import com.farmer.labour.collabaration.farmerlabour.model.FarmerLabourUser;
import com.farmer.labour.collabaration.farmerlabour.utility.JwtUtil;
import  com.farmer.labour.collabaration.farmerlabour.model.UserRequest;
import  com.farmer.labour.collabaration.farmerlabour.model.UserResponse;
import com.farmer.labour.collabaration.farmerlabour.service.interfaces.AddressInf;
import com.farmer.labour.collabaration.farmerlabour.service.interfaces.UserServiceInf;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserServiceInf userServiceInf;

    @Autowired
    AddressInf addressInf;

    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
	private JwtUtil jwtUtil;

    /* save basic farmerLabourUserDetails */
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody FarmerLabourUser user){
        String userId= userServiceInf.save(user);
        String body="user : "+userId+" saved !!";
        return ResponseEntity.ok(body);
    }
    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest userRequest){
        // for this authentication amangeer already we told to get userr from data base ( loaduserby username)
        // compare passed user details with security userr details
        //in security config class we told this info
        System.out.println("user name is: "+userRequest.getPhone());
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    userRequest.getPhone(), 
                    userRequest.getPassword()
                    )
            );
        String token=jwtUtil.generateToken(userRequest.getPhone());
        return ResponseEntity.ok(new UserResponse(token,"GENERATED BY Maldanna"));
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody FarmerLabourUser user){
        String response= userServiceInf.update(user);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getuser/{phone}")
    public ResponseEntity<FarmerLabourUser> getUser(@PathVariable String phone ){
        FarmerLabourUser resUser=userServiceInf.getUser(phone);
        System.out.println("resUsers valeus are:"+resUser.getName() +" "+resUser.getEmail());
        return ResponseEntity.ok(resUser);
    }

    @GetMapping("/getAlluser")
    public ResponseEntity<List<FarmerLabourUser>> getAllUsers(){
        List<FarmerLabourUser> resUsers=userServiceInf.getAlluser();
        return ResponseEntity.ok(resUsers);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody String phone ){
        String result=null;
        return ResponseEntity.ok(result);
    }

    @PostMapping("/addaddress")
    public ResponseEntity<String> addAddress(@RequestBody Address address ){
        String result=addressInf.addAddress(address);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/updateaddress")
    public ResponseEntity<String> updateAddress(@RequestBody Address address ){
        String result=addressInf.updateAddress(address);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getaddressById/{phone}/{addressNumber}")
    public ResponseEntity<Address> getAddressById(@PathVariable String phone,@PathVariable String addressNumber){
        Address address=addressInf.getAddressById(phone,addressNumber);
        return ResponseEntity.ok(address);
    }

    @GetMapping("/getaddress/{phone}")
    public ResponseEntity<List<Address>> getAddress(@PathVariable String phone){
        List<Address> address=addressInf.getAddress(phone);
        return ResponseEntity.ok(address);
    }


    
    
}
