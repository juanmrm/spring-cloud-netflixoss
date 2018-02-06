package demo;

import demo.filter.SimplePostFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ZuulServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulServerApplication.class).web(true).run(args);
    }

    @Bean
    public SimplePostFilter simplePreFilter() {
        return new SimplePostFilter();
    }

}
