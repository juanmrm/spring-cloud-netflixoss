package demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TimeoutController {

    /**
     * For testing purposes. Hystrix fallbacks for routes in Zuul. If you hit http://localhost:8765/self/timeout you can see the fallback functionality in action.
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/timeout")
    public String timeout() throws InterruptedException {
        Long timeout = ((int) (Math.ceil(Math.random() * 10))) % 2 == 0 ? 2000L : 8500L;
        log.info("Calculated timeout for this time is: {}ms.", timeout);
        Thread.sleep(timeout);
        return "timeout";
    }
}
