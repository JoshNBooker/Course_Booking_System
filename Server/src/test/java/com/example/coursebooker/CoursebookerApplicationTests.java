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
}
