package com.accio.bookmyshow.Request;

import com.accio.bookmyshow.Enums.SeatType;
import lombok.Data;

@Data
public class TicketBookingRequest {

    private String seatNo;
    private int showId;
    private SeatType seatType;
}
