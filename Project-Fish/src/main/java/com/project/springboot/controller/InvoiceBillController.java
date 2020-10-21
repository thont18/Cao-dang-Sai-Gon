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
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import com.project.springboot.entity.Bill;
//import com.project.springboot.entity.InvoiceBill;
//import com.project.springboot.services.BillService;
//import com.project.springboot.services.InvoiceBillService;
//
//@CrossOrigin
//@RestController
//public class InvoiceBillController {
//	@Autowired InvoiceBillService invoiceBillService;
//
//	@RequestMapping(value = "/invoiceBills", method = RequestMethod.GET)
//	public ResponseEntity<List<InvoiceBill>> findAll() {
//		List<InvoiceBill> invoiceBill = invoiceBillService.findAll();
//		if (invoiceBill.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(invoiceBill, HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/bills", method = RequestMethod.POST)
//	public ResponseEntity<InvoiceBill> createInvoiceBill(@RequestBody InvoiceBill invoiceBill, UriComponentsBuilder builder) {
//		invoiceBillService.save(invoiceBill);
//		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(builder.path("/bills/{id}").buildAndExpand(invoiceBill.getId()).toUri());
//		return new ResponseEntity<>(invoiceBill, HttpStatus.CREATED);
//	}
//
//	@RequestMapping(value = "/bills/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<Bill> updateBill(@PathVariable("id") Integer id, @RequestBody InvoiceBill invoiceBill) {
//		Optional<InvoiceBill> currentinvoiceBill = invoiceBillService.findById(id);
//
//		if (!currentBill.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//
//		currentBill.get().setBillCode(bill.getBillCode());
//
//		billService.save(currentBill.get());
//		return new ResponseEntity<>(currentBill.get(), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/bills/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Bill> deleteBill(@PathVariable("id") Integer id) {
//		Optional<Bill> bill = billService.findById(id);
//		if (!bill.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		billService.delete(id);
//		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	}
//}
