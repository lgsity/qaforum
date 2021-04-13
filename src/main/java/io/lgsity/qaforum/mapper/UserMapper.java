package io.lgsity.qaforum.mapper;

import io.lgsity.qaforum.pojo.User;
import org.apache.ibatis.annotations.*;

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

    @Select("select id,account_id,name,token,gmt_create,gmt_modified,avatar_url from user where account_id=#{id}")
    User findByAccountId(@Param("id") String accountId);

    @Update("update user set name=#{name},token=#{token},gmt_modified=#{gmtModified},avatar_url=#{avatarUrl} where id=#{id}")
    void update(User dbUser);
}
