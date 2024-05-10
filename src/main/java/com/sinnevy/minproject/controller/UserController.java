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
    @GetMapping("/getById")
    public ResponseEntity<Result> getById(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(Result.success(null));
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
        return ResponseEntity.ok(Result.success(userService.list(userVo)));
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

    @GetMapping("/delete")
    public ResponseEntity<Result> delete(Integer id) {
        userService.delete(id);
        return ResponseEntity.ok(Result.success(null));
    }

    @PostMapping("/update")
    public ResponseEntity<Result> update(@RequestBody UserDto dto) {
        userService.update(dto);
        return ResponseEntity.ok(Result.success(null));
    }

}
