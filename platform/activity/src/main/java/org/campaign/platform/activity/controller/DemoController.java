package org.campaign.platform.activity.controller;

import org.campaign.platform.activity.mapper.DemoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 连通性示例接口（可删除）
 */
@RestController
@RequestMapping("/api/demo")
public class DemoController {

    private final DemoMapper demoMapper;

    public DemoController(DemoMapper demoMapper) {
        this.demoMapper = demoMapper;
    }

    @GetMapping("/db")
    public String db() {
        return demoMapper.checkConnection() == 1 ? "MySQL connection OK" : "unexpected result";
    }
}
