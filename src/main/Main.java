package main;

import model.*;
import service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        ClinicService clinicService = new ClinicService(clinic);
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Alegeti una dintre urmatoarele optiuni:");
            System.out.println("1. Adaugati un angajat (medic, asistent sau rezident)");
            System.out.println("2. Actualizati datele unui angajat");
            System.out.println("3. Afisati toti angajatii in ordine alfabetica");
            System.out.println("4. Adaugati un pacient");
            System.out.println("5. Actualizati datele unui pacient");
            System.out.println("6. Afisati toti pacientii in ordine alfabetica");
            System.out.println("7. Iesire");

            int option = Integer.parseInt(scanner.nextLine());
            if (option == 1) {
                System.out.println("Introduceti tipul de angajat (1 - medic, 2 - asistent, 3 - rezident)");
                int type = Integer.parseInt(scanner.nextLine());
                if(type == 1) {
                    Doctor doctor = new Doctor();
                    doctor.read(scanner);
                    clinicService.addStuff(doctor);
                } else if(type == 2) {
                    Assistant assistant = new Assistant();
                    assistant.read(scanner);
                    clinicService.addStuff(assistant);
                } else {
                    Resident resident = new Resident();
                    resident.read(scanner);
                    clinicService.addStuff(resident);
                }
            } else if(option == 2) {
                System.out.println("Introduceti cnp-ul persoanei careia vreti sa ii modificati datele:");
                String cnp = scanner.nextLine();

                System.out.println("Introduceti noul nume: ");
                String lastName = scanner.nextLine();

                System.out.println("Introduceti noul prenume: ");
                String firstName = scanner.nextLine();

                System.out.println("Introduceti noua varsta:");
                int age = Integer.parseInt(scanner.nextLine());

                System.out.println("Introduceti noua adresa de e-mail:");
                String email = scanner.nextLine();

                System.out.println("Introduceti noul numar de telefon:");
                String phone = scanner.nextLine();

                System.out.println("Introduceti noul sex: (F/B)");
                String aux = scanner.nextLine();
                boolean sex = aux.equals("F");

                // clinicService.updatePatient(cnp, lastName, firstName, age, email, phone, sex);
            } else if(option == 3) {
                clinicService.printStuff();
            } else if(option == 4) {
                Patient patient = new Patient();
                patient.read(scanner);
                clinicService.addPatient(patient);
            } else if(option == 6) {
                clinicService.printPatients();

            } else if(option == 7)
                break;
        }
    }
}
