package model;

import java.util.Scanner;

public class Resident extends Stuff{
    private int expectedGraduation;

    public Resident() {
        super();
    }
    public Resident(String firstName, String lastName, int age, String email, String phone, boolean sex, int salary, int experience, int expectedGraduation) {
        super(firstName, lastName, age, email, phone, sex, salary, experience);
        this.expectedGraduation = expectedGraduation;
    }

    public int getExpectedGraduation() {
        return expectedGraduation;
    }

    public void setExpectedGraduation(int expectedGraduation) {
        this.expectedGraduation = expectedGraduation;
    }

    @Override
    public void read(Scanner scanner) {
        super.read(scanner);

        System.out.println("Introduceti numarul de ani pana la absolvire:");
        int expectedGraduation = Integer.parseInt(scanner.nextLine());

        this.expectedGraduation = expectedGraduation;
    }
}
