
package com.course.main;

import com.course.model.*;
import com.course.service.CourseService;
import com.course.exception.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CourseService service = new CourseService();

        service.addCourse(new Course(1, "Java Programming", 2));
        service.addCourse(new Course(2, "React Development", 2));

        int choice;

        do {
            System.out.println("\n1 Enroll Student");
            System.out.println("2 View Courses");
            System.out.println("3 View File Records");
            System.out.println("4 Exit");

            choice = sc.nextInt();

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Enter Course ID: ");
                        int cid = sc.nextInt();

                        System.out.print("Enter Student ID: ");
                        int sid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Student Name: ");
                        String name = sc.nextLine();

                        Student s = new Student(sid, name);

                        service.enrollStudent(cid, s);
                        System.out.println("Student Enrolled Successfully");
                        break;

                    case 2:
                        service.viewCourses();
                        break;

                    case 3:
                        service.readFile();
                        break;
                }

            } catch (CourseNotFoundException | CourseFullException | DuplicateEnrollmentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            }

        } while (choice != 4);

        sc.close();
    }
}
