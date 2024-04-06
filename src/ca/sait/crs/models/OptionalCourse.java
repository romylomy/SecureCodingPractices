package ca.sait.crs.models;

import ca.sait.crs.contracts.Course;

/**
 * Represents an optional (zero credit) course.
 * @author Nick Hamnett <nick.hamnett@sait.ca>
 * @since June 1, 2023
 */
public final class OptionalCourse implements Course {
    private final String code;
    private final String name;

    public OptionalCourse(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", getName(), getCode());
    }
}
