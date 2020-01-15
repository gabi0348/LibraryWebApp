package com.example.demo.controller;

import com.example.demo.model.Books;
import com.example.demo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private BooksService service;

    @GetMapping("/home")
    public ModelAndView viewHomePage(@RequestParam(required = false) Map<String, String> allParams) {
        Iterable<Books> listBooks = null;
        if (allParams == null || allParams.isEmpty())
            listBooks = service.getAllBooks();
        else if (allParams.containsKey(SearchEnum.AUTHOR.name))
            listBooks = service.findBooksByAuthor(allParams.get(SearchEnum.AUTHOR.name));
        else if (allParams.containsKey(SearchEnum.PUBLISHER.name))
            listBooks = service.findBooksByPublisher(allParams.get(SearchEnum.PUBLISHER.name));
        else if (allParams.containsKey(SearchEnum.TITLE.name))
            listBooks = service.findBooksByTitle(allParams.get(SearchEnum.TITLE.name));
        else if (allParams.containsKey(SearchEnum.YEAR.name))
            listBooks = service.findBooksByYear(Integer.parseInt(allParams.get(SearchEnum.YEAR.name)));
        else if (allParams.containsKey(SearchEnum.ISBN.name))
            listBooks = service.findBooksByISBN(allParams.get(SearchEnum.ISBN.name));
        else if (allParams.containsKey(SearchEnum.GENRE.name))
            listBooks = service.findBooksByGenre(allParams.get(SearchEnum.GENRE.name));
        else if (allParams.containsKey(SearchEnum.SALES.name))
            listBooks = service.findSalesBooks();

        ModelAndView model = new ModelAndView("home/index");
        model.addObject("listBooks", listBooks);

        return model;
    }
}
