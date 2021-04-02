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
            System.out.println("2. Afisati toti angajatii in ordine alfabetica");
            System.out.println("3. Adaugati un pacient");
            System.out.println("4. Afisati toti pacientii in ordine alfabetica");
            System.out.println("5. Iesire");

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
                clinicService.printStuff();
            } else if(option == 3) {
                Patient patient = new Patient();
                patient.read(scanner);
                clinicService.addPatient(patient);
            } else if(option == 4) {
                clinicService.printPatients();

            } else if(option == 5)
                break;
        }
    }
}
