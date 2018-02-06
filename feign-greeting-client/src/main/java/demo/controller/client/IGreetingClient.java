package demo.controller.client;

import demo.controller.IGreetingController;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("rest-greeting")
public interface IGreetingClient extends IGreetingController {}
