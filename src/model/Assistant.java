package model;

import java.util.Scanner;

public class Assistant extends Stuff{
    private boolean haveSuperiorStudies;

    public Assistant() {
        super();
    }
    public Assistant(String cnp, String firstName, String lastName, int age, String email, String phone, boolean sex, int salary, int experience, boolean haveSuperiorStudies) {
        super(cnp, firstName, lastName, age, email, phone, sex, salary, experience);
        this.haveSuperiorStudies = haveSuperiorStudies;
    }

    public void setHaveSuperiorStudies(boolean haveSuperiorStudies) {
        this.haveSuperiorStudies = haveSuperiorStudies;
    }

    @Override
    public String toString() {
        if (this.haveSuperiorStudies)
            return super.toString() + "\n" + "Asistent cu studii superioare";
        return super.toString() + "\n" + "Asistent fara studii superioare";
    }

    @Override
    public void read(Scanner scanner) {
        super.read(scanner);

        System.out.println("Introduceti daca asistentul are sau nu studii superioare (T/F):");
        String temp = scanner.nextLine();
        this.haveSuperiorStudies = temp.equals("T");
    }
}
