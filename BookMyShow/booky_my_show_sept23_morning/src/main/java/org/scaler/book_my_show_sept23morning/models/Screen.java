package org.scaler.book_my_show_sept23morning.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel {
    private String name;
    @OneToMany
    private List<Seat> seats;
    @ManyToOne
    private Theatre theatre;
    @Enumerated(value = EnumType.STRING)
    @ElementCollection
    private List<Feature> features;
}

// we create separate tables for enum
// id , value
// TWO_D

// screen_id ,feature_id
// 1 , 0
// 1 , 1
// 1, 2