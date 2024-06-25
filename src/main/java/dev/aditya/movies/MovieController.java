package dev.aditya.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    private ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    private ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id) {
//        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id), HttpStatus.OK);
//    }

//    @GetMapping("/{title}")
//    private ResponseEntity<Optional<Movie>> getMovieByTitle(@PathVariable String title) {
//        return new ResponseEntity<>(movieService.movieByTitle(title), HttpStatus.OK);
//    }

    @GetMapping("/{genres}")
    private ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genres) {
        return new ResponseEntity<List<Movie>>(movieService.moviesByGenre(genres), HttpStatus.OK);
    }
}
