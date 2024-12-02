package org.scaler.book_my_show_sept23morning.controllers;

import org.scaler.book_my_show_sept23morning.dtos.BookTicketRequestDTO;
import org.scaler.book_my_show_sept23morning.dtos.BookTicketResponseDTO;
import org.scaler.book_my_show_sept23morning.dtos.ResponseStatus;
import org.scaler.book_my_show_sept23morning.models.Booking;
import org.scaler.book_my_show_sept23morning.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    @Autowired
    BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    BookTicketResponseDTO bookTicket(BookTicketRequestDTO request){
        BookTicketResponseDTO response = new BookTicketResponseDTO();
        try{
            Booking booking = bookingService.bookTicket(
                    request.getShowSeatIds(),
                    request.getShowId(),
                    request.getUserId()
            );
            response.setBookingId(booking.getId());
            response.setAmount(booking.getAmount());
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}

// @Component