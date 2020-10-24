package com.project.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.entity.ProductType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {
//    @Query("select l from ProductType l where l.name like %?1%")
//    List<ProductType> filterByNameOrCode(String nameOrCode, Pageable pageable);
	@Query("select proty from ProductType proty where proty.name like %?1%")
	List<ProductType> findProductTypeByName(String name);

	@Query("select l from ProductType l")
	List<ProductType> getData(Pageable pegeable);

	@Query("select count(*) from ProductType")
	Integer getNumberLine();

	@Query("select count(l) from ProductType l where l.name like %?1%")
	Integer getNumberLineForFilter(String name);

}
