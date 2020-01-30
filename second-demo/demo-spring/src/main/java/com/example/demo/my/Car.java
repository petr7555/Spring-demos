package com.example.demo.my;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * @author Petr Janik 485122
 * @since 13/08/2019
 */
@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    @ManyToOne
//    @JsonIgnore // or use VO
    @JsonBackReference
    private Person ownedBy;

    public Car() {
    }

    public Car(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(Person ownedBy) {
        this.ownedBy = ownedBy;
    }
}
