/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.m07_springmvc_jpa_relationship.repository;

import com.mycompany.m07_springmvc_jpa_relationship.entities.CountriesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AnhLe
 */
@Repository
public interface CountryRepository extends CrudRepository<CountriesEntity, Integer> {

}
