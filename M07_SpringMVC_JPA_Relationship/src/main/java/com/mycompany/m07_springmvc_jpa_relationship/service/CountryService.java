/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.m07_springmvc_jpa_relationship.service;

import com.mycompany.m07_springmvc_jpa_relationship.entities.CountriesEntity;
import com.mycompany.m07_springmvc_jpa_relationship.repository.CountryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AnhLe
 */
@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<CountriesEntity> getLstCountries() {
        return (List<CountriesEntity>) countryRepository.findAll();
    }
}
