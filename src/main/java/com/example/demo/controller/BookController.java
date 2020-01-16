package com.example.demo.controller;

import com.example.demo.model.Authors;
import com.example.demo.model.Books;
import com.example.demo.model.Publishers;
import com.example.demo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BookController {

    @Autowired
    private BooksService service;

    @GetMapping("/book")
    public ModelAndView viewHomePage() {

        Iterable<Books> listBooks = service.getAllBooks();
        ModelAndView model = new ModelAndView("book/book");
        model.addObject("listBooks", listBooks);

        return model;
    }

    @GetMapping("/book/new")
    public ModelAndView showNewBookForm() {
        Books newBook = new Books();
        ModelAndView model = new ModelAndView("book/new_book");
        model.addObject("newBook", newBook);

        Iterable<Publishers> allPublishers = service.getAllPublishers();
        model.addObject("allPublishers", allPublishers);

        Iterable<Authors> allAuthors = service.getAllAuthors();
        model.addObject("allAuthors", allAuthors);

        return model;
    }

    @PostMapping(value = "/book/save")
    public ModelAndView saveBook(@ModelAttribute("newBook") Books book) {
        service.save(book);
        return new ModelAndView("redirect:/book");
    }

    @GetMapping("/book/edit/{id}")
    public ModelAndView showEditBooksForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("book/edit_book");
        Books book = service.get(id);
        mav.addObject("book", book);

        Iterable<Authors> allAuthors = service.getAllAuthors();
        mav.addObject("allAuthors", allAuthors);

        Iterable<Publishers> allPublishers = service.getAllPublishers();
        mav.addObject("allPublishers", allPublishers);

        return mav;
    }

    @GetMapping("/book/delete/{id}")
    public ModelAndView deleteBook(@PathVariable(name = "id") int id) {
        service.delete(id);
        return new ModelAndView("redirect:/book");
    }
}
