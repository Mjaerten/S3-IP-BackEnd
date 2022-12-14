package dev.EpixInc.Epix.Controller;

import dev.EpixInc.Epix.Model.Genre;
import dev.EpixInc.Epix.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class GenreController {



    private GenreRepository genreRepository;

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }


    @GetMapping("/get/genres")
    List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }
}
