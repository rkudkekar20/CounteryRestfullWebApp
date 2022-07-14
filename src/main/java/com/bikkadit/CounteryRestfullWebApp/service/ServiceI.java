package com.bikkadit.CounteryRestfullWebApp.service;

import java.util.List;


import com.bikkadit.CounteryRestfullWebApp.model.Countries;

public interface ServiceI {
	
public List<Countries> listAll();
public boolean save(Countries countries);
public Countries get(Integer id);
public void delete(Integer id);
public void  update(Integer id ,Countries countries);

}
