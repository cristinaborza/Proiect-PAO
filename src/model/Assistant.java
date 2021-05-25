package model;

public class Assistant extends Stuff{
    private String studies;

    public Assistant() {
        super();
    }

    public Assistant(int id, String firstName, String lastName, int age, String email, String phone, String sex, int salary, int experience, String studies) {
        super(id, firstName, lastName, age, email, phone, sex, salary, experience);
        this.studies = studies;
    }

    public Assistant(String firstName, String lastName, int age, String email, String phone, String sex, int salary, int experience, String studies) {
        super(firstName, lastName, age, email, phone, sex, salary, experience);
        this.studies = studies;
    }

    public String getStudies() { return studies; }
    public void setStudies(String studies) {
        this.studies = studies;
    }

    @Override
    public String toString() {
        return super.toString() + studies + '\n';
    }
}
