import demo.EurekaApplicationServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EurekaApplicationServer.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
    properties = { "management.security.enabled=false" }) // management.security.enabled -> Disable security
public class ApplicationTests {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void catalogLoads() {
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> entity = testRestTemplate.getForEntity("/eureka/apps", Map.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    public void adminLoads() {
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> entity = testRestTemplate.getForEntity("/env", Map.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

}