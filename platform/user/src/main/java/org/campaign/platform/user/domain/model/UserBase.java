package org.campaign.platform.user.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * 领域模型，UserBase
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserBase {
    private String uId;
    private String uName;
    private Long birthday;
    private Integer gender;
    private String description;
    private String extra;
}
