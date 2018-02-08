package demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TimeoutControllerImpl implements TimeoutController{

    /**
     * For testing Hystrix fallbacks for routes in Zuul.
     * Hit http://localhost:8765/self/timeout?force=true you can see the fallback functionality in action.
     *
     * TODO: Currently there are problems with timeout: https://github.com/spring-cloud/spring-cloud-netflix/issues/2379 / https://github.com/spring-cloud/spring-cloud-netflix/pull/2633
     *
     * @return
     * @throws InterruptedException
     */
    @Override
    public String timeout(@RequestParam(value="force", defaultValue="false") Boolean force) throws InterruptedException {
        Thread.sleep(force ? 8500L : 1000L);
        return "timeout";
    }
}
