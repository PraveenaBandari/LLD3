package org.scaler.book_my_show_sept23morning.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
    private String name;
    private String address;
//    private List<Screen> screens;
    @ManyToOne
    private Region region;
}

// Region 1 : M Theatre : region_id in theatre table
// select * from theatre where regin_id = 5;
// findByRegion (Region )
// Based on the show , screen is automatically selected : Admin must have informed
