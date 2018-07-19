/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.m07_springmvc_jpa_relationship.service;

import com.mycompany.m07_springmvc_jpa_relationship.entities.UserDetailEntity;
import com.mycompany.m07_springmvc_jpa_relationship.entities.UserEntity;
import com.mycompany.m07_springmvc_jpa_relationship.repository.UserDetailRepository;
import com.mycompany.m07_springmvc_jpa_relationship.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AnhLe
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailRepository userDetailRepository;

    public List<UserEntity> getLstUser() {
        List<UserEntity> lstU = (List<UserEntity>) userRepository.findAll();
        return lstU;
    }

    public UserEntity addNewUser(UserEntity user) {
        UserEntity u = new UserEntity();
        u = userRepository.save(user);
        if (u.getId() > 0) {
            if (u.getUserDetail() != null) {
                UserDetailEntity userDetail = u.getUserDetail();
                userDetail.setUser(u);
                userDetailRepository.save(userDetail);
            } else {
                UserDetailEntity userDetail = new UserDetailEntity();
                userDetail.setUser(u);
                userDetailRepository.save(userDetail);
            }
        }
        return u;
    }

    public UserEntity getUserById(int id) {
        return userRepository.findOne(id);
    }

    public void deleteUserByIdNoMessage(int id) {
        userRepository.delete(id);
    }

    public List<UserEntity> findUserByEmail(String searchText) {
//        return userRepository.findByEmailContaining(searchText);
//        return userRepository.findUserByFirstnameOrLastName("%" + searchText + "%", "%" + searchText + "%");
        return userRepository.findUserNativeQuery("%" + searchText + "%", "%" + searchText + "%");
    }

}
