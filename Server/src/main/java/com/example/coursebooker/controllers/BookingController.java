package com.example.coursebooker.controllers;

import com.example.coursebooker.models.Booking;
import com.example.coursebooker.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @GetMapping(value = "/bookings/{id}")
    public List<Booking> getBookingByDate(@PathVariable String date) {
        return bookingRepository.findByDate(date);
    }

    @PostMapping (value = "/bookings")
    public Booking createBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
        return booking;
    }

    @DeleteMapping(value = "/bookings/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingRepository.deleteById(id);
    }


}
