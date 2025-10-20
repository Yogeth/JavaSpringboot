package com.example.restservice;
 import org.springframework.web.bind.annotation.*;
@RestController
public class RequestParams{
 @GetMapping("/users")
/* String getparam(@RequestParam long id ){
  return "It is the id : "+ id;
 }*/
 
 String keys(
  @RequestParam("usr_a") String userName , 
 @RequestParam("pass_a") 
 int passWord){
  return "UserName = "+userName+"  "+"passWord = "+passWord;
 }
 
}

// in url localhost 8080/users ? usr_a&pass_a