package com.bikkadit.CounteryRestfullWebApp.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikkadit.CounteryRestfullWebApp.model.Countries;
@Repository
public interface CountryRepository extends JpaRepository<Countries, Integer> {

}
