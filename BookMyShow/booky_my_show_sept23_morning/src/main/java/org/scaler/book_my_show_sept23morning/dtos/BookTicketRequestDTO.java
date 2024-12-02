package org.scaler.book_my_show_sept23morning.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDTO {
    private List<Integer> showSeatIds;
    private int showId;
    private int userId;
}
