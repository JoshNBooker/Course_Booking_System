package com.example.coursebooker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="bookings")
public class Booking {

    @Column(name = "date")
    private String date;
    @ManyToOne
    @JsonIgnoreProperties({"booking"})
    @JoinColumn(name = "course_id", nullable = false)
    private Long course_id;
    @ManyToOne
    @JsonIgnoreProperties({"booking"})
    @JoinColumn(name = "customer_id", nullable = false)
    private Long customer_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Booking(String date, Long course_id, Long customer_id) {
        this.date = date;
        this.course_id = course_id;
        this.customer_id = customer_id;
    }

    public Booking(){}

    public String getDate() {
        return date;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public Long getId() {
        return id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
