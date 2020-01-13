package com.example.demo.service;

import com.example.demo.model.Authors;
import com.example.demo.repo.AuthorsRepository;
import com.example.demo.repo.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorsService {

    @Autowired
    private BooksRepository booksRepo;

    @Autowired
    private AuthorsRepository authRepo;

    public Iterable<Authors> listAll(){
        return authRepo.findAll();
    }

    public void save(Authors book) {
        authRepo.save(book);
    }

    public Authors get(int authorID){
        return authRepo.findById(authorID).get();
    }

    public void delete(int authorID) {
        authRepo.deleteById(authorID);
    }

}
