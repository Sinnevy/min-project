package com.sinnevy.minproject.controller;

import com.sinnevy.minproject.dto.UserDto;
import com.sinnevy.minproject.service.UserService;
import com.sinnevy.minproject.web.Result;
import com.sinnevy.minproject.web.code.DefaultErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final String COOKIENAME = "passport";

    @Autowired
    private UserService userService;

    /**
     * 测试部署成功接口
     * @return
     */
    @GetMapping("/test")
    public ResponseEntity<Result> test() {
        Map<String, Object> map = new HashMap<>();
        map.put("user", null);
        map.put("config", null);
        return ResponseEntity.ok(Result.success(map));
    }

    /**
     * 用户注册接口
     * @param dto
     * @return
     */
    @PostMapping("/signup")
    public ResponseEntity<Result> signUp(@RequestBody UserDto dto, HttpServletResponse response) throws IOException {

        return ResponseEntity.ok(new Result.Builder<>(false).error(DefaultErrorCode.NO_SAME).build());
    }


    /**
     * 给角色分配权限
     * @return
     */
    @PostMapping("/allocate")
    public ResponseEntity<Result> allocate(@RequestParam("userId") Integer userId,
                                           @RequestParam("roleId") Integer roleId) {
        userService.allocateRole(userId, roleId);
        return ResponseEntity.ok(Result.success(null));
    }

    /**
     * 所有用户接口
     * @return users
     */
    @GetMapping("/list")
    public ResponseEntity<Result> list() {
        Map<String, Object> map = new HashMap<>();
        map.put("users", userService.list());
        return ResponseEntity.ok(Result.success(map));
    }

    /**
     * 管理员新增用户注册接口
     * @param dto 用户信息
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody UserDto dto) {
        if (1 == 1) {
            return ResponseEntity.ok(Result.success(null));
        }
        return ResponseEntity.ok(new Result.Builder<>(false)
                .error(DefaultErrorCode.ACCESS_DENIED).build());
    }


}
