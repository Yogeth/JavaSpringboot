 package com.example.demo;
 import org.springframework.web.bind.annotation.*;
 @RestController
 public class HelloWorldController{
   @GetMapping("/world")
   String sayHello(){
     return "Hello World hi everyone iam Yogeth Rajendran from TamilNadu iam studying AiMl in Mahendra Institute of Technology !";
   }
 }