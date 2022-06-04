package com.homework.homework.restController;

import com.homework.homework.dto.CommentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentRestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("")
    public Map<String, Object> addComment(@RequestBody CommentDto commentDto) {
        Map<String, Object> result = new HashMap<>();

        // service 연결


        return result;
    }

}
