package com.weifeng.friday.service;

import com.weifeng.friday.base.result.Results;
import com.weifeng.friday.model.SysRole;
import com.weifeng.friday.model.SysUser;

public interface RoleService {



    Results<SysRole> getAllRole();
}