package com.example.demo.controller;

import com.example.demo.model.Authors;
import com.example.demo.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AuthorController {

    @Autowired
    private AuthorsService service;

    @GetMapping("/author")
    public ModelAndView viewHomePage() {

        Iterable<Authors> listAuthors = service.listAll();
        ModelAndView model = new ModelAndView("author/author");
        model.addObject("listAuthors", listAuthors);

        return model;
    }

    @GetMapping("/author/new")
    public ModelAndView showNewAuthorForm() {
        Authors newAuthor = new Authors();
        ModelAndView model = new ModelAndView("author/new_author");
        model.addObject("newAuthor", newAuthor);

        return model;
    }

    @PostMapping(value = "/author/save")
    public ModelAndView saveAuthor(@ModelAttribute("newAuthor") Authors author) {
        service.save(author);

        return new ModelAndView("redirect:/author");
    }

    @GetMapping("/author/edit/{id}")
    public ModelAndView showEditAuthorsForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("author/edit_author");
        Authors author = service.get(id);
        mav.addObject("author", author);

        return mav;
    }

    @GetMapping("/author/delete/{id}")
    public ModelAndView deleteAutho(@PathVariable(name = "id") int id) {
        service.delete(id);
        return new ModelAndView("redirect:/author");
    }
}
