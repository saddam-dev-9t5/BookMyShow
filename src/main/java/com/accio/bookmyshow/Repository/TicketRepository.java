package com.accio.bookmyshow.Repository;

import com.accio.bookmyshow.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
