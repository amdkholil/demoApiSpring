package com.domain.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * WelcomeController
 */
@RestController
@RequestMapping("/")
public class WelcomeController {
  @GetMapping(path = "/")
  String index(){
    return "";
  }
  @GetMapping(path = "/a")
  String welcome() {
    return "{status:1, data:3}";
  }

  @PostMapping(path="/a")
  String welcomePost() {
    return "ini post";
  }

}