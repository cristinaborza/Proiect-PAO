package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    /*
    @Override
    public void read(Scanner scanner) {
        super.read(scanner);

        System.out.println("Introduceti numarul de boli dupa care bolile:");
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 1; i <= n; ++i) {
            String disease = scanner.nextLine();
            this.diseases.add(disease);
        }
    }*/
}
