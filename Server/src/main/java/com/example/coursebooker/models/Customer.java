package com.example.coursebooker.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Column(name = "name")
    private String name;
    @Column(name = "town")
    private String town;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @OneToMany(mappedBy = "customers", fetch = FetchType.LAZY)
    private List<Booking> bookings;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Customer(String name, String town, String dateOfBirth) {
        this.name = name;
        this.town = town;
        this.dateOfBirth = dateOfBirth;
    }
    public Customer(){}

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
