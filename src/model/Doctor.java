package model;

import java.util.Scanner;

public class Doctor extends Stuff{
    private String specialization;

    public Doctor() {
        super();
    }
    public Doctor(String  cnp, String firstName, String lastName, int age, String email, String phone, boolean sex, int salary, int experience, String specialization) {
        super(cnp, firstName, lastName, age, email, phone, sex, salary, experience);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "specializare: " + specialization + '\n';
    }

    @Override
    public void read(Scanner scanner) {
        super.read(scanner);

        System.out.println("Introduceti specializarea:");
        String specialization = scanner.nextLine();

        this.specialization = specialization;
    }
}
