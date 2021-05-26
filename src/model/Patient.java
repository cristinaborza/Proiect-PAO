package model;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Person{
    private List<String> diseases = new ArrayList<>();

    public  Patient() {
        super();
    }

    public Patient(int id, String firstName, String lastName, int age, String email, String phone, String sex, List<String> diseases) {
        super(id, firstName, lastName, age, email, phone, sex);
        this.diseases = diseases;
    }

    public Patient(int id, String firstName, String lastName, int age, String email, String phone, String sex) {
        super(id, firstName, lastName, age, email, phone, sex);
    }

    public Patient(String firstName, String lastName, int age, String email, String phone, String sex) {
        super(firstName, lastName, age, email, phone, sex);
    }


    public List<String> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<String> diseases) {
        this.diseases = diseases;
    }

    public static String listToString(List<String> list) {
        String ans = "";
        for(String x : list) {
            if(ans != "") ans += ", ";
            ans += x;
        }
        if(ans == "")
            return "Nu are boli!";
        return ans;
    }

    @Override
    public String toString() {
        return super.toString() + "Lista boli: " + listToString(diseases) + "\n";
    }
}
