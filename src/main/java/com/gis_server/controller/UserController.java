package com.gis_server.controller;

import com.gis_server.pojo.User;
import com.gis_server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public User login(@RequestParam(value = "username", required = true) String username,
                      @RequestParam(value = "password", required = true) String password){

        logger.debug("username=" + username + "  password=" + password);
        User user = userService.findUserByUName(username);
        logger.debug("username=" + user.getUsername() + "  password=" + user.getPassword());
        if(user.getPassword().equals(password)){
            return user;
        }
        return user;
    }

}
