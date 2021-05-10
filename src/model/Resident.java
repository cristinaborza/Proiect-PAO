package model;

import java.util.Scanner;

public class Resident extends Stuff{
    private int expectedGraduation;

    public Resident() {
        super();
    }
    public Resident(String cnp, String firstName, String lastName, int age, String email, String phone, boolean sex, int salary, int experience, int expectedGraduation) {
        super(cnp, firstName, lastName, age, email, phone, sex, salary, experience);
        this.expectedGraduation = expectedGraduation;
    }

    public int getExpectedGraduation() {
        return expectedGraduation;
    }

    public void setExpectedGraduation(int expectedGraduation) {
        this.expectedGraduation = expectedGraduation;
    }
}
