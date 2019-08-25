package com.gis_server.service.Impl;

import com.gis_server.pojo.User;
import com.gis_server.service.UserService;
import com.gis_server.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public User findUserByUName(String username) {
        return userMapper.selectByUsername(username);
    }

    public void addUser(User user) {
        this.userMapper.insert(user);
        int i = 1/0;
    }
}
