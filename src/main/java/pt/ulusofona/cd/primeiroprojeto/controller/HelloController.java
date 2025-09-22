package pt.ulusofona.cd.primeiroprojeto.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {
    // Basic endpoint
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot with Java 23! 🚀";
    }

    @PostMapping("/echo")
    public String echo(@RequestBody Map<String, String> body) {
        return "You said: " + body.get("message");
    }

    /*
    @PutMapping("/update/{id}")
    public String update(@PathVariable int id) { ... }

    @DeleteMapping("/remove/{id}")
    public String remove(@PathVariable int id) { ... }
    */
}