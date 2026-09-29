package org.campaign.platform.user.domain.service.user_base;

import org.campaign.platform.user.domain.model.UserBase;
import org.campaign.platform.user.infra.mysql.mapper.UserBaseMapper;
import org.campaign.platform.user.utils.IdGenerateUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户基础信息服务
 */
@Service
public class UserBaseService {

    // 构建Bean的时候，通过依赖关系解开的凡是
    private final UserBaseMapper userBaseMapper;

    public UserBaseService(UserBaseMapper userBaseMapper) {
        this.userBaseMapper = userBaseMapper;
    }

    public UserBase getByUId(String uId) {
        return userBaseMapper.selectByUId(uId);
    }

    public List<UserBase> listAll() {
        return userBaseMapper.selectAll();
    }

    public UserBase create(UserBase user) {
        // 生成uuId
        String uId = IdGenerateUtils.generateUId();
        user.setUId(uId);
        int cnt = userBaseMapper.insert(user);
        if (cnt > 0) {
            return user;
        }
        return null;
    }

    /**
     * 是否会更新失败呢
     * @param user
     * @return
     */
    public UserBase update(UserBase user) {
        int cnt = userBaseMapper.update(user);
        if (cnt > 0) {
            return user;
        }
        return null;
    }

    public int deleteByUId(String uId) {
        return userBaseMapper.deleteByUId(uId);
    }
}
