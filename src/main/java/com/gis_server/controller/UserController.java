package com.gis_server.controller;

import com.gis_server.pojo.Data;
import com.gis_server.pojo.Result;
import com.gis_server.pojo.User;
import com.gis_server.service.UserService;
import com.gis_server.utils.DateUtils;
import com.gis_server.utils.StatusCode;
import com.gis_server.utils.TokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(HttpServletRequest request,
                        @RequestParam(value = "username", required = true) String username,
                        @RequestParam(value = "password", required = true) String password){

        logger.debug("接收到的参数：username=" + username + "  password=" + password);
        User user = null;

        Result res = new Result();

        try{
            user = userService.findUserByUName(username);
        } catch (Exception ex){
            logger.error("failed:数据库连接异常");
            res.setCode(StatusCode.STATUS_CODE_FAILED);
            return res;
        }

        if (user == null){
            res.setMsg("failed:无此用户");
            res.setCode(StatusCode.STATUS_CODE_FAILED);
        }else{
            if(!user.getPassword().equals(password)){
                res.setMsg("failed:密码错误");
                res.setCode(StatusCode.STATUS_CODE_FAILED);
            }else{
                String now = DateUtils.getNow();
                Data data = new Data();
                data.setLast_login_ip(request.getRemoteAddr());
                data.setToken(TokenUtils.newToken(username, now));
                data.setLast_login_time(now);
                res.setMsg("success");
                res.setCode(StatusCode.STATUS_CODE_SUCCESS);
                res.setUser(user);
                res.setData(data);
            }
        }

        return res;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result register(HttpServletRequest request,
                           @RequestParam(value = "username", required = true) String username,
                           @RequestParam(value = "password", required = true) String password){
        logger.debug("接收到的参数：username=" + username + "  password=" + password);
        User user = null;
        Result res = new Result();

        try{
            user = userService.findUserByUName(username);
        }catch (Exception ex){
            logger.error("failed:数据库连接异常");
            res.setCode(StatusCode.STATUS_CODE_FAILED);
            return res;
        }

        if (user != null){
            res.setMsg("failed:用户已存在");
            res.setCode(StatusCode.STATUS_CODE_FAILED);
            return res;
        }

        user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAuthority(User.USER_AUTHORITY_ORDINARY);

        try{
            userService.addUser(user);
        }catch (Exception ex){
            logger.error(ex.toString());
            res.setMsg("failed:注册失败");
            res.setCode(StatusCode.STATUS_CODE_FAILED);
            return res;
        }

        String now = DateUtils.getNow();
        Data data = new Data();
        data.setLast_login_ip(request.getRemoteAddr());
        data.setLast_login_time(now);
        data.setToken(TokenUtils.newToken(username, now));
        res.setMsg("success");
        res.setCode(StatusCode.STATUS_CODE_SUCCESS);
        res.setData(data);

        return res;
    }

}
