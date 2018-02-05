package demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetingController {

    @RequestMapping("greeting")
    public String greeting() {
        return "Hello from Rest Greeting Application!";
    }

}
