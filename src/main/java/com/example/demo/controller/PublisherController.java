package com.example.demo.controller;

import com.example.demo.model.Publishers;
import com.example.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PublisherController {

    @Autowired
    private PublisherService service;

    @GetMapping("/publisher")
    public ModelAndView viewHomePae() {

        Iterable<Publishers> listPublishers = service.listAll();
        ModelAndView model = new ModelAndView("publisher/publisher");
        model.addObject("listPublishers", listPublishers);

        return model;
    }

    @GetMapping("/publisher/new")
    public ModelAndView showNewPublisherForm() {
        Publishers newPublisher = new Publishers();
        ModelAndView model = new ModelAndView("publisher/new_publisher");
        model.addObject("newPublisher", newPublisher);

        return model;
    }

    @PostMapping(value = "/publisher/save")
    public ModelAndView savePublisher(@ModelAttribute("newPublisher") Publishers publisher) {
        service.save(publisher);

        return new ModelAndView("redirect:/publisher");
    }

    @GetMapping("/publisher/edit/{id}")
    public ModelAndView showEditPublisherForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("publisher/edit_publisher");
        Publishers publisher = service.get(id);
        mav.addObject("publisher", publisher);

        return mav;
    }

    @GetMapping("/publisher/delete/{id}")
    public ModelAndView deletePublisher(@PathVariable(name = "id") int id) {
        service.delete(id);
        return new ModelAndView("redirect:/publisher");
    }


}
