package com.Payment_System_API.payment_system_api.Controller;


import com.Payment_System_API.payment_system_api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class userController {

    @Autowired
    private UserService userService;



}
