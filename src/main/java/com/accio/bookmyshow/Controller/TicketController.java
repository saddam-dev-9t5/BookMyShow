package com.accio.bookmyshow.Controller;

import com.accio.bookmyshow.Request.TicketBookingRequest;
import com.accio.bookmyshow.Services.TheaterService;
import com.accio.bookmyshow.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("booking")
    public ResponseEntity<String> ticketBooking(@RequestBody TicketBookingRequest ticketBookingRequest) throws Exception {
        try {
            String result = ticketService.ticketBooking(ticketBookingRequest);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
