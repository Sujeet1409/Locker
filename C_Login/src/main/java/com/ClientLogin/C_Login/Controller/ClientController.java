package com.ClientLogin.C_Login.Controller;

import com.ClientLogin.C_Login.Service.ClientService;
import com.ClientLogin.C_Login.Service.DuplicateClientException;
import com.ClientLogin.C_Login.entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/client")

public class ClientController {
    @Autowired
    private ClientService authService;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> register(@RequestBody ClientEntity user) {
        Map<String, String> response = new HashMap<>();
        try {
            authService.register(user);
            response.put("message", "User registered successfully");
            return ResponseEntity.ok(response);
        } catch (DuplicateClientException e) {
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody ClientEntity user) {
        Map<String, String> response = new HashMap<>();
        ClientEntity loggedInUser = authService.login(user.getClientId(), user.getPassword());
        if (loggedInUser != null) {
            response.put("message", "Login successful");
            return ResponseEntity.ok(response);
        }
        response.put("error", "Invalid userId or password");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @PostMapping(value = "/logout", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> logout(@RequestParam String userId) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "User logged out successfully");
        return ResponseEntity.ok(response);
    }

}
