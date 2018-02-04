package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZuulServerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = { "management.security.enabled=false" }) // management.security.enabled -> Disable security
public class ZuulServerApplicationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Value("${management.context-path}")
    private String managementPath;

    @Test
    public void adminLoads() {
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> entity = testRestTemplate.getForEntity(this.managementPath + "/env", Map.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

// TODO: Currently there are problems with timeout: https://github.com/spring-cloud/spring-cloud-netflix/issues/2379 / https://github.com/spring-cloud/spring-cloud-netflix/pull/2633
//    @Test
//    public void hystrixDefaulFallback() {
//        ResponseEntity<String> entity = testRestTemplate.getForEntity("/self/timeout", String.class);
//        assertNotEquals(HttpStatus.OK, entity.getStatusCode());
//        assertEquals("my fallback", entity.getBody());
//    }

}
