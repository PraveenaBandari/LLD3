package org.scaler.book_my_show_sept23morning.services;

import org.scaler.book_my_show_sept23morning.models.*;
import org.scaler.book_my_show_sept23morning.repositories.BookingRepository;
import org.scaler.book_my_show_sept23morning.repositories.ShowRepository;
import org.scaler.book_my_show_sept23morning.repositories.ShowSeatRepository;
import org.scaler.book_my_show_sept23morning.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingRepository bookingRepository;

    @Autowired
    BookingService(
            UserRepository userRepository,
            ShowRepository showRepository,
            ShowSeatRepository showSeatRepository,
            BookingRepository bookingRepository
    ){
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(
         List<Integer> showSeatIds,
         int showId,
         int userId
    ){
        // 1. Get User using the userId
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new RuntimeException("User not found");
        }
        User user = userOptional.get();
        // 2. Get Show using the showID
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()){
            throw new RuntimeException("Show not found");
        }
        Show show = showOptional.get();
        // -------- START TRANSACTION ---------
        // 3. Get ShowSeats via showSeatIds
        List<ShowSeat> showSeats =  showSeatRepository.findAllById(showSeatIds);
        // 4. check if all the seats are available
        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                //      6. if no, return with an error message
                throw new RuntimeException("Selected Show seats not available");
            }
        }
        //      5. if yes , mark all the seats as "BLOCKED"
        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeat.setBlockedAt(new Date());
            // 5.1 save the seats in the db
//            showSeatRepository.save(showSeat);
        }
        showSeatRepository.saveAll(showSeats);
        // ------- STOP TRANSACTION ------


        // 5.2 calculate the price
            // PriceCalculatorService
            // using Show, get all showSeatTypes : findAllByShow
            // Traverse the list of selected seats and add the price according to it's type


        // 7. Properly create the Booking object, save and return it
        Booking booking = new Booking();
        booking.setBookedBy(user);
        booking.setBookingDate(new Date());
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setAmount(100);
//        booking.setPayments(new ArrayList<>());
        booking.setShowSeats(showSeats);

        return bookingRepository.save(booking);
    }
}

// BREAK : 8 : 20
// You need to inject the data and get it working

// You should be converting it into a REST API
// Run on a specific port
// try to hit multiple booking request to check for the locking situation

