package com.accio.bookmyshow.Services;

import com.accio.bookmyshow.Entities.*;
import com.accio.bookmyshow.Enums.SeatType;
import com.accio.bookmyshow.Repository.MovieRepository;
import com.accio.bookmyshow.Repository.ShowRepository;
import com.accio.bookmyshow.Repository.TheaterRepository;
import com.accio.bookmyshow.Request.AddShowRequest;
import com.accio.bookmyshow.Request.AddShowSeatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    public String addShow(AddShowRequest showRequest) throws Exception {

        Movie movie = movieRepository.findByMovieName(showRequest.getMovieName());
        if(movie == null) {
            throw new Exception("Invalid movieName");
        }

        Optional<Theater> optionalTheater = theaterRepository.findById(showRequest.getTheaterId());
        if(optionalTheater.isEmpty()) {
            throw new Exception("Invalid theaterId");
        }
        Theater theater = optionalTheater.get();

        Show showEntity = new Show(showRequest.getShowDate(), showRequest.getShowTime());
        showEntity.setTheater(theater);
        showEntity.setMovie(movie);

        movie.getShowList().add(showEntity);
        theater.getShowList().add(showEntity);

        showEntity = showRepository.save(showEntity);

        return "Show has been created with showId " + showEntity.getShowId();
    }

    public String addShowSeat(AddShowSeatRequest showSeatRequest) throws Exception {
        Optional<Show> optionalShow = showRepository.findById(showSeatRequest.getShowId());
        if(optionalShow.isEmpty()) {
            throw new Exception("Invalid showId");
        }
        Show showEntity = optionalShow.get();

        Theater theater = showEntity.getTheater();
        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        List<ShowSeat> showSeatList = new ArrayList<>();
        for (TheaterSeat theaterSeat: theaterSeatList) {
            String seatNo = theaterSeat.getSeatNo();
            SeatType seatType = theaterSeat.getSeatType();

            ShowSeat showSeat = ShowSeat.builder()
                    .seatNo(seatNo)
                    .seatType(seatType)
                    .show(showEntity)
                    .isAvailable(Boolean.TRUE)
                    .foodAttached(Boolean.FALSE)
                    .build();

            if(seatType.equals(SeatType.CLASSIC)) {
                showSeat.setPrice(showSeatRequest.getPriceForClasicSeat());
            }else {
                showSeat.setPrice(showSeatRequest.getGetPriceForPremiumSeat());
            }

            showSeatList.add(showSeat);
            showEntity.setShowSeatList(showSeatList);
            showRepository.save(showEntity);
        }
        return "Show seat has been added to Show";
    }
}
