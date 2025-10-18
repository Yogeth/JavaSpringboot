 package com.example.demo;
 import org.springframework.web.bind.annotation.*;
 @RestController
 public class HelloWorldController{
   @GetMapping("/world")
   String sayHello(){
     return "Hello World hi everyone i love java !";
   }
 }