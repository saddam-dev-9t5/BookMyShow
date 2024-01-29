package com.accio.bookmyshow.Services;

import com.accio.bookmyshow.Entities.Theater;
import com.accio.bookmyshow.Repository.TheaterRepository;
import com.accio.bookmyshow.Request.AddTheaterRequest;
import com.accio.bookmyshow.Transform.TheaterTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public String addTheater(AddTheaterRequest theaterRequest) {
        Theater theater = TheaterTransform.transformDtoToTheater(theaterRequest);
        theater = theaterRepository.save(theater);
        return "The Theater has been added with theaterId " + theater.getTheaterId();
    }
}
