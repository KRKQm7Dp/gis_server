package com.gis_server.controller;

import com.gis_server.common.entity.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class LoginController {

    @GetMapping("/login")
    public JsonResult login(HttpServletRequest request){
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies){
//            if(cookie.getName().equals("JSESSIONID")){
//
//            }
//        }
        return null;
    }

}
