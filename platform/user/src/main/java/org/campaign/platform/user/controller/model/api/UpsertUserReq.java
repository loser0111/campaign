package org.campaign.platform.user.controller.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpsertUserReq {
    private String uId;
    private String uName;
    private Long birthday;
    private Integer gender;
    private String description;
}
