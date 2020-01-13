package com.example.demo.service;

import com.example.demo.model.Publishers;
import com.example.demo.repo.BooksRepository;
import com.example.demo.repo.PublishersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    @Autowired
    private BooksRepository booksRepo;

    @Autowired
    private PublishersRepository publRepo;

    public Iterable<Publishers> listAll(){
        return publRepo.findAll();
    }

    public void save(Publishers publisher){
        publRepo.save(publisher);
    }

    public Publishers get(int publisherID) {
        return publRepo.findById(publisherID).get();

    }

    public void delete(int publisherID) {
        publRepo.deleteById(publisherID);
    }

}
