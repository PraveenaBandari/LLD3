package org.scaler.book_my_show_sept23morning.repositories;

import org.scaler.book_my_show_sept23morning.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {
    List<ShowSeat> findAllById(Iterable<Integer> showSeatIds);
}
