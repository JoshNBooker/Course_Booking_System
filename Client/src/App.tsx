import { useState, useEffect } from 'react'
import './App.css'

function App() {

  interface Course {
    id: number;
    name: string;
    town: string;
    starRating: number;
  }

  const [courses, setCourses] = useState<Course[]>()

  const BASE_URL: string = "http://localhost:8080/"

  const fetchCourses = () => {
    fetch(BASE_URL + "courses")
      .then((res) => res.json())
      .then((data) => setCourses(data))
  }

  useEffect(() => {
    fetchCourses()
  }, [])

  console.log(courses)
  
  return (
    <p>hello there</p>
  )
}

export default App
