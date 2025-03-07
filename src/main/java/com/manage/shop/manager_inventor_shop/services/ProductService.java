package com.manage.shop.manager_inventor_shop.services;

import com.manage.shop.manager_inventor_shop.entities.Product;
import com.manage.shop.manager_inventor_shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }
    public Optional<Product> getProductById(Long id){
        return this.productRepository.findById(id);
    }
    public Product createProduct(Product product){
        return this.productRepository.save(product);
    }
    public Product updateProduct(Long id, Product productDetails){
        return this.productRepository.findById(id).map((product)->{
            product.setName(productDetails.getName());
            product.setDescription(productDetails.getDescription());
            product.setQuantity(productDetails.getQuantity());
            product.setPrice(productDetails.getPrice());
            product.setSupplier(productDetails.getSupplier());
            product.setMinStockLevel(productDetails.getMinStockLevel());

            return productRepository.save(product);
        }).orElseThrow(()->new RuntimeException("product not found"));
    }
    public void deleateProduct(Long id){
       this.productRepository.deleteById(id);
    }
}
