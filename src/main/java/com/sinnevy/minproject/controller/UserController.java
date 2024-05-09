package com.sinnevy.minproject.controller;

import com.sinnevy.minproject.dto.UserDto;
import com.sinnevy.minproject.service.UserService;
import com.sinnevy.minproject.vo.UserVo;
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
    public ResponseEntity<Result> test(@RequestParam("id") Integer userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", null);
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
     * 所有用户接口
     * @return users
     */
    @PostMapping("/list")
    public ResponseEntity<Result> list(@RequestBody UserVo userVo) {
        Map<String, Object> map = new HashMap<>();
        map.put("users", userService.list(userVo));
        return ResponseEntity.ok(Result.success(map));
    }

    /**
     * 管理员新增用户注册接口
     * @param dto 用户信息
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody UserDto dto) {
        userService.add(dto);
        return ResponseEntity.ok(Result.success(null));
    }


}
