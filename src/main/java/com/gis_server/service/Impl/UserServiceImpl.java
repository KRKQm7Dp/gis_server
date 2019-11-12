package com.gis_server.service.Impl;

import com.gis_server.dao.UserMapper;
import com.gis_server.pojo.User;
import com.gis_server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    public User findUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User findUserByUName(String username) {
        return userMapper.selectByUsername(username);
    }

    @Transactional
    public void addUser(User user) {
        this.userMapper.insert(user);
    }
}
