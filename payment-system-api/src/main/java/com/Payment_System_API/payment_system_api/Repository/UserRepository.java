package com.Payment_System_API.payment_system_api.Repository;

import com.Payment_System_API.payment_system_api.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

        }

