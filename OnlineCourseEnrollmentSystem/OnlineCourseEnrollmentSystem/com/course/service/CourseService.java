
package com.course.service;

import com.course.model.Course;
import com.course.model.Student;
import com.course.exception.*;

import java.io.*;
import java.util.*;

public class CourseService {

    private List<Course> courses = new ArrayList<>();
    private final String FILE_NAME = "courses.txt";

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void enrollStudent(int courseId, Student s) throws CourseNotFoundException, CourseFullException, DuplicateEnrollmentException, IOException {

        Course course = null;

        for (Course c : courses) {
            if (c.getCourseId() == courseId) {
                course = c;
                break;
            }
        }

        if (course == null) {
            throw new CourseNotFoundException("Course not found");
        }

        for (Student st : course.getEnrolledStudents()) {
            if (st.getStudentId() == s.getStudentId()) {
                throw new DuplicateEnrollmentException("Student already enrolled");
            }
        }

        if (course.getEnrolledStudents().size() >= course.getMaxSeats()) {
            throw new CourseFullException("Course is full");
        }

        course.addStudent(s);
        saveToFile(course, s);
    }

    private void saveToFile(Course c, Student s) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true));
        bw.write(c.getCourseId() + "," + c.getCourseName() + "," + s.getStudentId() + "," + s.getStudentName());
        bw.newLine();
        bw.close();
    }

    public void viewCourses() {
        for (Course c : courses) {
            c.displayCourse();
            System.out.println("------------------");
        }
    }

    public void readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String line;

        System.out.println("Saved Enrollment Records:");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}
