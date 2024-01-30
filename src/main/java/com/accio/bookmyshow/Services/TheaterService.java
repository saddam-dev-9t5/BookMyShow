package com.accio.bookmyshow.Services;

import com.accio.bookmyshow.Entities.Theater;
import com.accio.bookmyshow.Entities.TheaterSeat;
import com.accio.bookmyshow.Enums.SeatType;
import com.accio.bookmyshow.Repository.TheaterRepository;
import com.accio.bookmyshow.Request.AddTheaterRequest;
import com.accio.bookmyshow.Request.AddTheaterSeatRequest;
import com.accio.bookmyshow.Request.TicketBookingRequest;
import com.accio.bookmyshow.Transform.TheaterTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public String addTheater(AddTheaterRequest theaterRequest) {
        Theater theater = TheaterTransform.transformDtoToTheater(theaterRequest);
        theater = theaterRepository.save(theater);
        return "The Theater has been added with theaterId " + theater.getTheaterId();
    }

    public String addTheaterSeat(AddTheaterSeatRequest theaterSeatRequest) {
        int noOfClassicSeat = theaterSeatRequest.getNoOfClassicSeat();
        int noOfPremiumSeat = theaterSeatRequest.getNoPremiumSeat();
        Theater theater = theaterRepository.findById(theaterSeatRequest.getTheaterId()).get();

        List<TheaterSeat> theaterSeatList = new ArrayList<>();

        int col = 5;
        // classic seat No
        int row = noOfClassicSeat/col;
        for(int i = 0; i <= row; i++) {
            for(int j = 0; j < col; j++) {
                if(i*col+(j+1) > noOfClassicSeat) break;
                char ch = (char)('A'+j);
                String seatNo = (i+1)+""+ch;
                TheaterSeat theaterSeat = TheaterSeat.builder()
                        .seatNo(seatNo)
                        .seatType(SeatType.CLASIC)
                        .theater(theater)
                        .build();
                theaterSeatList.add(theaterSeat);
            }
        }

        // premium seat No
        row = noOfPremiumSeat/col;
        for(int i = 0; i <= row; i++) {
            for(int j = 0; j < col; j++) {
                if(i*col+(j+1) > noOfPremiumSeat) break;
                char ch = (char)('A'+j);
                String seatNo = (i+1)+""+ch;
                TheaterSeat theaterSeat = TheaterSeat.builder()
                        .seatNo(seatNo)
                        .seatType(SeatType.PRIMIUM)
                        .theater(theater)
                        .build();
                theaterSeatList.add(theaterSeat);
            }
        }

        theater.setTheaterSeatList(theaterSeatList);
        theaterRepository.save(theater);

        return noOfClassicSeat+noOfPremiumSeat+" theater Seats has been created";
    }

}
