package com.weifeng.friday.controller;

import com.weifeng.friday.base.result.PageTableRequest;
import com.weifeng.friday.base.result.ResponseCode;
import com.weifeng.friday.base.result.Results;
import com.weifeng.friday.dto.UserDto;
import com.weifeng.friday.model.SysUser;
import com.weifeng.friday.service.UserService;

import com.weifeng.friday.utils.MD5;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.xml.ws.Response;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    @ResponseBody
    public SysUser user(@PathVariable String username) {
        return userService.getUser(username);
    }

    @GetMapping("/list")
    @ResponseBody
    public Results<SysUser> getUsers(PageTableRequest pageTableRequest) {

        pageTableRequest.countOffset();

        Results<SysUser> results=userService.getAllUserByPage(pageTableRequest.getOffset(),pageTableRequest.getLimit());
        return results;
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute(new SysUser());

        return "user/user-add";
    }

    @PostMapping("/add")
    @ResponseBody
    public Results<SysUser> saveUser(UserDto userDto,Integer roleId) {
        SysUser sysUser =null;

        sysUser=userService.getAllByPhone(userDto.getPhone());
        if (sysUser!=null && sysUser.getId().equals(userDto.getId())){
            return Results.failure(ResponseCode.PHONE_REPEAT.getCode(),ResponseCode.PHONE_REPEAT.getMessage());
        }

        userDto.setStatus(1);  //设置开启状态
                                //调用工具类进行md5加密
        userDto.setPassword(MD5.crypt(userDto.getPassword()));

        return userService.save(userDto,roleId);


    }


    /**
     * 由于用户上传信息是  日期与数据库不符合  进行转换
     */
    String patt="yyyy-MM-dd";
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest){
       webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat(patt),true));

    }


    /**
     * 用户编辑管理
     * @param model
     * @param sysUser
     * @return
     */
    @GetMapping("/edit")
    public String edit(Model model,SysUser sysUser) {

        model.addAttribute(userService.getById(sysUser.getId().intValue()));
        return "user/user-edit";
    }
}