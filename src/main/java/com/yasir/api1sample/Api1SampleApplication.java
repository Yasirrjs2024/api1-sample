package com.yasir.api1sample;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@RestController
@CrossOrigin
public class Api1SampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(Api1SampleApplication.class, args);
    }
    @GetMapping("/")
    public String home() {
        return "API is running. Try /hello";
    }
    @GetMapping("/hello")
    public String hello() {
        var rnd = ThreadLocalRandom.current().nextInt(0, 1000);
        return "Hello from api1-sample! Random = " + rnd;
    }
}
