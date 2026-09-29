package org.campaign.platform.user.controller.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.campaign.platform.user.domain.model.UserBase;

/**
 * 数据传输的DTO内容
 */
@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    UserBase userBase;

    public UserDTO (UserBase userBase) {
        this.userBase = userBase;
    }
}
