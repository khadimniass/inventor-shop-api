package com.manage.shop.manager_inventor_shop.repository;

import com.manage.shop.manager_inventor_shop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByQuantityLessThan(Integer quantityIsLessThan);

    Optional<Product> getProductById(Long id);
}
