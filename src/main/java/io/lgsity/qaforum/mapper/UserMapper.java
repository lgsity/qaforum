package io.lgsity.qaforum.mapper;

import io.lgsity.qaforum.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author shulinYuan
 * @Date 2021/4/9 11:39
 * @Version 1.0
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified,avatar_url) " +
            "values(#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select id,account_id,name,token,gmt_create,gmt_modified,avatar_url from user where token=#{token}")
    User findUserByToken(@Param("token") String token);

    @Select("select id,account_id,name,token,gmt_create,gmt_modified,avatar_url from user where id=#{id}")
    User findUserById(@Param("id") Integer id);
}
