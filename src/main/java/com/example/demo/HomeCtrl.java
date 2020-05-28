package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeCtrl {
    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("alldirectors", directorRepository.findAll());
        return "list";
    }

    @RequestMapping("/newdirector")
    public String newdirector(Model model){

        model.addAttribute("director", new Director());
        return "newdirector";
    }

    @PostMapping("/process")
    public String process(@ModelAttribute("director") Director director) {
        directorRepository.save(director);
        return "redirect:/list";
    }

    @RequestMapping("/newmovie")
    public String newmovie(Model model){
        model.addAttribute("movie", new Movie());
        model.addAttribute("alldirectors", directorRepository.findAll());
        return "newmovie";
    }

    @PostMapping("/processmovie")
    public String processmovie(@ModelAttribute("movie") Movie movie) {
        movieRepository.save(movie);
        return "redirect:/list";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model){
        model.addAttribute("director", directorRepository.findById(id).get());
        return "newdirector";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        Director director = directorRepository.findById(id).get();
        directorRepository.delete(director);
        return "redirect:/list";
    }

    @RequestMapping("/listmovies")
    public String listmovies(Model model){
        model.addAttribute("allmovies", movieRepository.findAll());
        return "listmovies";
    }

    @RequestMapping("/deletemovie/{id}")
    public String deletemovie(@PathVariable("id") long id) {
        movieRepository.deleteById(id);
        return "redirect:/listmovies";
    }
}
