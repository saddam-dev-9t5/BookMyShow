package com.accio.bookmyshow.Entities;

import com.accio.bookmyshow.Enums.Gener;
import com.accio.bookmyshow.Enums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column(unique = true, nullable = false)
    private String movieName;

    private Gener gener;

    private Language movieLanguage;

    private LocalDate releaseDate;

    private LocalTime releaseTime;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Shows> showList = new ArrayList<>();
}
