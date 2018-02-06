package demo.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController implements IGreetingController {

    @Override
    public String greeting() {
        return String.format("Hello from Rest Greeting Application!");
    }
}
