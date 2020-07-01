package com.weifeng.friday.service.impl;

import com.weifeng.friday.base.result.Results;
import com.weifeng.friday.dao.RoleUserDao;
import com.weifeng.friday.model.SysRoleUser;
import com.weifeng.friday.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleUserServiceImpl  implements RoleUserService {
    @Autowired
    private RoleUserDao roleUserDao;

    @Override
    public Results getSysRoleUserByUserId(Integer userId) {
        SysRoleUser sysRoleUserByUserId = roleUserDao.getSysRoleUserByUserId(userId);

        if (sysRoleUserByUserId!=null ){
            return Results.success(sysRoleUserByUserId);
        }
        else {
            return Results.success();
        }
    }
}
