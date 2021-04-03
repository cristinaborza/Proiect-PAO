package main;

import model.*;
import service.*;

import java.util.ArrayList;
import java.util.List;
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
            System.out.println("3. Concediati in angajat");
            System.out.println("4. Afisati toti angajatii in ordine alfabetica");
            System.out.println("5. Adaugati un pacient");
            System.out.println("6. Actualizati datele unui pacient");
            System.out.println("7. Stergeti un pacient");
            System.out.println("8. Afisati toti pacientii in ordine alfabetica");
            System.out.println("9. Adaugati o programare");
            System.out.println("10. Anulati o programare");
            System.out.println("11. Afisati toate programarile");
            System.out.println("12. Adaugati o reteta sau o trimitere unui pacient");
            System.out.println("13. Pentru un pacient afisati toate medicamentele pe care le ia");
            System.out.println("14. Iesire");

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
            }

            else if(option == 2) {
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

                System.out.println("Introduceti noul salariu");
                int salary = Integer.parseInt(scanner.nextLine());

                System.out.println("Introduceti tipul de angajat (1 - medic, 2 - asistent, 3 - rezident)");
                int type = Integer.parseInt(scanner.nextLine());

                if(type == 1) {
                    System.out.println("Introduceti noua specializare");
                    String specialization = scanner.nextLine();
                    clinicService.updateDoctor(cnp, lastName, firstName, age, email, phone, sex, salary, specialization);
                } else if(type == 2) {
                    System.out.println("Introduceti daca are sau nu studii superioare (T/F)");
                    boolean hs = scanner.nextLine().equals("T");
                    clinicService.updateAssistant(cnp, lastName, firstName, age, email, phone, sex, salary, hs);
                } else {
                    System.out.println("Introduceti numarul de ani pana la finalizarea studiilor");
                    int date = Integer.parseInt(scanner.nextLine());
                    clinicService.updateResident(cnp, lastName, firstName, age, email, phone, sex, salary, date);
                }
            }

            else if(option == 3) {
                System.out.println("Introduceti cnp-ul angajatului pe care vreti sa il stergeti:");
                String cnp = scanner.nextLine();

                clinicService.deleteStuff(cnp);
            }

            else if(option == 4) {
                clinicService.printStuff();
            }

            else if(option == 5) {
                Patient patient = new Patient();
                patient.read(scanner);
                clinicService.addPatient(patient);
            }

            else if(option == 6) {
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

                clinicService.updatePatient(cnp, firstName, lastName, age, email, phone, sex);
            }

            else if(option == 7) {
                System.out.println("Introduceti cnp-ul pacientului pe care vreti sa il stergeti:");
                String cnp = scanner.nextLine();

                clinicService.deletePatient(cnp);
            }

            else if(option == 8) {
                clinicService.printPatients();
            }

            else if(option == 9) {
                System.out.println("Introduceti data: ");
                String date = scanner.nextLine();

                System.out.println("Introduceti cnp-ul pacientului: ");
                String cnpPatient = scanner.nextLine();

                System.out.println("Introduceti cnp-ul medicului: ");
                String cnpDoctor = scanner.nextLine();

                System.out.println("Introduceti pretul:" );
                int price = Integer.parseInt(scanner.nextLine());

                System.out.println("Introduceti tipul de programare: (1 - operatie, 2 - examinare)");
                int type = Integer.parseInt(scanner.nextLine());

                if(type == 1) {
                    Surgery surgery = new Surgery();
                    surgery.setDate(date);
                    surgery.setPatient(clinicService.searchPatient(cnpPatient));
                    surgery.setDoctor(clinicService.searchDoctor(cnpDoctor));
                    surgery.setPrice(price);

                    System.out.println("Introduceti numarul necesar de ore: ");
                    int time = Integer.parseInt(scanner.nextLine());

                    System.out.println("Introduceti numarul de asistenti: ");
                    int n = Integer.parseInt(scanner.nextLine());

                    List<Assistant> assistants = new ArrayList<>();
                    for(int i = 1; i <= n; ++i) {
                        System.out.println("Introduceti cnp-ul asistenului: ");
                        String cnpAssistant = scanner.nextLine();
                        Assistant assistant = clinicService.searchAssistant(cnpAssistant);
                        assistants.add(assistant);
                    }

                    surgery.setTime(time);
                    surgery.setAssistants(assistants);
                    clinicService.addAppointment(surgery);
                }

                else if(type == 2) {
                    Examination examination = new Examination();
                    examination.setDate(date);
                    examination.setPatient(clinicService.searchPatient(cnpPatient));
                    examination.setDoctor(clinicService.searchDoctor(cnpDoctor));
                    examination.setPrice(price);

                    System.out.println("Introduceti rezultatul examinarii: ");
                    String verdict = scanner.nextLine();

                    examination.setVerdict(verdict);
                    clinicService.addAppointment(examination);
                }
            }

            else if(option == 10) {
                System.out.println("Introduceti id-ul programarii pe care vreti sa o anulati");
                int id = Integer.parseInt(scanner.nextLine());
                clinicService.deleteAppointment(id);
            }

            else if(option == 11) {
                clinicService.printAppointments();
            }

            else if(option == 12) {
                System.out.println("Introduceti cnp-ul pacientului: ");
                String cnpPatient = scanner.nextLine();

                System.out.println("Introduceti cnp-ul doctorului care a emis documentul: ");
                String cnpDoctor = scanner.nextLine();

                System.out.println("Introduceti data la care a fost emis: ");
                String date = scanner.nextLine();

                System.out.println("Introduceti tipul de document(1 - Reteta, 2 - Trimitere): ");
                int type = Integer.parseInt(scanner.nextLine());

                if(type == 1) {
                    System.out.println("Introduceti numarul de medicamente din reteta: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    List<Drug> drugs = new ArrayList<Drug>();
                    for(int i = 1; i <= n; ++i) {
                        System.out.println("Indroduceti numele medicamentului: ");
                        String medName = scanner.nextLine();

                        System.out.println("Introduceti pretul: ");
                        int price = Integer.parseInt(scanner.nextLine());

                        List<String> ingredients = new ArrayList<String>();
                        System.out.println("Introduceti numarul de ingrediente si apoi ingredientele: ");
                        int m = Integer.parseInt(scanner.nextLine());
                        for(int j = 1; j <= m; ++j) {
                            String ingredient = scanner.nextLine();
                            ingredients.add(ingredient);
                        }

                        Drug drug = new Drug(medName, price, ingredients);
                        drugs.add(drug);
                    }

                    Prescription prescription = new Prescription(date, clinicService.searchDoctor(cnpDoctor), clinicService.searchPatient(cnpPatient), drugs);
                    clinicService.addDocument(prescription);
                }

                else {
                    System.out.println("Introduceti cnp-ul doctorului la care e trimiterea: ");
                    String cnpDoctorRef = scanner.nextLine();

                    Referral referral = new Referral(date, clinicService.searchDoctor(cnpDoctor), clinicService.searchPatient(cnpPatient), clinicService.searchDoctor(cnpDoctorRef));
                    clinicService.addDocument(referral);
                }
            }

            else if(option == 13) {
                System.out.println("Introduceti cnp-ul persoanei despre care vreti sa aflati informatiile");
                String cnp = scanner.nextLine();
                clinicService.printDocuments(cnp);
            }

            else if(option == 14) {
                break;
            }

            else {
                System.out.println("Optiunea introdusa este invalida");
            }
        }
    }
}
