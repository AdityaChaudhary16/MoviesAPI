package dev.aditya.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    private Movie movie;
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

//    public Optional<Movie> singleMovie(ObjectId id) {
//        return movieRepository.findById(id);
//    }

    public Optional<Movie> movieByTitle(String title) {
        return movieRepository.findMovieByTitle(title);
    }

//    public Optional<List<Movie>> moviesByGenre(String genres) {
//        return movieRepository.findMovieByGenres(genres);
//    }

    public List<Movie> moviesByGenre(String genres) {
        List<Movie> movies =  new ArrayList<>();

        for(Movie mv : movieRepository.findAll()) {
            if(mv.getGenres().contains(genres)) {
                movies.add(mv);
            }
        }
        return movies;
    }

    public List<Movie> genreSize(Optional<Integer> size) {
        if(size.isEmpty()) {
            return movieRepository.findAll();
        }
        List<Movie> movies = new ArrayList<>();

        for(Movie mv : movieRepository.findAll()) {
            if(mv.getGenres().size() >= size.get()) {
                movies.add(mv);
            }
        }
        return movies;
    }
}
