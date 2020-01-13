package com.example.demo.repo;

import com.example.demo.model.Clients;
import org.springframework.data.repository.CrudRepository;

public interface ClientsRepository extends CrudRepository<Clients, Integer> {
	
    public Clients findByEmail(String email);
    
}