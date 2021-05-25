package model;

public class Doctor extends Stuff{
    private String specialization;

    public Doctor() {
        super();
    }
    public Doctor(int  id, String firstName, String lastName, int age, String email, String phone, String sex, int salary, int experience, String specialization) {
        super(id, firstName, lastName, age, email, phone, sex, salary, experience);
        this.specialization = specialization;
    }
    public Doctor(String firstName, String lastName, int age, String email, String phone, String sex, int salary, int experience, String specialization) {
        super(firstName, lastName, age, email, phone, sex, salary, experience);
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
}
