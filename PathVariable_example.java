package com.example.restservice;
 import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1")
public class PathVariable_example{
 @GetMapping("/{id}")
  String getById(@PathVariable long id){
   return "example for path variable :"+id;
  }
}