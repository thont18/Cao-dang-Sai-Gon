//package com.project.springboot.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import com.project.springboot.dao.ProductTypeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import com.project.springboot.entity.ProductType;
//import com.project.springboot.services.ProductTypeService;
//
//@CrossOrigin
//@RestController
//@RequestMapping("")
//public class ProductTypeController {
//    @Autowired
//    private ProductTypeService productTypeService;
//
//    @Autowired
//    private ProductTypeRepository productRepo;
//
//    @RequestMapping(value = "/productTypes", method = RequestMethod.GET)
//    public ResponseEntity<List<ProductType>> findAll() {
//        List<ProductType> productTypes = productTypeService.findAll();
//        if (productTypes.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(productTypes, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/productTypes/{id}", method = RequestMethod.GET)
//    public ProductType getProductTypeById(@PathVariable("id") Integer id) {
//        ProductType productType = productTypeService.findById(id);
//
//        return productType;
//    }
//
//    @RequestMapping(value = "/productTypes", method = RequestMethod.POST)
//    public ResponseEntity<ProductType> createProductTypes(@RequestBody ProductType productTypes,
//                                                          UriComponentsBuilder builder) {
//        productTypeService.save(productTypes);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/productTypes/{id}").buildAndExpand(productTypes.getId()).toUri());
//        return new ResponseEntity<>(productTypes, HttpStatus.CREATED);
//    }
//
//    @RequestMapping(value = "/productTypes/{id}", method = RequestMethod.PUT)
//    public ProductType updateProductTypes(@PathVariable("id") Integer id,
//										  @RequestBody @Validated ProductType productTypes) {
//        productTypeService.findById(id);
//        return productTypeService.save(productTypes);
//    }
//
//    @RequestMapping(value = "/productTypes/{id}", method = RequestMethod.DELETE)
//    public void deleteProductTypes(@PathVariable("id") Integer id) {
//        ProductType productType = productTypeService.findById(id);
//        productTypeService.delete(productType.getId());
//    }
//
//    @GetMapping("/getData/{start}")
//    public List<ProductType> getData(@PathVariable("start") int start) {
//        Pageable page = PageRequest.of(start, 5, Sort.by("id").ascending());
//        return productRepo.getData(page);
//    }
//
//    @GetMapping("/numberLine")
//    public List<Integer> getNumberLine() {
//        int num = productRepo.getNumberLine();
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
//
//    @GetMapping("/numberLine/{name}")
//    public List<Integer> getNumberLineForFilter(@PathVariable("name") String name) {
//        int num = productRepo.getNumberLineForFilter(name);
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
//
//    @GetMapping("/search/{name}/{page}")
//    public List<ProductType> filterByNameOrCode(@PathVariable("name") String name,
//                                                @PathVariable("page") int page) {
//        return productRepo.filterByNameOrCode(name,
//				PageRequest.of(page, 5, Sort.by("name").ascending()));
//    }
//
//}
