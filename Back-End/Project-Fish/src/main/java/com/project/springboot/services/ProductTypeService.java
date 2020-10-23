package com.project.springboot.services;

import com.project.springboot.dao.ProductTypeRepository;
import com.project.springboot.entity.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductTypeService {
//<<<<<<< HEAD
//	@Autowired
//	private ProductTypeRepository productTypeRepository;
//
//	public List<ProductType> findAll() {
//		return productTypeRepository.findAll();
//	}
//
//	public ProductType findById(Integer id) {
//		return productTypeRepository.findById(id).get();
//	}
//
//	public ProductType save(ProductType productType) {
//		return productTypeRepository.save(productType);
//	}
//
//	public void delete(Integer id) {
//		productTypeRepository.deleteById(id);
//	}
//
////
//=======
    @Autowired
    private ProductTypeRepository productTypeRepository;

    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    public ProductType findById(Integer id) {
        return productTypeRepository.findById(id).get();
    }

    public ProductType save(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    public void delete(Integer id) {
        productTypeRepository.deleteById(id);
    }


//    public List<ProductType> getData(@PathVariable("start") int start) {
//        Pageable page = (Pageable) PageRequest.of(start, 5, Sort.by("id").ascending());
//        return ProductTypeRepository.getData(page);
//    }

//    public List<Integer> getNumberLine() {
//        int num = ProductTypeRepository.getNumberLine();
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        if (num % 5 == 0) {
//            for (int i = 0; i < num / 5; i++) {
//                list.add(i);
//            }
//        } else {
//            for (int i = 0; i < (num / 5 + 1); i++) {
//                list.add(i);
//            }
//        }
//        return list;
//    }

//	public List<Integer> getNumberLineForFilter(@PathVariable("name") String name) {
//		int num = ProductTypeRepository.getNumberLineForFilter(name);
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		if (num % 5 == 0) {
//			for (int i = 0; i < num / 5; i++) {
//				list.add(i);
//			}
//		} else {
//			for (int i = 0; i < (num / 5 + 1); i++) {
//				list.add(i);
//			}
//		}
//		return list;
//	}

//	public List<ProductType> filterByNameOrCode(@PathVariable("name") String name,
//											 @PathVariable("page") int page) {
//		return ProductTypeRepository.filterByNameOrCode(name,
//				PageRequest.of(page, 5, Sort.by("name").ascending()));
//	}

}
