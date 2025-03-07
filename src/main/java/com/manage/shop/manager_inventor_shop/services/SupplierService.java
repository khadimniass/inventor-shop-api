package com.manage.shop.manager_inventor_shop.services;

import com.manage.shop.manager_inventor_shop.entities.Supplier;
import com.manage.shop.manager_inventor_shop.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }
    public List <Supplier> getAllSuppliers(){
        return this.supplierRepository.findAll();
    }
    public Optional<Supplier>getProductById(Long id){
        return this.supplierRepository.findById(id);
    }
    public Supplier createSupplier(Supplier supplier){
        return this.supplierRepository.save(supplier);
    }
    public Supplier updateSupplier(Long id, Supplier supplierDetail){
        return this.supplierRepository.findById(id).map((supplier) -> {
            supplier.setContact(supplierDetail.getContact());
            supplier.setName(supplierDetail.getName());
            supplier.setProducts(supplierDetail.getProducts());

            return supplierRepository.save(supplier);
        }).orElseThrow(()->new RuntimeException("fournisseur introuvable"));
    }
    public void deleateSupplier(Long id){
        this.supplierRepository.deleteById(id);
    }
}
