/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.m07_springmvc_jpa_relationship.repository;

import com.mycompany.m07_springmvc_jpa_relationship.entities.UserEntity;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AnhLe
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    public List<UserEntity> findByEmailContaining(String searchText);

    @Query("Select u from UserEntity u where u.userDetail.firstname "
            + "like ?1 or  u.userDetail.lastname like ?2")
    public List<UserEntity> findUserByFirstnameOrLastName(String firstName, String lastName);

    @Query(value = "SELECT * FROM user u JOIN user_detail ud "
            + "ON u.id = ud.user_fk "
            + "WHERE ud.first_name LIKE ?1 or ud.last_name LIKE ?2",
            nativeQuery = true)
    public List<UserEntity> findUserNativeQuery(String firstName, String lastName);
}
