package com.util.financialbackend.controller;

import com.util.financialbackend.DTO.ClientRequestDTO;
import com.util.financialbackend.DTO.SpentRequestDTO;
import com.util.financialbackend.model.Client;
import com.util.financialbackend.model.Spent;
import com.util.financialbackend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/query")
    public ResponseEntity<List<Client>> getClients(){
        return ResponseEntity.ok(clientService.listActive());
    }

    @PostMapping("/save")
    public ResponseEntity<Client> saveClient(@RequestBody ClientRequestDTO c){
        return ResponseEntity
                .status(201)
                .body(clientService.save(new Client(null,
                        c.getName(),
                        c.getSalary(),
                        false,
                        null)));
    }
    @PutMapping("/add/spent")
    public ResponseEntity<Client> addSpentToClient(@Param("clientId") Long id ,@RequestBody SpentRequestDTO spent) throws Exception {
        return ResponseEntity.ok(clientService.addSpent(id,new Spent(
                null,
                spent.getPrice(),
                null,
                spent.getName())));
    }
}
