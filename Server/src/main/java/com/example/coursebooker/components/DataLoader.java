package com.example.coursebooker.components;

import com.example.coursebooker.models.Booking;
import com.example.coursebooker.models.Course;
import com.example.coursebooker.models.Customer;
import com.example.coursebooker.repositories.BookingRepository;
import com.example.coursebooker.repositories.CourseRepository;
import com.example.coursebooker.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

@Profile("!test")
//@Component //comment out after first seed
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {}

    public void run(ApplicationArguments args) {

        Course course1 = new Course("Python Intro", "Edinburgh", 4);
        courseRepository.save(course1);

        Course course2 = new Course("JavaScript For Babies", "Perth", 3);
        courseRepository.save(course2);

        Course course3 = new Course("Jinja for Ninjas", "Plymouth", 5);
        courseRepository.save(course3);

        Course course4 = new Course("Dealing With People", "Glasgow", 4);
        courseRepository.save(course4);

        Course course5 = new Course("OOP (object oriented peanuts)", "Edinburgh", 5);
        courseRepository.save(course5);

        Course course6 = new Course("SQL for losers", "Edinburgh", 2);
        courseRepository.save(course6);

        Course course7 = new Course("React! to Json teaching", "Edinburgh", 5);
        courseRepository.save(course7);

        Course course8 = new Course("The Node Expressway, Keiths local commute", "Edinburgh", 5);
        courseRepository.save(course8);

        Course course9 = new Course("Polymorphism", "Edinburgh", 1);
        courseRepository.save(course9);


        Customer customer1 = new Customer("Gareth", "Plymouth", "1967-05-23");
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Kenny", "Glasgow", "1988-02-04");
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Geraldine", "Edinburgh", "2000-01-30");
        customerRepository.save(customer3);


        Booking booking1 = new Booking("23/10/2023", course1, customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("26/11/2023", course4, customer3);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("23/04/2024", course2, customer3);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("04/12/2024", course8, customer3);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("11/11/2023", course9, customer2);
        bookingRepository.save(booking5);

        Booking booking6 = new Booking("03/02/2022", course4, customer1);
        bookingRepository.save(booking6);

        Booking booking7 = new Booking("09/12/2022", course1, customer1);
        bookingRepository.save(booking7);

        Booking booking8 = new Booking("16/07/2023", course7, customer2);
        bookingRepository.save(booking8);

        Booking booking9 = new Booking("05/12/2023", course5, customer2);
        bookingRepository.save(booking9);

        Booking booking10 = new Booking("11/12/2023", course5, customer3);
        bookingRepository.save(booking10);

        Booking booking11 = new Booking("18/10/2023", course3, customer2);
        bookingRepository.save(booking11);

        Booking booking12 = new Booking("14/05/2023", course6, customer1);
        bookingRepository.save(booking12);

        Booking booking13 = new Booking("01/03/2023", course4, customer2);
        bookingRepository.save(booking13);

        Booking booking14 = new Booking("17/08/2023", course9, customer3);
        bookingRepository.save(booking14);

        Booking booking15 = new Booking("30/10/2023", course8, customer1);
        bookingRepository.save(booking15);
    }
}
