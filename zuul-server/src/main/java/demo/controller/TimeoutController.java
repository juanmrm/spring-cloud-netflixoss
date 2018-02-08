package demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface TimeoutController {

    @RequestMapping("/timeout")
    String timeout(@RequestParam(value="force", defaultValue="false") Boolean force) throws InterruptedException;

}
