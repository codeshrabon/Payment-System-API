package com.Payment_System_API.payment_system_api.Controller;


import com.Payment_System_API.payment_system_api.DTO.UserRequestDTO;
import com.Payment_System_API.payment_system_api.DTO.UserResponseDTO;
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
    public ResponseEntity<Optional<User>> addUser (@RequestBody User user){
        try {
            Optional<User> UserAdded = userService.AddNewUser(user);
            return new ResponseEntity<>(UserAdded, HttpStatus.CREATED);
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
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        try {
            System.out.print("User Looking for " + id +" ID");

            /*Optional<User> getUserById = userService.GetUserById(id);

            System.out.println(id + " ID: " + getUserById);
            return new ResponseEntity<>(getUserById, HttpStatus.FOUND);*/

            return userService.GetUserById(id)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //manually adding user with DTO
    @PostMapping ("admin/addNewCustomer")
    public ResponseEntity<UserResponseDTO> addNewCustomer(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO responseDTO = userService.AddNewCustomer(userRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }



}
