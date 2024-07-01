package com.github.xiaoyu2017.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异常控制类
 *
 * @author xiaoyu
 * @version 1.0
 */
@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping("/noPermissions")
    public ResponseEntity<String> noPermissions() {
        return ResponseEntity.ok("您无权访问此url，很抱歉！");
    }

}
