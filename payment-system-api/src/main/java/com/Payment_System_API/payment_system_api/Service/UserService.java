package com.Payment_System_API.payment_system_api.Service;


import com.Payment_System_API.payment_system_api.DTO.UserRequestDTO;
import com.Payment_System_API.payment_system_api.DTO.UserResponseDTO;
import com.Payment_System_API.payment_system_api.Model.User;
import com.Payment_System_API.payment_system_api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    // adding new data
    public Optional<User> AddNewUser(User user) {
        try {
            User saveUser = userRepo.save(user);
            System.out.println(saveUser);
            return Optional.of(saveUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUser() {
        try {

            return userRepo.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> GetUserById(Long id) {
        try {
            Optional<User> userId = userRepo.findById(id);
            if (userId.isPresent()){
                System.out.print("ID: " + id + " Found!");
                System.out.print(userId);

            }

            return userId;

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public UserResponseDTO AddNewCustomer(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPhoneNumber(userRequestDTO.getPhoneNumber());
        user.setAddress(userRequestDTO.getAddress());
        user.setStatus(true);
        user.setRole(userRequestDTO.getRole());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdateAt(LocalDateTime.now());

        try {
            User saveUser = userRepo.save(user);
            return mapToResponseDTO(saveUser);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private UserResponseDTO mapToResponseDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setPhoneNumber(user.getPhoneNumber());
        userResponseDTO.setAddress(user.getAddress());
        userResponseDTO.setRole(user.getRole());
        userResponseDTO.setCreatedAt(user.getCreatedAt());
        userResponseDTO.setStatus(user.isStatus());
        userResponseDTO.setUpdateAt(user.getUpdateAt());
        return userResponseDTO;
    }
}
