import ca.sait.crs.contracts.*;
import ca.sait.crs.exceptions.CannotCreateRegistrationException;
import ca.sait.crs.contracts.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Registers student with course.
 * @author Nick Hamnett <nick.hamnett@sait.ca>
 * @since June 1, 2023
 */
public class RealRegistrationService implements RegistrationService {
    private final List<Registration> registrations;

    public RealRegistrationService() {
        this.registrations = new ArrayList<>();
    }

    /**
     * Registers student with course
     * @param student Student Student instance
     * @param course Course Course instance
     * @return Registration instance.
     */
    @Override
    public Registration register(Student student, Course course) throws CannotCreateRegistrationException {
        Registration registration = new ca.sait.crs.models.Registration(course, student);
        List<Registration> updatedRegistrations = new ArrayList<>(this.registrations);
        updatedRegistrations.add(registration);
        return registration;
    }

    /**
     * Gets registrations.
     * @return All registrations
     */
    @Override
    public List<Registration> getRegistrations() {
        return Collections.unmodifiableList(this.registrations);
    }
}
