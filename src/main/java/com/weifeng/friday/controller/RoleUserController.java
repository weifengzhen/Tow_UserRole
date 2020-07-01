package com.weifeng.friday.controller;


import com.weifeng.friday.base.result.Results;
import com.weifeng.friday.service.RoleUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/roles")
@Slf4j
public class RoleUserController {


    @Autowired
    private RoleUserService roleUserService;

    @PostMapping("/getRoleUserByUserId")
    @ResponseBody
    public Results getRoleUserByUserId(Integer userId) {
        log.info("getRoleUserByUserId（"+userId+"）");
        Results id = roleUserService.getSysRoleUserByUserId(userId);

        return id;

    }
}
