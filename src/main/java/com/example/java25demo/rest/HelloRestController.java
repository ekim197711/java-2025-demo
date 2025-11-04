package com.example.java25demo.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloRestController {

    @GetMapping("/person/{name}")
    public String sayHello(@PathVariable String name,
                           @RequestParam(required = false) String celebrity) {
        return String.format("Hello World! %s you have dated this famous women %s", name, celebrity);
    }
}
