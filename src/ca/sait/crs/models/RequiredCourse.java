package ca.sait.crs.models;

import ca.sait.crs.contracts.Course;

/**
 * Represents a required (for credit) course.
 * @author Nick Hamnett <nick.hamnett@sait.ca>
 * @since June 1, 2023
 */
public final class RequiredCourse implements Course {
    private final String code;
    private final String name;
    private final int credits;

    public RequiredCourse(String code, String name, int credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", getName(), getCode());
    }
}
