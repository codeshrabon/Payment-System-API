package com.Payment_System_API.payment_system_api.Controller;


import com.Payment_System_API.payment_system_api.Model.User;
import com.Payment_System_API.payment_system_api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // add data from postman
    @PostMapping("/admin/addUser")
    public ResponseEntity<?> addUser (@RequestBody User user){
        Optional<User> createNewUser = userService.AddNewUser(user);
        System.out.print("User Added");
        //System.out.print(createNewUser);
        return new ResponseEntity<>(createNewUser, HttpStatus.CREATED);
    }


}
