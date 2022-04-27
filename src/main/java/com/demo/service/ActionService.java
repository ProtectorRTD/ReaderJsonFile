package com.demo.service;

import com.demo.entity.User;

public interface ActionService {
    void save(User user);
    void remove(User user);
    void removeByEmail(String email);
    void removeByIp_address(String ip_address);
    User[] getAll();
}
