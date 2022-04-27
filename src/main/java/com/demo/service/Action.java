package com.demo.service;

import com.demo.entity.User;
import com.demo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class Action implements ActionService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public void save(User user) {
        userInfoRepository.save(user);
    }

    @Override
    public void remove(User user) {
        userInfoRepository.delete(user);
    }


    public void removeByEmail(String email)
    {
        userInfoRepository.removeByEmail(email);
    }

    @Override
    public void removeByIp_address(String ip_address) {
        userInfoRepository.removeByIp_address(ip_address);
    }

//    @Override
//    public User getUserByNick(String first_name) {
//        return userInfoRepository.findByFirst_name(first_name);
//    }
//
//    @Override
//    public User getUserByIpAddress(String ip_address) {
//        return userInfoRepository.findByIp_address(ip_address);
//    }


    @Override
    public User[] getAll() {
        return (User[]) userInfoRepository.findAll().toArray();
    }
}
