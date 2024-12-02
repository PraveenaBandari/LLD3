package org.scaler.book_my_show_sept23morning.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(value = EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
    private Date blockedAt;
}

// ShowSeat  show
// One showSeat object contains info about one show
// one show can be in multiple show Seat objects

// show1 Seat1 Booked
// show1 Seat2 Booked
// show1 Seat3 Available
// show2 Seat1 Booked
// show2 Seat2 Available
// show2 Seat3 Available

