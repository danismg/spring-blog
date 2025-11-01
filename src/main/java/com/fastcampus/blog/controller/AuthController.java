package com.fastcampus.blog.controller;

import com.fastcampus.blog.entity.UserInfo;
import com.fastcampus.blog.request.auth.AuthRequest;
import com.fastcampus.blog.service.JwtService;
import com.fastcampus.blog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String adduser(@RequestBody UserInfo userInfo) {
        userInfoService.addUser(userInfo);
        return "User added successfully";
    }

    @PostMapping("/login")
    public String generateToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authentication.getName());
        } else {
            throw new RuntimeException("Invalid Username and Password");
        }
    }
}
