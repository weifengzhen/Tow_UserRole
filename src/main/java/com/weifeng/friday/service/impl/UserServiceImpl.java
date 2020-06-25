package com.weifeng.friday.service.impl;

import com.weifeng.friday.base.result.Results;
import com.weifeng.friday.dao.UserDao;
import com.weifeng.friday.model.SysUser;
import com.weifeng.friday.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public SysUser getUser(String username) {
        return userDao.getUser(username);
    }

    @Override
    public Results<SysUser> getAllUserByPage(Integer offset, Integer limit) {


        return Results.success(userDao.countAllUser().intValue(),userDao.getAllUserByPage(offset,limit));
    }
}