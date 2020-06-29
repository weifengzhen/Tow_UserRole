package com.weifeng.friday.service.impl;

import com.weifeng.friday.base.result.Results;
import com.weifeng.friday.dao.RoleUserDao;
import com.weifeng.friday.dao.UserDao;
import com.weifeng.friday.dto.UserDto;
import com.weifeng.friday.model.SysRoleUser;
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

    @Autowired
    private RoleUserDao roleUserDao;

    @Override
    public SysUser getUser(String username) {
        return userDao.getUser(username);
    }

    /**
     * 分页逻辑
     * @param offset
     * @param limit
     * @return
     */
    @Override
    public Results<SysUser> getAllUserByPage(Integer offset, Integer limit) {


        return Results.success(userDao.countAllUser().intValue(),userDao.getAllUserByPage(offset,limit));
    }


    /**
     * 用户信息的保存
     * @param userDto 用户信息
     * @param roleId  用户与角色id
     * @return
     */
    @Override
    public Results save(UserDto userDto, Integer roleId) {

        if (roleId!=null){
//            先保存用户
            userDao.save(userDto);

//            保存完后,保存与role-user关联的中间表id
            SysRoleUser sysRoleUser=new SysRoleUser();
            sysRoleUser.setRoleId(roleId);
            sysRoleUser.setUserId(userDto.getId().intValue());
//            然后保存到中间表
            roleUserDao.save(sysRoleUser);

            return Results.success();
        }
        return Results.failure();
    }

    @Override
    public SysUser getAllByPhone(String phone) {
        SysUser sysUser=userDao.getAllByPhone(phone);
        return sysUser;
    }

    @Override
    public Object getById(Integer id) {
        return userDao.getById(id);

    }
}