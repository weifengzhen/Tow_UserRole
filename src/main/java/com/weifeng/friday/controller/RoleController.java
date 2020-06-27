package com.weifeng.friday.controller;


import com.weifeng.friday.base.result.Results;
import com.weifeng.friday.model.SysRole;
import com.weifeng.friday.model.SysUser;
import com.weifeng.friday.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("role")
@Slf4j
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/all")
    @ResponseBody
    public Results<SysRole> getAll() {
        log.info("RoleController.getAll()");


        return roleService.getAllRole();
    }
}
