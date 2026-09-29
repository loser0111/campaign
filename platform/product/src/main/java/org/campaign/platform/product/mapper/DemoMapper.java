package org.campaign.platform.product.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 连通性示例 Mapper（验证 MyBatis + MySQL 配置可用，可删除）
 */
@Mapper
public interface DemoMapper {

    @Select("SELECT 1")
    int checkConnection();
}
