package model;

public class Resident extends Stuff{
    private int expectedGraduation;

    public Resident() {
        super();
    }
    public Resident(int id, String firstName, String lastName, int age, String email, String phone, String sex, int salary, int experience, int expectedGraduation) {
        super(id, firstName, lastName, age, email, phone, sex, salary, experience);
        this.expectedGraduation = expectedGraduation;
    }

    public int getExpectedGraduation() {
        return expectedGraduation;
    }

    public void setExpectedGraduation(int expectedGraduation) {
        this.expectedGraduation = expectedGraduation;
    }

    @Override
    public String toString() {
        return super.toString() + "Numarul de ani pana la terminarea studiilor: " + expectedGraduation + "\n";
    }
}
