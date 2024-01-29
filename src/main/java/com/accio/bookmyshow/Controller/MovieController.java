package com.accio.bookmyshow.Controller;

import com.accio.bookmyshow.Request.AddMovieRequest;
import com.accio.bookmyshow.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;


    @PostMapping("add")
    public ResponseEntity<String> addMovie(@RequestBody AddMovieRequest movieRequest) {
        String result = movieService.addMovie(movieRequest);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
