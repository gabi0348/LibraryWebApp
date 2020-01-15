package com.example.demo.service;


import com.example.demo.model.Authors;
import com.example.demo.model.Books;
import com.example.demo.model.Publishers;
import com.example.demo.repo.AuthorsRepository;
import com.example.demo.repo.BooksRepository;
import com.example.demo.repo.PublishersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepo;

    @Autowired
    private AuthorsRepository authRepo;

    @Autowired
    private PublishersRepository publRepo;

    public Iterable<Books> getAllBooks(){
        return booksRepo.findAll();
    }

    public Iterable<Authors> getAllAuthors(){
        return authRepo.findAll();
    }

    public Iterable<Publishers> getAllPublishers() {
        return publRepo.findAll();
    }

    public void save(Books book) {
        booksRepo.save(book);
    }

    public Books get(int book_id){
        return booksRepo.findById(book_id).get();
    }

    public void delete(int book_id) {
        booksRepo.deleteById(book_id);
    }

    public void save(Authors author) {
        authRepo.save(author);
    }

    public Iterable<Books> findBooksByAuthor(String name) {
        return booksRepo.getBooksByAuthorName(name);
    }

    public Iterable<Books> findBooksByPublisher(String publisher) {
        return booksRepo.getBooksByPublisher(publisher);
    }

    public Iterable<Books> findBooksByTitle(String title) {
        return booksRepo.findByTitle(title);
    }

    public Iterable<Books> findBooksByISBN(String isbn) {
        return booksRepo.findByIsbn(isbn);
    }

    public Iterable<Books> findBooksByGenre(String genre) {
        return booksRepo.findByGenre(genre);
    }

    public Iterable<Books> findBooksByYear(int parseInt) {
        return booksRepo.findByYear(parseInt);
    }
}
