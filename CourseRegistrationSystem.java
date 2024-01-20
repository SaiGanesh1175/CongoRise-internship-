package task5;

import java.util.Scanner;

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        CourseDatabase courseDB = new CourseDatabase();

        Course c1 = new Course("CS101", "Introduction to Programming", "Fundamentals of programming in Java", 50, "Mon/Wed 10:00 AM - 11:30 AM");
        Course c2 = new Course("MATH201", "Calculus I", "Introduction to differential and integral calculus", 40, "Tue/Thu 1:00 PM - 2:30 PM");

        courseDB.addCourse(c1);
        courseDB.addCourse(c2);

        Student s1 = new Student(1, "John Doe");
        Student s2 = new Student(2, "Jane Smith");

        StudentDatabase.addStudent(s1);
        StudentDatabase.addStudent(s2);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Display Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    courseDB.displayCourses();
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    int studentID = scanner.nextInt();
                    StudentDatabase.displayStudentCourses(studentID);

                    System.out.print("Enter Course Code to Register: ");
                    String registerCourseCode = scanner.next();
                    courseDB.getRegisteredStudents(registerCourseCode).size();
                    s1.registerCourse(registerCourseCode);
                    System.out.println("Registration Successful!");
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    int studentIDToDrop = scanner.nextInt();
                    StudentDatabase.displayStudentCourses(studentIDToDrop);

                    System.out.print("Enter Course Code to Drop: ");
                    String dropCourseCode = scanner.next();
                    s1.dropCourse(dropCourseCode);
                    System.out.println("Course Dropped Successfully!");
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}