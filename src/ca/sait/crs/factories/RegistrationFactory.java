package ca.sait.crs.factories;

import ca.sait.crs.contracts.Course;
import ca.sait.crs.contracts.Student;
import ca.sait.crs.exceptions.CannotCreateCourseException;
import ca.sait.crs.exceptions.CannotCreateRegistrationException;
import ca.sait.crs.models.OptionalCourse;
import ca.sait.crs.models.Registration;
import ca.sait.crs.models.RequiredCourse;

/**
 * Creates Registration instances.
 * @author Nick Hamnett <nick.hamnett@sait.ca>
 * @since June 1, 2023
 */
public class RegistrationFactory {

    public RegistrationFactory() {
    }

    /**
     * Builds a Registration instance.
     * @param course Course
     * @param student Student
     * @return Registration instance
     * @throws CannotCreateRegistrationException Thrown if parameters are invalid.
     */
    public Registration build(Course course, Student student) throws CannotCreateRegistrationException {
        // Do not check if students is eligible for registration here.

        if (!this.validateCourse(course)) {
            throw new CannotCreateRegistrationException("Course is invalid.");
        }

        if (!this.validateStudent(student)) {
            throw new CannotCreateRegistrationException("Student is invalid.");
        }

        return null;
    }

    /**
     * Validates a course.
     * @param course Course
     * @return True if course is valid.
     */
    private boolean validateCourse(Course course) {
        
        ArrayList<Registration> allRegistrations = getRegistrations();

        for (Registration reg : allRegistrations) {
=            Course regcourse = reg.getCourse();

=            if (regcourse.getName().equals(course.name) && regcourse.getCode().equals(course.code) ) {
                return true;
            }
        }
        
        return false; 
    }

    /**
     * Validates a student.
     * @param student Student
     * @return True if student is valid.
     */
    private boolean validateStudent(Student student) {
         // Get all registrations
        ArrayList<Registration> allRegistrations = getRegistrations();

        // Iterate over each registration
        for (Registration reg : allRegistrations) {
            // Get the student associated with the current registration
            Student regStudent = reg.getStudent();

            // Check if the current registration's student matches the input student
            if (regStudent.getName().equals(student.getName()) && regStudent.getGpa() == student.getGpa()) {
                return true; // Student found in registration list
            }
        }
        
        return false; // Student not found in any registration
    }
}
