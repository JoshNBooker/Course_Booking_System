import { useState, useEffect } from 'react'
import './App.css'

function App() {

  interface Course {
    id: number;
    name: string;
    town: string;
    starRating: number;
  }
  interface Customer {
    id: number;
    name: string;
    town: string;
    dateOfBirth: string;
    bookings: Booking[]
  }
  interface Booking {
    id: number;
    date: string;
    course: Course;
  }

  const [courses, setCourses] = useState<Course[]>([])
  const [customers, setCustomers] = useState<Customer[]>([])

  const BASE_URL: string = "http://localhost:8080/"

  const fetchCourses = () => {
    fetch(BASE_URL + "courses")
      .then((res) => res.json())
      .then((data) => setCourses(data))
  }
  const fetchCustomers = () => {
    fetch(BASE_URL + "customers").then((res) => res.json()).then((data) => setCustomers(data))
  }

  useEffect(() => {
    fetchCourses();
    fetchCustomers();
  }, [])

  console.log(courses)
  console.log(customers)
  
  return (
      <div>
        <h1>Customers: </h1>
        {customers.map((customer) => (
          <ul key={customer.id}>
            <li>
              <b>{customer.name}</b>
            </li>
          </ul>
        ))}
      </div>
    );
}

export default App
