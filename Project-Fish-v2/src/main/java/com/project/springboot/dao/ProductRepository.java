package com.project.springboot.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.springboot.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select pro from Product pro where pro.name like %?1%")
    List<Product> findProductByName(String name);

    @Query("select pro from ProductType pro")
    List<Product> getData(Pageable pegeable);

    @Query("select count(*) from ProductType")
    Integer getNumberLine();

    @Query("select count(pro) from ProductType pro where pro.name like %?1%")
    Integer getNumberLineForFilter(String name);
}
