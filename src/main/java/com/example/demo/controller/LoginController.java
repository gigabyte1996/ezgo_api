//package com.example.demo.controller;
//
//
//import com.example.demo.model.User;
//import com.example.demo.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@SuppressWarnings("all")
//@RestController()
//public class LoginController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody User user){
//        return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
//    }
//}
