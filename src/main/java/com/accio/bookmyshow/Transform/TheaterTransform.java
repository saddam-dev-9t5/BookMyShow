package com.accio.bookmyshow.Transform;

import com.accio.bookmyshow.Entities.Theater;
import com.accio.bookmyshow.Request.AddTheaterRequest;

public class TheaterTransform {
    public static Theater transformDtoToTheater(AddTheaterRequest theaterRequest) {
        Theater theater = Theater.builder()
                .name(theaterRequest.getName())
                .address(theaterRequest.getAddress())
                .noOfScreen(theaterRequest.getNoOfScreen())
                .build();
        return theater;
    }
}
