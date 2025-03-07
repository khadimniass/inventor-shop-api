package com.manage.shop.manager_inventor_shop.repository;

import com.manage.shop.manager_inventor_shop.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
