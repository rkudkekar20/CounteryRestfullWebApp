package com.bikkadit.CounteryRestfullWebApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bikkadit.CounteryRestfullWebApp.model.Countries;
import com.bikkadit.CounteryRestfullWebApp.repository.CountryRepository;
@Service
public class ServiceImpl  implements ServiceI{

	@Autowired
	private CountryRepository countryRepository;
	@Override
	public List<Countries> listAll() {
		List<Countries> findAll = countryRepository.findAll();
			
		
		return findAll;
	}

	@Override
	public boolean save(Countries countries) {
		Countries save = countryRepository.save(countries);
		if(save!=null) {
			return false;
		}else {
			return true;
		}
	}
	
	@Override
	public Countries get(Integer id) {
		Optional<Countries> findById = countryRepository.findById(id);
		return findById.get();
	}

	@Override
	public void delete(Integer id) {
		countryRepository.deleteById(id);
	
	}

	@Override
	public void update(Integer id, Countries countries) {
		Countries findById = countryRepository.findById(id).get();
		findById.setCountryName(findById.getCountryName());
		findById.setCapitalName(findById.getCapitalName());
		countryRepository.save(findById);
	}

	
	
}
