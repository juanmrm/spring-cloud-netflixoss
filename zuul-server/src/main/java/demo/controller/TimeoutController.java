package demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeoutController {

    /**
     * For testing purposes. Hystrix fallbacks for routes in Zuul. If you hit http://localhost:8765/self/timeout you can see the fallback functionality in action.
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/timeout")
    public String timeout() throws InterruptedException {
        Thread.sleep(30000);
        System.out.println("Executing timeout in TimeoutController");
        return "timeout";
    }
}
