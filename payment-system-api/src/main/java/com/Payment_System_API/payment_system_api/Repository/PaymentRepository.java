package com.Payment_System_API.payment_system_api.Repository;

import com.Payment_System_API.payment_system_api.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
