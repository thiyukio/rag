package com.inspira.rag.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  @GetMapping("/")
  public String home() {
    return "Hello, world!";
  }

  @GetMapping("/secured")
  public String secured() {
    return "Hello, secret world!";
  }
}
