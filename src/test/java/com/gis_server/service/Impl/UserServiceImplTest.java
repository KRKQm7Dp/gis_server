package com.gis.service.Impl;


import com.gis_server.pojo.User;
import com.gis_server.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImplTest {

    ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("applicationContext.xml");
    UserService userService = applicationContext.getBean(UserService.class);

    @Test
    public void testFindUserById() {
        System.out.println(userService.findUserById(1).getUsername());
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("xiaowang");
        user.setPassword("123456");
        user.setAuthority("1");
        userService.addUser(user);

    }
}
