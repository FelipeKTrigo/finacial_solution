package com.util.financialbackend.controller;

import com.util.financialbackend.DTO.ClientRequestDTO;
import com.util.financialbackend.DTO.ClientResponseDTO;
import com.util.financialbackend.DTO.SpentRequestDTO;
import com.util.financialbackend.model.Client;
import com.util.financialbackend.model.Spent;
import com.util.financialbackend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/list")
    public ResponseEntity<List<ClientResponseDTO>> getClients() {
        List<Client> list = clientService.listActive();
        return ResponseEntity.ok(list
                .stream()
                .map(it -> new ClientResponseDTO(it.getId(), it.getName(), it.getSalary(),it.getPhoneNumber(), it.getEmail()))
                .collect(Collectors.toList()));
    }
    @GetMapping("/get")
    public ResponseEntity<ClientResponseDTO> getClient() throws Exception {
        var original = clientService.find(1L);
        return ResponseEntity.ok(new ClientResponseDTO(original.getId(), original.getName(), original.getSalary(),original.getPhoneNumber(),original.getEmail()));
    }

    @PostMapping("/save")
    public ResponseEntity<ClientResponseDTO> saveClient(@RequestBody ClientRequestDTO c) {
        Client original = clientService.save(new Client(null,
                c.getName(),
                c.getSalary(),
                c.getPhoneNumber(),
                c.getEmail(),
                c.getPassword(),
                false,
                null));
        return ResponseEntity
                .status(201)
                .body(new ClientResponseDTO(original.getId(), original.getName(), original.getSalary(),original.getPhoneNumber(),original.getEmail()));
    }

    @PutMapping("/add/spent")
    public ResponseEntity<ClientResponseDTO> addSpentToClient(@Param("clientId") Long id, @RequestBody SpentRequestDTO spent) throws Exception {
        Client original = clientService.addSpent(id, new Spent(
                null,
                spent.getPrice(),
                null,
                spent.getName()));
        return ResponseEntity.ok(new ClientResponseDTO(original.getId(), original.getName(), original.getSalary(),original.getPhoneNumber(),original.getEmail()));
    }
}
