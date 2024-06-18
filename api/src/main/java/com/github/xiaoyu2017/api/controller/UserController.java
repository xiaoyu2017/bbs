package com.github.xiaoyu2017.api.controller;

import com.github.xiaoyu2017.api.domain.vo.Result;
import com.github.xiaoyu2017.api.domain.vo.UserVo;
import com.github.xiaoyu2017.api.server.UserService;
import com.github.xiaoyu2017.api.tool.BeanTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制类
 *
 * @author xiaoyu
 * @version 1.0
 */
@RestController
@Api(tags = "用户管理")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    @ApiOperation(value = "新增用户", notes = "新增用户名和密码")
    public ResponseEntity<Result<String>> add(UserVo userVo) {
        return ResponseEntity.ok(userService.add(BeanTool.beanToUser(userVo)));
    }

    @DeleteMapping("/{uid}")
    @ApiOperation(value = "删除用户", notes = "根据UID删除用户")
    @ApiImplicitParam(name = "uid", value = "用户UID", required = true, paramType = "path", example = "321321")
    public ResponseEntity<Result<String>> remove(@PathVariable String uid) {
        return ResponseEntity.ok(userService.remove(uid));
    }

    @PutMapping
    @ApiOperation(value = "修改用户", notes = "修改用户名或密码")
    public ResponseEntity<String> remove(UserVo userVo) {
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/{uid}")
    @ApiOperation(value = "获得用户", notes = "根据UID获得用户")
    @ApiImplicitParam(name = "uid", value = "用户UID", required = true, paramType = "path", example = "321321")
    public ResponseEntity<String> findByUid(@PathVariable String uid) {
        return ResponseEntity.ok("Success");
    }

}
