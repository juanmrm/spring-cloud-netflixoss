package demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public interface IGreetingController {
    @RequestMapping("/greeting")
    String greeting();
}
