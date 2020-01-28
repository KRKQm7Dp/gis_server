package com.gis_server.controller;

import com.gis_server.common.entity.JsonResult;
import com.gis_server.common.utils.ResultTool;
import com.gis_server.pojo.SysUser;
import com.gis_server.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    SysUserService sysUserService;

    @RequestMapping(value = "getAllUser", method = RequestMethod.GET)
    public JsonResult getAllUser(){
        List<SysUser> users = sysUserService.getAllUser();
        users.forEach(item -> {
            item.setuPassword("");
        });
        return ResultTool.success(users);
    }

    @RequestMapping(value = "getUserByPage", method = RequestMethod.GET)
    public JsonResult getUserByPage(@RequestParam("pageNum") Integer pageNum,
                                    @RequestParam("pageSize") Integer pageSize){
        return ResultTool.success(sysUserService.getUserByPage(pageNum, pageSize));
    }

    @GetMapping("/getUser")
    public JsonResult getUserById(@RequestParam("username") String uLoginid){
        SysUser user = sysUserService.findUserByLoginID(uLoginid);
        user.setuPassword("");
        return ResultTool.success(user);
    }


    /**
     * 用于修改用户信息
     * Content-Type: application/json
     * @param user
     * @return
     */
    @PostMapping("modifyUser")
    public JsonResult modifyUser(@RequestBody SysUser user){
        System.out.println(user);
        sysUserService.modifyUser(user);
        return null;
    }

}
