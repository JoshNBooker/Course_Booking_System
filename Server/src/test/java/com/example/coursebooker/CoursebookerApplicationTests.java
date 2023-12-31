package com.example.coursebooker;

import com.example.coursebooker.models.Booking;
import com.example.coursebooker.models.Course;
import com.example.coursebooker.models.Customer;
import com.example.coursebooker.repositories.BookingRepository;
import com.example.coursebooker.repositories.CourseRepository;
import com.example.coursebooker.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class CoursebookerApplicationTests {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	CourseRepository courseRepository;

	@Test
	public void contextLoads() {
	}
	@Test
	public void canGetCustomersByCourse() {
		assertEquals(2, customerRepository.findByBookingsCourseNameIgnoreCase("Python Intro").size());

	}

	@Test

	public void canFindCoursesByCustomer() {
		System.out.println(courseRepository.findByBookingsCustomerName("Geraldine"));
		assertNotNull(courseRepository.findByBookingsCustomerName("Geraldine"));
  }
  
  @Test
	public void canGetCourseByRating() {
		assertEquals(4, courseRepository.findCourseByStarRating(5).size());
  }

	@Test
	public void canGetBookingByDate() {
		assertEquals(1, bookingRepository.findBookingByDate("11/11/2023").size());

	}
	@Test
	public void canGetAllCustomersInAGivenTownForAGivenCourse(){
		assertEquals(1, customerRepository.findByTownAndBookingsCourseNameIgnoreCase("Edinburgh", "Polymorphism").size());
	}
	@Test
	public void canGetAllCustomersByTownAndCourse(){
		System.out.println(customerRepository.findByTownAndBookingsCourseNameIgnoreCase("Edinburgh", "polymorphism"));
		assertEquals(1, customerRepository.findByTownAndBookingsCourseNameIgnoreCase("Edinburgh", "polymorphism").size());
	}

}
