package com.weifeng.friday.service;

import com.weifeng.friday.base.result.Results;
import com.weifeng.friday.model.SysUser;

public interface UserService {
    SysUser getUser(String username);



    Results<SysUser> getAllUserByPage(Integer offset, Integer limit);
}