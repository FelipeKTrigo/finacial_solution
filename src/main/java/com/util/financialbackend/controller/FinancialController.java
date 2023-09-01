package com.util.financialbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/finances")
public class FinancialController {
    @GetMapping("/customer/query")
    public ResponseEntity<String> getClient(){
        return ResponseEntity.ok("ok");
    }

}
