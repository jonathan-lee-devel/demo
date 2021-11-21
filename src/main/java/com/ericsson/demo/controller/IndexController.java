package com.ericsson.demo.controller;

import java.time.ZonedDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

  @GetMapping
  public ResponseEntity<String> getIndex() {
    return ResponseEntity.ok(ZonedDateTime.now().toString());
  }

}
