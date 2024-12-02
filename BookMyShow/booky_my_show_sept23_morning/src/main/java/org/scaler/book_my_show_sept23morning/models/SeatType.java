package org.scaler.book_my_show_sept23morning.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SeatType extends BaseModel{
    public String value;
}


// SeatType.GOLD