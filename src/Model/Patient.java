package Model;

public class Patient extends Person{
    private String[] diseases;

    public Patient(String firstName, String lastName, int age, String email, String phone, boolean sex, String[] diseases) {
        super(firstName, lastName, age, email, phone, sex);
        this.diseases = diseases;
    }

    public String[] getDiseases() {
        return diseases;
    }

    public void setDiseases(String[] diseases) {
        this.diseases = diseases;
    }
}
