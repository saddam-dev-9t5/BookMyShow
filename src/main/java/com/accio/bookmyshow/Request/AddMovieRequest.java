package com.accio.bookmyshow.Request;

import com.accio.bookmyshow.Enums.Gener;
import com.accio.bookmyshow.Enums.Language;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
public class AddMovieRequest {
    private String movieName;
    private Gener gener;
    private Language movieLanguage;
    private LocalDate releaseDate;
    private LocalTime releaseTime;
}
