package com.example.client_service;

public class Client {
    private Long id;
    private String name;

    public Client(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Solo getters
    public Long getId() { return id; }
    public String getName() { return name; }
}