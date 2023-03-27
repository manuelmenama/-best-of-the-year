package org.lessons.best_of_the_year.controller;

import org.lessons.best_of_the_year.Movie;
import org.lessons.best_of_the_year.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class BestOfTheYearController {
    @GetMapping
    public String home(Model model, @RequestParam(name = "mionome") String name) {
        model.addAttribute("name", name);
        return "home";
    }

    private List<Movie> getBestMovie() {
        List<Movie> bestMovies = new ArrayList<>();
        return bestMovies;
    }

    private List<Song> getBestSong() {
        List<Song> bestSongs = new ArrayList<>();
        return bestSongs;
    }
}
