package io.lgsity.qaforum.mapper;

import io.lgsity.qaforum.pojo.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author shulinYuan
 * @Date 2021/4/9 21:05
 * @Version 1.0
 */
@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag)" +
            "values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void insert(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> findAll(@Param("offset") Integer offset, @Param("size")Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question where creator=#{id} limit #{offset},#{size}")
    List<Question> findQuestionByUserId(@Param("id") Integer id, @Param("offset") Integer offset, @Param("size")Integer size);

    @Select("select count(1) from question where creator=#{id}")
    Integer countByUserId(@Param("id")Integer id);

    @Select("select * from question where id=#{id}")
    Question getQuestionById(@Param("id")Integer id);
}
