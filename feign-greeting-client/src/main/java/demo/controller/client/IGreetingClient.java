package demo.controller.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("rest-greeting")
public interface IGreetingClient {
    @RequestMapping("/greeting")
    String greeting();
}
