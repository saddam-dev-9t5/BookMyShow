package com.accio.bookmyshow.Services;

import com.accio.bookmyshow.Entities.Show;
import com.accio.bookmyshow.Entities.ShowSeat;
import com.accio.bookmyshow.Entities.Ticket;
import com.accio.bookmyshow.Repository.ShowRepository;
import com.accio.bookmyshow.Repository.TicketRepository;
import com.accio.bookmyshow.Request.TicketBookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TicketRepository ticketRepository;
    public String ticketBooking(TicketBookingRequest ticketBookingRequest) throws Exception {
        Optional<Show> optionalShow = showRepository.findById(ticketBookingRequest.getShowId());
        if(optionalShow.isEmpty()) {
            throw new Exception("Invalid showId");
        }

        Show show = optionalShow.get();
        String seatNo = ticketBookingRequest.getSeatNo();
        List<ShowSeat> showSeatList = show.getShowSeatList();
        int price = 0;
        for (ShowSeat showSeat: showSeatList) {
            if(seatNo.equals(showSeat.getSeatNo()) && showSeat.getSeatType() == ticketBookingRequest.getSeatType()) {
                if(showSeat.isAvailable()) {
                    showSeat.setAvailable(Boolean.TRUE);
                    price = showSeat.getPrice();
                    break;
                }else {
                    throw new Exception("Seat not available");
                }
            }
        }

        if(price == 0) {
            throw new Exception("Invalid seatNo");
        }


        Ticket ticket = Ticket.builder()
                .seatNoBooked(seatNo)
                .totalAmountPaid(price)
                .show(show)
                .build();

        ticket = ticketRepository.save(ticket);
        return "A new ticket has been created with ticketId " + ticket.getTicketId();
    }
}
