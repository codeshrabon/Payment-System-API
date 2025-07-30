package com.Payment_System_API.payment_system_api.Service;


import com.Payment_System_API.payment_system_api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;



}
