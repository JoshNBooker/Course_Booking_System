package com.example.coursebooker.repositories;

import com.example.coursebooker.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseNameIgnoreCase(String name);
    List<Customer> findByTownAndBookingsCourseNameIgnoreCase(String town, String courseName);
    List<Customer> findByNameIgnoreCase(String name);
    List<Customer> findByTownIgnoreCase(String town);

}
