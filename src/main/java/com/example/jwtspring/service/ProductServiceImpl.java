package com.example.jwtspring.service;

import com.example.jwtspring.model.Category;
import com.example.jwtspring.model.Product;
import com.example.jwtspring.model.User;
import com.example.jwtspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @PreAuthorize("hasRole('ROLE_USER')")
    @Transactional
    @Override
    public Page<Product> getAllProducts(Pageable page) {
        return productRepository.findAll(page);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @Transactional
    @Override
    public Page<Product> getAllProducts(Category category, Pageable page) {
        return productRepository.findByAssociatedWithCategory(category.getId(), page);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return Optional.empty ();
    }

    @Override
    public Product createProduct(String name, String currency, double price, User user) {
        return null;
    }

    @Override
    public void updateProduct(Product product, String name, String currency, double price) {

    }

    @Override
    public void deleteProduct(Product product) {

    }

    @Override
    public boolean hasCategory(Product product, Category category) {
        return false;
    }

    @Override
    public void addCategory(Product product, Category category) {

    }

    @Override
    public void removeCategory(Product product, Category category) {

    }

    @Override
    public boolean hasProductsAssociated(Category category) {
        return false;
    }
}
