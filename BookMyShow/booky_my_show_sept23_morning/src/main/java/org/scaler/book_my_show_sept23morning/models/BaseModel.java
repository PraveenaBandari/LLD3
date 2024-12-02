package org.scaler.book_my_show_sept23morning.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date lastModifiedAt;
}

// corresponding tables will be created which will persist the data

// get the data from the client
// Do certain business logic : creating certain objects
// interact with db : mysql

// ORM : Object Relation Mapping
// Hibernate : Focus on the implementation of certain methods which internally uses SQL queries
// and get your work done

// Spring Data JPA


// PhonePe : YesBank
// SB : Hibernate


// PhonePe -> BankAPI <- YesBank
// SB -> Spring Data JPA <- Hibernate


// Map all the required classes to @Entity

// Homework :
// @OneToMany : new tables but we want references instead of new table
// explore how can we avoid this
