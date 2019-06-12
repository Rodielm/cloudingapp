package es.uv.twcam.cloudingapi.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * RestTest
 */

@RestController()
@RequestMapping("/api/test")
public class RestTest {



    @GetMapping
    public String getTest() {
        return "Hello, This is app with mysql";
    }
    
    
}