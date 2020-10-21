package com.project.springboot.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.project.springboot.entity.Product;
import com.project.springboot.entity.ProductType;
import com.project.springboot.exception.ResourceNotFoundException2;
import com.project.springboot.services.FileStorageService;
import com.project.springboot.services.ProductService;
import com.project.springboot.services.ProductTypeService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private ProductTypeService ptService;
	@Autowired
	private FileStorageService fileStorageService;

	//Get All Fish
	@GetMapping("/fish/getAllFish")
	public List<Product> listFish() {
		return this.productService.findAll();
	}

	//Get one fish
	@GetMapping("/fish/getOneFish/{id}")
	public Product getOneFish(@PathVariable("id") Integer id) {
		return this.productService.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException2("Not found Fish with id: " + id));
	}

//	@RequestMapping(value = "/products/productType/{id}", method = RequestMethod.POST)
//	public Product createProduct(@RequestBody Product product,@PathVariable("id") Integer id,  @RequestParam("image") MultipartFile file) {
//		// cah cua e day phai k dung roi anh
//		ProductType pt = ptService.findById(id);
//		product.setProductType(pt);
//		//        String fileName = fileStorageService.storeFile(file);
//		//
//		//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//		//                .path("/downloadFile/")
//		//                .path(fileName)
//		//                .toUriString();
//		return 	productService.save(product);
//	}

	// Modify post pro
	@PostMapping(value = "/fish/createFish", consumes = "multipart/form-data")
	public ResponseEntity<?> createProducts(
			@RequestParam("proCode") String proCode, 
			@RequestParam("name") String name,
			@RequestParam("proTypeId") Integer proTypeId, 
			@RequestParam("price") Double price,
			@RequestParam("photo") MultipartFile photo,
			@RequestParam("createdBy") String createdBy,
			@RequestParam("modifiedBy") String modifiedBy,
			@RequestParam("description") String description) {
		if (photo.isEmpty()) {
			HttpStatus.valueOf("Photo not found!");
		}

		Product createPro = new Product();
		ProductType pt = ptService.findById(proTypeId);
//		String fileName = proCode + "_" + fileStorageService.storeFile(photo);
		String fileName = fileStorageService.storeFile(photo);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName).toUriString();
		createPro.setProCode(proCode);
		createPro.setName(name);
		createPro.setPrice(price);
		createPro.setProductType(pt);
		createPro.setDescription(description);
		createPro.setCreatedBy(createdBy);
		createPro.setModifiedBy(modifiedBy);
		createPro.setDateCreated(LocalDateTime.now());
		createPro.setImage(fileDownloadUri);
		this.productService.save(createPro);
		Product savePro = this.productService.save(createPro);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("MyHeader", "MyValue");
		return new ResponseEntity<>(savePro, httpHeaders, HttpStatus.CREATED);

	}


	@PutMapping(value = "/fish/updateFish/{id}", consumes = "multipart/form-data")
	public Product updateProducts(
			@PathVariable("id") Integer id, 
			@RequestParam("proCode") String proCode,
			@RequestParam("name") String name, 
			@RequestParam("proTypeId") Integer proTypeId,
			@RequestParam("price") Double price,
			@RequestParam("photoEdit") MultipartFile photo,			
			@RequestParam("modifiedBy") String modifiedBy,
			@RequestParam("description") String description) throws JsonMappingException, JsonProcessingException {
		if (photo.isEmpty()) {
			HttpStatus.valueOf("Photo not found!");
		}

		Product createPro = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException2("Not found Fish with id:" + id));
		ProductType pt = ptService.findById(proTypeId);
//		String fileName = proCode + "_" +  fileStorageService.storeFile(photo);
		String fileName = fileStorageService.storeFile(photo);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName).toUriString();
		createPro.setProCode(proCode);
		createPro.setName(name);
		createPro.setPrice(price);
		createPro.setProductType(pt);
		createPro.setImage(fileDownloadUri);
		createPro.setDescription(description);
		createPro.setModifiedBy(modifiedBy);
		createPro.setCreatedBy(createPro.getCreatedBy());
		createPro.setDateModified(LocalDateTime.now());
		createPro.setDateCreated(createPro.getDateCreated());
		return this.productService.save(createPro);
//		Product savePro = this.productService.save(createPro);
	}
	//NO IMAGE
	@PutMapping(value = "/fish/updateFishNoImage/{id}", consumes = "multipart/form-data")
	public ResponseEntity<?> updateProductsNoImage(
			@PathVariable("id") Integer id, 
			@RequestParam("proCode") String proCode,
			@RequestParam("name") String name, 
			@RequestParam("proTypeId") Integer proTypeId,
			@RequestParam("price") Double price,			
			@RequestParam("modifiedBy") String modifiedBy,
			@RequestParam("description") String description) {

		Product createPro = productService.findById(id).get();
		ProductType pt = ptService.findById(proTypeId);

		createPro.setProCode(proCode);
		createPro.setName(name);
		createPro.setPrice(price);
		createPro.setProductType(pt);
		createPro.setDescription(description);
		createPro.setModifiedBy(modifiedBy);
		createPro.setCreatedBy(createPro.getCreatedBy());
		createPro.setDateModified(LocalDateTime.now());
		createPro.setDateCreated(createPro.getDateCreated());
		createPro.setImage(createPro.getImage());
		this.productService.save(createPro);
		
		Product savePro = this.productService.save(createPro);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("MyHeader", "MyValue");
		return new ResponseEntity<>(savePro, httpHeaders, HttpStatus.OK);

	}


	@RequestMapping(value = "fish//deleteFish/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") Integer id) {
		Product product = productService.findById(id).get();
		productService.delete(product.getId());
	}
}
