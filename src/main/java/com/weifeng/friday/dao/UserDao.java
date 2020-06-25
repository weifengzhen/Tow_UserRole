package com.weifeng.friday.dao;

import com.weifeng.friday.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from sys_user t where t.username = # {username}")
    SysUser getUser(String username);


//    分页查询数据
    @Select("select * from sys_user t order by t.id limit #{startPosition},#{limit}")
    List<SysUser> getAllUserByPage(Integer startPosition,Integer limit);

    /**
     * 分页查询 总条数
     * @return
     */
    @Select("select count(*) from sys_user")
    Long countAllUser();

}