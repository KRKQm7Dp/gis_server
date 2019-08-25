package com.gis_server.service;

import com.gis_server.pojo.User;

public interface UserService {

    User findUserById(Integer id);

    User findUserByUName(String username);

    void addUser(User user);

}
