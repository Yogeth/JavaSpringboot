 package com.example.demo;
 import org.springframework.web.bind.annotation.*;
 @RestController
 @RequestMapping("/hello")
 public class HelloWorldController{
   @GetMapping("/world")
   String sayHello(){
     return "Hello World i love java !";
   }
   @GetMapping("/everyone")
   String sayHello(){
     return "Hello everyOne iam yoge";
   }
 }