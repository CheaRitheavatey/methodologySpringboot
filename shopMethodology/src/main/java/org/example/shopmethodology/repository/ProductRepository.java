package org.example.shopmethodology.repository;

import jdk.jfr.Registered;
import org.example.shopmethodology.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface ProductRepository extends JpaRepository<Product,Long> {
}
