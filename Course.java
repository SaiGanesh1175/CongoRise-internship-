package task5;

import java.util.ArrayList;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }
}

class Student {
    private int studentID;
    private String name;
    private ArrayList<String> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(String courseCode) {
        registeredCourses.add(courseCode);
    }

    public void dropCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }
}

class CourseDatabase {
    private ArrayList<Course> courses;

    public CourseDatabase() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            int availableSlots = course.getCapacity() - getRegisteredStudents(course.getCourseCode()).size();
            System.out.println("Course Code: " + course.getCourseCode() +
                    ", Title: " + course.getTitle() +
                    ", Description: " + course.getDescription() +
                    ", Capacity: " + course.getCapacity() +
                    ", Available Slots: " + availableSlots +
                    ", Schedule: " + course.getSchedule());
        }
    }

    public ArrayList<Student> getRegisteredStudents(String courseCode) {
        ArrayList<Student> registeredStudents = new ArrayList<>();
        for (Student student : StudentDatabase.students) {
            if (student.getRegisteredCourses().contains(courseCode)) {
                registeredStudents.add(student);
            }
        }
        return registeredStudents;
    }
}

class StudentDatabase {
    static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void displayStudentCourses(int studentID) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                System.out.println("Registered Courses for " + student.getName() + ": " + student.getRegisteredCourses());
                return;
            }
        }
        System.out.println("Student with ID " + studentID + " not found.");
    }
}

