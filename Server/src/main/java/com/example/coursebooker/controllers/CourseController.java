package com.example.coursebooker.controllers;

import com.example.coursebooker.models.Booking;
import com.example.coursebooker.models.Course;
import com.example.coursebooker.repositories.CourseRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity <List<Course>> getAllCourses(@RequestParam(name="customerName", required = false) String customerName) {
        if (customerName != null) {
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerName(customerName), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/courses/{id}")
    public Optional<Course> getCourseByID(@PathVariable Long id) {
        return courseRepository.findById(id);
    }

    @PostMapping(value = "/courses")
    public ResponseEntity createCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @DeleteMapping(value = "/courses/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }


}
