package com.Payment_System_API.payment_system_api.Controller;


import com.Payment_System_API.payment_system_api.Model.User;
import com.Payment_System_API.payment_system_api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        try {
            Optional<User> createNewUser = userService.AddNewUser(user);
            System.out.print("User Added");
            //System.out.print(createNewUser);
            return new ResponseEntity<>(createNewUser, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // get All the user as admin
    @GetMapping("/admin/allUser")
    public ResponseEntity<List<User>> allUser (){
        try {
            List<User> GetAllUser = userService.getAllUser();
            System.out.print("Found All User");

            return new ResponseEntity<>(GetAllUser, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //get a user by its id
    @GetMapping("/admin/getuser/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id){
        try {
            Optional<User> getUserById = userService.GetUserById(id);
            System.out.print("User Looking for " + id +" ID");
            System.out.println(id + " ID: " + getUserById);
            return new ResponseEntity<>(getUserById, HttpStatus.FOUND);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
