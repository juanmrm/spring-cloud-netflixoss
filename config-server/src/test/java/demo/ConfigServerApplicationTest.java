package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * This test will throw some exceptions trying to connect to Eureka Server if is not up (because it cannot register), but
 * test proceed ignoring this problems.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConfigServerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = {"classpath:application-integrationtest.properties"})
public class ConfigServerApplicationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Value("${management.context-path}")
    private String managementPath;

    @Test
    public void configurationAvailable() {
        @SuppressWarnings("rawtypes")
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/eureka/default", String.class); // Querying the Configuration -> /{application}/{profile}[/{label}] or /{application}-{profile}.yml
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    public void envPostAvailable() {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> entity = testRestTemplate.postForEntity(this.managementPath + "/env", form, Map.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

}