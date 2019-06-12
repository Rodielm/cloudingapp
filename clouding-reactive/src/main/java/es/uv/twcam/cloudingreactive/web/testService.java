package es.uv.twcam.cloudingreactive.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * testService
 */
@RestController
@RequestMapping("/api/reactive")
public class testService {

    @GetMapping
    public String testServiceString(@RequestParam String param) {
        return "This is app reactive with casssabdra";
    }

}