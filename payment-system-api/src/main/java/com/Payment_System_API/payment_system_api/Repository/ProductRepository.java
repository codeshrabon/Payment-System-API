package com.Payment_System_API.payment_system_api.Repository;

import com.Payment_System_API.payment_system_api.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
