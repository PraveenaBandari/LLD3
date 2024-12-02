package org.scaler.book_my_show_sept23morning.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Region extends BaseModel {
    private String name;
//    private List<Theatre> theatreList ;
}
