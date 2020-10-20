//package com.project.springboot.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import com.project.springboot.entity.Product;
//import com.project.springboot.entity.ProductType;
//import com.project.springboot.services.ProductService;
//import com.project.springboot.services.ProductTypeService;
//
//@CrossOrigin
//@RestController
//public class ProductController {
//	@Autowired
//	private ProductService productService;
//
//	@Autowired
//	private ProductTypeService ptService;
//	@Autowired
//	private FileStorageService fileStorageService;
//
//	@RequestMapping(value = "/products", method = RequestMethod.GET)
//	public ResponseEntity<List<Product>> findAll() {
//		List<Product> products = productService.findAll();
//		if (products.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(products, HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
//		Optional<Product> product = productService.findById(id);
//
//		if (!product.isPresent()) {
//			return new ResponseEntity<>(product.get(), HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(product.get(), HttpStatus.OK);
//	}
//
////	@RequestMapping(value = "/products/productType/{id}", method = RequestMethod.POST)
////	public Product createProduct(@RequestBody Product product,@PathVariable("id") Integer id,  @RequestParam("image") MultipartFile file) {
////		// cah cua e day phai k dung roi anh
////		ProductType pt = ptService.findById(id);
////		product.setProductType(pt);
////		//        String fileName = fileStorageService.storeFile(file);
////		//
////		//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
////		//                .path("/downloadFile/")
////		//                .path(fileName)
////		//                .toUriString();
////		return 	productService.save(product);
////	}
//
//	// Modify post pro
//	@PostMapping(value = "/products/createProducts", consumes = "multipart/form-data")
//	public ResponseEntity<?> createProducts(@RequestParam("proCode") String proCode, @RequestParam("name") String name,
//			@RequestParam("proTypeId") Integer proTypeId, @RequestParam("price") Double price,
//			@RequestParam("photo") MultipartFile photo) {
//		if (photo.isEmpty()) {
//			HttpStatus.valueOf("Photo not found!");
//		}
//
//		Product createPro = new Product();
//		ProductType pt = ptService.findById(proTypeId);
////		String fileName = proCode + "_" + fileStorageService.storeFile(photo);
//		String fileName = fileStorageService.storeFile(photo);
//
//		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
//				.path(fileName).toUriString();
//		createPro.setProCode(proCode);
//		createPro.setName(name);
//		createPro.setPrice(price);
//		createPro.setProductType(pt);
//		createPro.setImage(fileDownloadUri);
//		this.productService.save(createPro);
//		Product savePro = this.productService.save(createPro);
//		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.set("MyHeader", "MyValue");
//		return new ResponseEntity<>(savePro, httpHeaders, HttpStatus.CREATED);
//
//	}
//
//
//	@PutMapping(value = "/products/updateProducts/{id}", consumes = "multipart/form-data")
//	public ResponseEntity<?> updateProducts(@PathVariable("id") Integer id, @RequestParam("proCode") String proCode,
//			@RequestParam("name") String name, @RequestParam("proTypeId") Integer proTypeId,
//			@RequestParam("price") Double price, @RequestParam("photo") MultipartFile photo) {
//		if (photo.isEmpty()) {
//			HttpStatus.valueOf("Photo not found!");
//		}
//
//		Product createPro = productService.findById(id).get();
//		ProductType pt = ptService.findById(proTypeId);
////		String fileName = proCode + "_" +  fileStorageService.storeFile(photo);
//		String fileName = fileStorageService.storeFile(photo);
//
//		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
//				.path(fileName).toUriString();
//		createPro.setProCode(proCode);
//		createPro.setName(name);
//		createPro.setPrice(price);
//		createPro.setProductType(pt);
//		createPro.setImage(fileDownloadUri);
//		this.productService.save(createPro);
//		Product savePro = this.productService.save(createPro);
//		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.set("MyHeader", "MyValue");
//		return new ResponseEntity<>(savePro, httpHeaders, HttpStatus.OK);
//
//	}
//
//	@PutMapping(value = "/products/updateProductsNoImage/{id}", consumes = "multipart/form-data")
//	public ResponseEntity<?> updateProductsNoImage(@PathVariable("id") Integer id, @RequestParam("proCode") String proCode,
//			@RequestParam("name") String name, @RequestParam("proTypeId") Integer proTypeId,
//			@RequestParam("price") Double price) {
//
//		Product createPro = productService.findById(id).get();
//		ProductType pt = ptService.findById(proTypeId);
//
//		createPro.setProCode(proCode);
//		createPro.setName(name);
//		createPro.setPrice(price);
//		createPro.setProductType(pt);
//
//		createPro.setImage(createPro.getImage());
//		this.productService.save(createPro);
//		Product savePro = this.productService.save(createPro);
//		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.set("MyHeader", "MyValue");
//		return new ResponseEntity<>(savePro, httpHeaders, HttpStatus.OK);
//
//	}
//
//
//	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
//	public Product deleteProduct(@PathVariable("id") Integer id) {
//		Product product = productService.findById(id).get();
//		productService.delete(product.getId());
//		return product;
//	}
//
//
//}
