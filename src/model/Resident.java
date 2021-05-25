package model;

import java.time.LocalDate;

public class Resident extends Stuff{
    private LocalDate graduationDate;

    public Resident() {
        super();
    }

    public Resident(int id, String firstName, String lastName, int age, String email, String phone, String sex, int salary, int experience, LocalDate graduationDate) {
        super(id, firstName, lastName, age, email, phone, sex, salary, experience);
        this.graduationDate = graduationDate;
    }

    public Resident(String firstName, String lastName, int age, String email, String phone, String sex, int salary, int experience, LocalDate graduationDate) {
        super(firstName, lastName, age, email, phone, sex, salary, experience);
        this.graduationDate = graduationDate;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    @Override
    public String toString() {
        return super.toString() + "Expected graduation date: " + graduationDate + "\n";
    }
}
