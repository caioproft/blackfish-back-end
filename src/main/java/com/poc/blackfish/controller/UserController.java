package com.poc.blackfish.controller;

import com.poc.blackfish.domain.dto.UserDTO;
import com.poc.blackfish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> userDTOList = service.findAll();
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserDTO userDTO){
        service.createUser(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
