package com.mbti.config.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@GetMapping("/test")
    public String test() throws Exception {
        return "test";
    }
	
    @GetMapping("/sync-error")
    public String syncError() throws Exception {
        throw new Exception("동기 에러 발생!");
    }

    @GetMapping("/async-error")
    @ResponseBody
    public String asyncError() throws Exception {
        throw new Exception("비동기 에러 발생!");
    }
}
