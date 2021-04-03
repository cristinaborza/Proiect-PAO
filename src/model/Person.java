package model;

import java.util.Scanner;

public abstract class Person implements Comparable<Person>{
    private String cnp;
    private String firstName, lastName;
    private int age;
    private String email, phone;
    private boolean sex;

    public Person() { }
    public Person(String cnp, String firstName, String lastName, int age, String email, String phone, boolean sex) {
        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public int compareTo(Person o) {
        if(this.lastName.compareTo(o.getLastName()) != 0)
            return this.lastName.compareTo(o.getLastName());
        return this.firstName.compareTo(o.getFirstName());
    }

    @Override
    public String toString() {
        return  "Nume: " + lastName + '\n' +
                "Prenume: " + firstName + '\n' +
                "Varsta: " + age + '\n' +
                "CNP: " + cnp + '\n';
    }

    public void read(Scanner scanner) {
        System.out.println("Introduceti cnp-ul:");
        String cnp = scanner.nextLine();

        System.out.println("Introduceti numele:");
        String lastName = scanner.nextLine();

        System.out.println("Introduceti prenumele:");
        String firstName = scanner.nextLine();

        System.out.println("Introduceti varsta:");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduceti adresa de e-mail:");
        String email = scanner.nextLine();

        System.out.println("Introduceti numarul de telefon:");
        String phone = scanner.nextLine();

        System.out.println("Introduceti sexul: (F/B)");
        String aux = scanner.nextLine();
        boolean sex = aux.equals("F");

        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
    }
}
