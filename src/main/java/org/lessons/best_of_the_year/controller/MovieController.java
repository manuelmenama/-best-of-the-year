package org.lessons.best_of_the_year.controller;

import org.lessons.best_of_the_year.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @GetMapping
    public String movie(Model model) {

        List<Movie> movieList = getBestMovie();


        model.addAttribute("movieList", movieList);

        return "movie";
    }

    @GetMapping("/{id}")
    public String singleMovie(Model model, @PathVariable(value = "id", required = false) int id) {
        List<Movie> movies = getBestMovie();
        Optional<Movie> selectedMovie = movies.stream().filter(movie -> movie.getId() == id).findFirst();

        if (selectedMovie.isEmpty()) {
            return "redirect:/movies";
        } else {
            model.addAttribute("selectedMovie", selectedMovie.get());;
        }




        return "single_movie";
    }

    private List<Movie> getBestMovie() {
        List<Movie> bestMovies = new ArrayList<>();
        bestMovies.add(new Movie(2, "Baaria"));
        bestMovies.add(new Movie(3, "Pulp Fiction"));

        return bestMovies;
    }


}
