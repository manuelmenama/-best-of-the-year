package org.lessons.best_of_the_year.controller;

import org.lessons.best_of_the_year.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/songs")
public class SongController {
    @GetMapping
    public String song(Model model) {

        List<Song> songsList = getBestSong();


        model.addAttribute("songList", songsList);

        return "song";
    }



    @GetMapping("/{id}")
    public String singleSong(Model model, @PathVariable(value = "id", required = false) int id) {
        List<Song> songs = getBestSong();

        Optional<Song> selectedSong= songs.stream().filter(song -> song.getId() == id).findFirst();

        if (selectedSong.isEmpty()) {
            return "redirect:/songs";
        } else {
            model.addAttribute("selectedSong",selectedSong.get());
        }

        return "single_song";
    }



    private List<Song> getBestSong() {
        List<Song> bestSongs = new ArrayList<>();
        bestSongs.add(new Song(1, "Salirò"));
        bestSongs.add(new Song(4, "Il Gorilla"));
        return bestSongs;
    }
}
