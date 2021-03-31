package Model;

public class Doctor extends Stuff{
    private String specialization;

    public Doctor(String firstName, String lastName, int age, String email, String phone, boolean sex, int salary, int experience, String specialization) {
        super(firstName, lastName, age, email, phone, sex, salary, experience);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
