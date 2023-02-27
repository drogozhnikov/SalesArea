package com.sales.controller;

import com.sales.dto.AuthenticationRequestDTO;
import com.sales.entity.UserEntity;
import com.sales.repository.UserDao;
import com.sales.service.security.JwtTokenProvider;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/auth")
public class AuthenticationRestController {

    private final AuthenticationManager authenticationManager;
    private UserDao userDao;
    private JwtTokenProvider jwtTokenProvider;

    public AuthenticationRestController(AuthenticationManager authenticationManager, UserDao userDao, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userDao = userDao;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequestDTO request){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
            UserEntity user = userDao.findByUserName(request.getUserName()).orElseThrow(()-> new UsernameNotFoundException("User not found"));
            String token = jwtTokenProvider.createToken(request.getUserName(), user.getRole().name());
            Map<Object, Object> response = new HashMap<>();
            response.put("username", request.getUserName());
            response.put("token", token);
            return ResponseEntity.ok(response);
        }catch (AuthenticationException e){
            return new ResponseEntity<>("Invalid userName or password", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response){
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request,response,null);
    }


}
