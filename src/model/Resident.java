package model;

public class Resident extends Stuff{
    private int expectedGraduation;
    private Doctor boss;

    public Resident(String firstName, String lastName, int age, String email, String phone, boolean sex, int salary, int experience, int expectedGraduation, Doctor boss) {
        super(firstName, lastName, age, email, phone, sex, salary, experience);
        this.expectedGraduation = expectedGraduation;
        this.boss = boss;
    }

    public int getExpectedGraduation() {
        return expectedGraduation;
    }

    public void setExpectedGraduation(int expectedGraduation) {
        this.expectedGraduation = expectedGraduation;
    }

    public Doctor getBoss() {
        return boss;
    }

    public void setBoss(Doctor boss) {
        this.boss = boss;
    }
}
