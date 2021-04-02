package main;

import model.*;
import service.*;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Clinic clinic = new Clinic();
        ClinicService clinicService = new ClinicService(clinic);
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Alegeti una dintre urmatoarele optiuni:");
            System.out.println("1. Adaugati un angajat (medic, asistent sau rezident)");
            System.out.println("2. Afisati toti angajatii in ordine alfabetica");
            System.out.println("3. Adaugati un pacient");
            System.out.println("4. Afisati toti pacientii in ordine alfabetica");
            System.out.println("5. Iesire");

            int option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
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

                System.out.println("Introduceti salariul:");
                int salary = Integer.parseInt(scanner.nextLine());

                System.out.println("Introduceti numarul de ani de experinta:");
                int experience = Integer.parseInt(scanner.nextLine());

                System.out.println("Introduceti tipul de angajat (1 - medic, 2 - asistent, 3 - rezident)");
                int type = Integer.parseInt(scanner.nextLine());
                if(type == 1) {
                    System.out.println("Introduceti specializarea:");
                    String specialization = scanner.nextLine();

                    Doctor doctor = new Doctor(firstName, lastName, age, email, phone, sex, salary, experience, specialization);
                    clinicService.addStuff(doctor);
                }

                else if(type == 2) {
                    System.out.println("Introduceti daca asistentul are sau nu studii superioare (T/F):");
                    String temp = scanner.nextLine();
                    boolean haveSuperiorStudies = temp.equals("T");

                    Assistant assistant = new Assistant(firstName, lastName, age, email, phone, sex, salary, experience, haveSuperiorStudies);
                    clinicService.addStuff(assistant);
                }

                else {
                    System.out.println("Introduceti numarul de ani pana la absolvire:");
                    int expectedGraduation = Integer.parseInt(scanner.nextLine());

                    Resident resident = new Resident(firstName, lastName, age, email, phone, sex, salary, experience, expectedGraduation);
                    clinicService.addStuff(resident);
                }
            }

            else if(option == 2) {
                clinicService.printStuff();
            }
            else if(option == 5)
                break;
        }
    }
}
