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

  const courseNodes = courses?.map((course, index) => {
    let rating: string = ""
    for (let i = 0; i < course.starRating; i++) {
      rating += "⭐"
    }
    return (
      <div key={index}>
        <h2>{course.name}</h2>
        <h3>{course.town}</h3>
        <div>{rating}</div>
      </div>
    )
  })
  
  return (
    <>
    <p>hello there</p>
    {courseNodes}
    </>
  )
}

export default App
