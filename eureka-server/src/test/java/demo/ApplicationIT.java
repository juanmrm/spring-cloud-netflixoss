package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EurekaApplicationServer.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = {"classpath:application-integrationtest.properties"})
public class ApplicationIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

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