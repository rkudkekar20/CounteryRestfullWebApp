package com.bikkadit.CounteryRestfullWebApp.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.CounteryRestfullWebApp.model.Countries;
import com.bikkadit.CounteryRestfullWebApp.service.ServiceImpl;

@RestController
public class CountriesController {
	@Autowired
	private ServiceImpl serviceImpl;
	
	@PostMapping("/save")
	public ResponseEntity<Countries> saveCountry(@RequestBody Countries counteris){
	boolean save = serviceImpl.save(counteris);
	if(save==true) {
		String msg="save successfully..";
	}else {
		
	  return null;
		
	}
	return new ResponseEntity<Countries>(counteris,HttpStatus.CREATED);

	}
	@GetMapping("/countrylist")
	public ResponseEntity<List<Countries>>showCountry(){
		List<Countries> listAll = serviceImpl.listAll();
		
		
		return new ResponseEntity<>(listAll,HttpStatus.OK);
		
	}
	@GetMapping(value="/country/{id}" ,produces = "application/json", consumes = "application/json")
   public ResponseEntity<Countries>getResult(@PathVariable Integer id) {
		try {
		Countries countries = serviceImpl.get(id);
		return new ResponseEntity<Countries>(countries,HttpStatus.OK);
	}catch(NoSuchElementException  e) {
		return new ResponseEntity<Countries>(HttpStatus.NOT_FOUND);
		
	}	
	}
	@DeleteMapping(value="/deletebycountry/{id}",produces = "application/json", consumes = "application/json")
	public ResponseEntity<Countries>deleteById(@PathVariable Integer id){
		serviceImpl.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	@PutMapping("{id}")
	public ResponseEntity<Countries>updateAll(@PathVariable Integer id,@RequestBody Countries countries){
		serviceImpl.update(id, countries);
		return new ResponseEntity<>(serviceImpl.get(id),HttpStatus.OK);
		
	}
}
