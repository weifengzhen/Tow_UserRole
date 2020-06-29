package com.weifeng.friday.dao;

import com.weifeng.friday.model.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
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


    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into sys_user(username, password, nickname, headImgUrl, phone, telephone, email, birthday, sex, status, createTime, updateTime) values(#{username}, #{password}, #{nickname}, #{headImgUrl}, #{phone}, #{telephone}, #{email}, #{birthday}, #{sex}, #{status}, now(), now())")
    int save(SysUser user);


    @Select("select * from sys_user where telephone=#{phone}" )
    SysUser getAllByPhone(String phone);

    @Select("select * from sys_user where id=#{id}" )
    Object getById(Integer id);

}