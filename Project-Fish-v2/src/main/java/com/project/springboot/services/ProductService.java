package com.project.springboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.springboot.dao.ProductRepository;
import com.project.springboot.entity.Product;
import com.project.springboot.entity.ProductType;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
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

	public List<Integer> getNumberLineForFilter(@PathVariable("name") String name) {
		int num = productRepository.getNumberLineForFilter(name);
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (num % 5 == 0) {
			for (int i = 0; i < num / 5; i++) {
				list.add(i);
			}
		} else {
			for (int i = 0; i < (num / 5 + 1); i++) {
				list.add(i);
			}
		}
		return list;
	}

	public List<Product> findProductByName(@PathVariable("name") String name) {
		return productRepository.findProductByName(name);
	}

}
