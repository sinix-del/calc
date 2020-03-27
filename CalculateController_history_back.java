package com.example.Calculate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CalculateController {
    @GetMapping("/calculate")
    public String calculate(@RequestParam String ip, String timeFrontEnd, Integer width, Integer length)
    {
        Integer res = width*length;

        RestTemplate resttemplate = new RestTemplate();
        String URL = "https://postman-echo.com/get?ip=" + ip + "&timeFrontEnd=" + timeFrontEnd + "&width=" + width + "&length=" + length + "&result=" + res;
        String answer = resttemplate.getForObject(URL, String.class);
        return answer;
    }
}
