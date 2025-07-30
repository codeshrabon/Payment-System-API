package com.Payment_System_API.payment_system_api.Repository;

import com.Payment_System_API.payment_system_api.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
