package com.util.financialbackend.controller;

import com.util.financialbackend.DTO.SpentRequestDTO;
import com.util.financialbackend.model.Spent;
import com.util.financialbackend.service.SpentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/spent")
public class SpentController {
    @Autowired
    private SpentService service;

    @GetMapping("/list")
    public ResponseEntity<List<Spent>> getSpents() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/get")
    public ResponseEntity<Spent> getSpent(@Param("id") Long id) throws Exception {
        return ResponseEntity.ok(service.find(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Spent> saveSpent(@RequestBody SpentRequestDTO spent) {
        return ResponseEntity
                .status(201)
                .body(service.save(new Spent(
                        null,
                        spent.getPrice(),
                        null,
                        spent.getName())));
    }
}
