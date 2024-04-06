package ca.sait.crs.models;

/**
 * Represents a student.
 * @author Nick Hamnett <nick.hamnett@sait.ca>
 * @since June 1, 2023
 */
public final class Student implements ca.sait.crs.contracts.Student {
    private final String name;
    private final double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return getName();
    }
}
