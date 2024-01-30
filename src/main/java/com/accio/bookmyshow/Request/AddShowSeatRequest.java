package com.accio.bookmyshow.Request;

import lombok.Data;

@Data
public class AddShowSeatRequest {
    private int priceForClasicSeat;
    private int getPriceForPremiumSeat;
    private int showId;
}
