package com.example.coursebooker.repositories;

import com.example.coursebooker.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Collection;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByBookingsCustomerName(String name);

    List<Course> findCourseByStarRating(int rating);


}
