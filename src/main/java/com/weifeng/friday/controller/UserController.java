package com.weifeng.friday.controller;

import com.weifeng.friday.base.result.PageTableRequest;
import com.weifeng.friday.base.result.Results;
import com.weifeng.friday.model.SysUser;
import com.weifeng.friday.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}