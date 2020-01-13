package com.example.demo.repo;

import com.example.demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Client, Integer> {
    public Optional<Client> findByUsername(String username);
}