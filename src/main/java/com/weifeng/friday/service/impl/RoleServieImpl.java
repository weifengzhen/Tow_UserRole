package com.weifeng.friday.service.impl;


import com.weifeng.friday.base.result.Results;
import com.weifeng.friday.dao.RoleDao;
import com.weifeng.friday.model.SysRole;
import com.weifeng.friday.model.SysUser;
import com.weifeng.friday.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServieImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Results<SysRole> getAllRole() {
        return Results.success(50,roleDao.getAllRoles());
    }
}
