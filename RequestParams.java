package com.example.restservice;
 import org.springframework.web.bind.annotation.*;
@RestController
class RequestParams{
 @GetMapping("/users")
 String getparam(@RequestParam long id ){
  return "It is the id : "+ id;
 }
}