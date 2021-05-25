package model;

import java.time.LocalDate;

public class Resident extends Stuff{
    private LocalDate expectedGraduation;

    public Resident() {
        super();
    }
    public Resident(int id, String firstName, String lastName, int age, String email, String phone, String sex, int salary, int experience, LocalDate expectedGraduation) {
        super(id, firstName, lastName, age, email, phone, sex, salary, experience);
        this.expectedGraduation = expectedGraduation;
    }

    public LocalDate getExpectedGraduation() {
        return expectedGraduation;
    }

    public void setExpectedGraduation(LocalDate expectedGraduation) {
        this.expectedGraduation = expectedGraduation;
    }

    @Override
    public String toString() {
        return super.toString() + "Numarul de ani pana la terminarea studiilor: " + expectedGraduation + "\n";
    }
}
