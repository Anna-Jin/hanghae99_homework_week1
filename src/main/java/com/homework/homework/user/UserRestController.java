package com.homework.homework.user;

import com.homework.homework.user.dto.UserDto;
import com.homework.homework.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserRestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public Map<String, Object> createUser(@RequestBody UserDto userDto) {
        Map<String, Object> result = new HashMap<>();

        // service 연결
        Long userId = userService.saveUser(userDto);

        if (userId != null) {
            result.put("result", "아이디 생성 완료");
        } else {
            result.put("result", "아이디 생성을 실패했습니다. 관리자에게 문의해주세요.");
            logger.error("[user] 유저 아이디: {}", userId);
        }

        return result;
    }
}
