import ca.sait.crs.contracts.*;
import ca.sait.crs.exceptions.CannotCreateRegistrationException;
import java.util.ArrayList;

public final class ProxyRegistrationService implements RegistrationService {
    private final RealRegistrationService realRegistrationService;

    // Constructor initializes the realRegistrationService field
    public ProxyRegistrationService() {
        this.realRegistrationService = new RealRegistrationService();
    }


    @Override
    public Registration register(Student student, Course course) throws CannotCreateRegistrationException {
        // Check student eligibility before passing to RealRegistrationService
        if (!isStudentEligible(student)) {
            throw new CannotCreateRegistrationException("Student is not eligible for registration.");
        }
        // Pass to RealRegistrationService
        return realRegistrationService.register(student, course);
    }

    @Override
    public ArrayList<Registration> getRegistrations() {
        return realRegistrationService.getRegistrations();
    }

    // Additional methods

    /**
     * Check if the student is eligible for registration.
     * You can implement your eligibility criteria here.
     * For example, check if the student's GPA is above a certain threshold.
     * @param student Student to check
     * @return True if the student is eligible, false otherwise
     */
    private boolean isStudentEligible(Student student) {
        return student.getGpa() > 2.0;
    }
}
