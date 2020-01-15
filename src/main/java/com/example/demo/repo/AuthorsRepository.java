package com.example.demo.repo;

import com.example.demo.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository<Authors,Integer> {

}
