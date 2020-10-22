package com.project.springboot.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springboot.dao.ProductRepository;
import com.project.springboot.entity.Product;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }
	public Product save(Product product) {
		return productRepository.save(product);
	}
	public void delete(Integer id) {
		productRepository.deleteById(id);
	}
}
