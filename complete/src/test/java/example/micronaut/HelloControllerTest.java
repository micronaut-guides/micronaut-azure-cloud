package example.micronaut;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
public class HelloControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    public void testHello() throws Exception {
        String body = client.toBlocking().retrieve("/");
        assertNotNull(body);
        assertEquals(
                "Micronaut on Azure",
                body
        );
    }
}