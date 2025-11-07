package com.example.client_service;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final List<Client> clients = new ArrayList<>();
    private long nextId = 4;

    public ClientController() {
        // Datos iniciales
        clients.add(new Client(1L, "Alice"));
        clients.add(new Client(2L, "Bob")); 
        clients.add(new Client(3L, "Robert"));
    }

    // CREATE
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        client.setId(nextId++);
        clients.add(client);
        return client;
    }

    // READ todos
    @GetMapping
    public List<Client> getAllClients() {
        return clients;
    }

    // READ por ID
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clients.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    // UPDATE
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        Client client = getClientById(id);
        client.setName(clientDetails.getName());
        return client;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clients.removeIf(client -> client.getId().equals(id));
    }
}