package demo.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingControllerImpl implements GreetingController {

    @Override
    public String greeting() {
        return String.format("Hello from Rest Greeting Application!");
    }
}
