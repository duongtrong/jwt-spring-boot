package com.example.jwtspring.repository;

import com.example.jwtspring.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    String GET_PRODUCTS_ASSOCIATED_WITH_CATEGORY_SQL = "select p.* from app_product p inner join app_product_category pc on p.id = pc.productid where (pc.categoryid = ?1 or pc.categoryid in (select ac.id from ("
            + CategoryRepository.GET_RECURSIVELY_ALL_SUBCATEGORIES_SQL + ") ac where ac.parentid = ?1)) ";
    String COUNT_PRODUCTS_ASSOCIATED_WITH_CATEGORY_SQL = "select count(1) from (" + GET_PRODUCTS_ASSOCIATED_WITH_CATEGORY_SQL + ")";

    @Query(value = GET_PRODUCTS_ASSOCIATED_WITH_CATEGORY_SQL, countQuery = COUNT_PRODUCTS_ASSOCIATED_WITH_CATEGORY_SQL, nativeQuery = true)
    Page<Product> findByAssociatedWithCategory(Long categoryId, Pageable pageable);

    @Query(value = COUNT_PRODUCTS_ASSOCIATED_WITH_CATEGORY_SQL, nativeQuery = true)
    Long countByAssociatedWithCategory(Long categoryId);
}
