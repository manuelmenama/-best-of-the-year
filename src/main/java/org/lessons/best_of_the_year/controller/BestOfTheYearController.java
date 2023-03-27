package org.lessons.best_of_the_year.controller;

import org.lessons.best_of_the_year.model.Movie;
import org.lessons.best_of_the_year.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/movie")
    public String movie(Model model) {
        
        List<Movie> movieList = getBestMovie();
        String movieTitle = "";

        for (Movie movie:
             movieList) {
            movieTitle += movie.getTitle() + "; ";
        }

        model.addAttribute("movieTitle", movieTitle);

        return "movie";
    }

    @GetMapping("/song")
    public String song(Model model) {

        List<Song> songsList = getBestSong();
        String songsTitle = "";

        for (Song song:
             songsList) {
            songsTitle += song.getTitle() + "; ";
        }

        model.addAttribute("songTitle", songsTitle);

        return "song";
    }

    private List<Movie> getBestMovie() {
        List<Movie> bestMovies = new ArrayList<>();
        bestMovies.add(new Movie(2, "Baaria"));
        bestMovies.add(new Movie(3, "Pulp Fiction"));

        return bestMovies;
    }

    private List<Song> getBestSong() {
        List<Song> bestSongs = new ArrayList<>();
        bestSongs.add(new Song(1, "Salirò"));
        bestSongs.add(new Song(4, "Il Gorilla"));
        return bestSongs;
    }

}
