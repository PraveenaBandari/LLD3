package org.scaler.book_my_show_sept23morning.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel {
    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatType seatType;
    private int price;
}


// Show1 Gold 100
// Show1 Silver 50
// Show1 Bronze 25
// Show2 Gold 120
// Show2 Silver 50
// Show2 Bronze 25
