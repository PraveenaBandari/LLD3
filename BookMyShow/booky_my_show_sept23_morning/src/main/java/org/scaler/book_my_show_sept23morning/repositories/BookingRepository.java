package org.scaler.book_my_show_sept23morning.repositories;

import org.scaler.book_my_show_sept23morning.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
