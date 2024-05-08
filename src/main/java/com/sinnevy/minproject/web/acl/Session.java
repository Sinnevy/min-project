package com.sinnevy.minproject.web.acl;


import com.sinnevy.minproject.dto.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class Session {

    /**
     * 用户信息
     */
    private UserDto userDto;

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto doctorDto) {
        this.userDto = doctorDto;
    }

}
