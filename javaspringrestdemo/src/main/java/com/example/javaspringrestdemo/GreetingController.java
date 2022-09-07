package com.example.javaspringrestdemo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Marks class as controller where every method returns a domain object instead of a view
@RestController
public class GreetingController {
  private static final String template = "Hello, %s!";

  private final AtomicLong counter = new AtomicLong();

  // HTTP GET requests to /greeting mapped to greeting() method
  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    // Automatically converted to JSON with Jackson2
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }
}
