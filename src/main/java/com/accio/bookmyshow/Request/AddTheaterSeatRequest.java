package com.accio.bookmyshow.Request;

import lombok.Data;

@Data
public class AddTheaterSeatRequest {
    private int noOfClassicSeat;
    private int noPremiumSeat;
    private int theaterId;
}
