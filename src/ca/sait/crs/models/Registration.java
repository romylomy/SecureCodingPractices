package ca.sait.crs.models;

import ca.sait.crs.contracts.Course;
import ca.sait.crs.contracts.Student;

/**
 * Represents a registration.
 * @author Nick Hamnett <nick.hamnett@sait.ca>
 * @since June 1, 2023
 */
public final class Registration implements ca.sait.crs.contracts.Registration {
    private final Course course;
    private final Student student;

    public Registration(Course course, Student student) {
        this.course = course;
        this.student = student;
    }

    @Override
    public Course getCourse() {
        return course;
    }

    @Override
    public Student getStudent() {
        return student;
    }
}
