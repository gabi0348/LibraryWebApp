package com.example.demo.repo;

import com.example.demo.model.Publishers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublishersRepository extends JpaRepository<Publishers, Integer> {
}
