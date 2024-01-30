package com.accio.bookmyshow.Services;

import com.accio.bookmyshow.Entities.Movie;
import com.accio.bookmyshow.Repository.MovieRepository;
import com.accio.bookmyshow.Request.AddMovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public String addMovie(AddMovieRequest movieRequest) {

        Movie movie = Movie.builder()
                .movieLanguage(movieRequest.getMovieLanguage())
                .movieName(movieRequest.getMovieName())
                .gener(movieRequest.getGener())
                .releaseDate(movieRequest.getReleaseDate())
                .duration(movieRequest.getDuration())
                .rating(movieRequest.getRating())
                .build();
        movie = movieRepository.save(movie);
        return "The movie has been saved with movieId " + movie.getMovieId();
    }
}
