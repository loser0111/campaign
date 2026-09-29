package org.campaign.platform.user.controller;

import org.apache.catalina.User;
import org.apache.logging.log4j.util.Strings;
import org.campaign.platform.user.controller.model.api.UpsertUserReq;
import org.campaign.platform.user.controller.model.dto.UserDTO;
import org.campaign.platform.user.domain.model.UserBase;
import org.campaign.platform.user.domain.service.user_base.UserBaseService;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 用户基础信息接口（示例：验证 Spring Boot + MyBatis + MySQL 全链路）
 * // 首先至少要包含用户的创建，用户的登录，用户的基本信息获取
 *
 */
@RestController
@RequestMapping("/api/users")
public class UserBaseController {

    private final UserBaseService userBaseService;

    public UserBaseController(UserBaseService userBaseService) {
        this.userBaseService = userBaseService;
    }

    @GetMapping
    public R<List<UserDTO>> list() {
        List<UserBase> bases = userBaseService.listAll();
        if (CollectionUtils.isEmpty(bases)) {
            return R.SUCCESS(Collections.emptyList());
        }
        return R.SUCCESS(bases.stream().map(UserDTO::new).toList());
    }

    /**
     * 点查询
     */
    @GetMapping("/{uid}")
    public R<UserDTO> get(@PathVariable String uId) {
        UserBase userBase = userBaseService.getByUId(uId);
        return R.SUCCESS(new UserDTO(userBase));
    }

    @PostMapping
    public R<UserDTO> upsertUser(@RequestBody UpsertUserReq req) {
        // 新增 or 更新
        // 创建UserBase
        UserBase userBase = UserBase.builder()
                .uId(req.getUId())
                .uName(req.getUName())
                .birthday(req.getBirthday())
                .gender(req.getGender())
                .description(req.getDescription())
                .build();
        if (Strings.isBlank(req.getUId())) {
            UserBase userBase1 = userBaseService.create(userBase);
            return Objects.isNull(userBase1) ? R.FAIL() : R.SUCCESS(new UserDTO( userBase1));
        }
        UserBase userBase1 = userBaseService.update(userBase);
        return Objects.isNull(userBase1) ? R.FAIL() : R.SUCCESS(new UserDTO( userBase1));
    }

    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable String id) {
        return userBaseService.deleteByUId(id) > 0 ? R.SUCCESS() : R.FAIL();
    }
}
