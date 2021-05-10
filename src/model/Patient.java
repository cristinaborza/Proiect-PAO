package model;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Person{
    private List<String> diseases = new ArrayList<>();

    public  Patient() {
        super();
    }

    public Patient(String cnp, String firstName, String lastName, int age, String email, String phone, boolean sex, List<String> diseases) {
        super(cnp, firstName, lastName, age, email, phone, sex);
        this.diseases = diseases;
    }

    public List<String> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<String> diseases) {
        this.diseases = diseases;
    }
}
