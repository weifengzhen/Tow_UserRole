package com.weifeng.friday.controller;


import com.weifeng.friday.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("role")
@Slf4j
public class RoleController {


    @GetMapping("/role")
    @ResponseBody
    public SysUser user(@PathVariable String username) {
        return null;
    }
}
