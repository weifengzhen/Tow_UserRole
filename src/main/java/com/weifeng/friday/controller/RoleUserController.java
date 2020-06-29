package com.weifeng.friday.controller;


import com.weifeng.friday.base.result.Results;
import com.weifeng.friday.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/roleuser")
public class RoleUserController {



    @Autowired
    private RoleUserService roleUserService;

    @PostMapping("getRoleUserByUserId")
    @ResponseBody
    public Results getRoleUserByUserId(@RequestParam Integer userID){


        return null;

    }
}
