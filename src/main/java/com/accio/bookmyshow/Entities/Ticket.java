package com.accio.bookmyshow.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ticket")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    private String seatNoBooked;

    private Integer totalAmountPaid;

    @JoinColumn
    @ManyToOne
    private Shows show;

}
