package com.user.registration.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user.registration.system.dtos.UserDTO;
import com.user.registration.system.exceptions.RegistrationException;
import com.user.registration.system.services.UserRegistrationService;

import jakarta.validation.Valid;


@RequestMapping("/registrations")
@CrossOrigin("http://localhost:4200")
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userDTO){
        this.userRegistrationService.createUser(userDTO);
        return new ResponseEntity<String>("User registered successfully.", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@Valid @RequestBody UserDTO userDTO){
        this.userRegistrationService.updateUser(userDTO);
        return new ResponseEntity<String>("User updated successfully.", HttpStatus.OK);
    }

    @GetMapping("/{user_id}")
    public UserDTO getUserById(@PathVariable Integer user_id) throws RegistrationException {
        return this.userRegistrationService.getUserByID(user_id);
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Integer user_id){
        this.userRegistrationService.deleteUserByID(user_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
