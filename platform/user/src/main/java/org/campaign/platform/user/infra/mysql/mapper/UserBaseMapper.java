package org.campaign.platform.user.infra.mysql.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.campaign.platform.user.domain.model.UserBase;

import java.util.List;

/**
 * 用户基础信息 Mapper
 * 列名下划线 u_name -> 实体字段 uName 由 map-underscore-to-camel-case 自动映射
 */
@Mapper
public interface UserBaseMapper {

    @Select("SELECT u_id, u_name, birthday, gender, description, extra FROM tb_user_base WHERE u_id = #{uId}")
    UserBase selectByUId(String uId);

    @Select("SELECT u_id, u_name, birthday, gender, description, extra FROM tb_user_base")
    List<UserBase> selectAll();

    @Insert("INSERT INTO tb_user_base(u_id, u_name, birthday, gender, description, extra) " +
            "VALUES(#{uid}, #{uName}, #{birthday}, #{gender}, #{description}, #{extra})")
    int insert(UserBase user);

    @Update("UPDATE tb_user_base SET u_name = #{uName}, birthday = #{birthday}, " +
            "gender = #{gender}, description = #{description}, extra = #{extra} WHERE u_id = #{uId}")
    int update(UserBase user);

    @Delete("DELETE FROM tb_user_base WHERE u_id = #{uId}")
    int deleteByUId(String uId);
}
