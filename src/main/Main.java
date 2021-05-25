package main;

import model.*;
import service.*;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Cabinet cabinet = new Cabinet();
        CabinetService cabinetService = new CabinetService(cabinet);
        FileWriterService fw = FileWriterService.getInstance();
        Scanner scanner = new Scanner(System.in);

        //read the stuff members
        List<Doctor> doctors = cabinetService.retrieveAllDoctors();
        for(Doctor doctor : doctors) {
            cabinetService.addStuff(doctor);
        }

        List<Resident> residents = cabinetService.retrieveAllResidents();
        for(Resident resident : residents) {
            cabinetService.addStuff(resident);
        }

        List<Assistant> assistants = cabinetService.retrieveAllAssistants();
        for(Assistant assistant : assistants) {
            cabinetService.addStuff(assistant);
        }

        //read the patients from database
        List<Patient> patients = cabinetService.retrieveAllPatients();
        for(Patient patient : patients) {
            cabinetService.addPatient(patient);
        }

        cabinetService.printPatients();
        cabinetService.printStuff();

        //interactive menu
        /*while(true) {
            System.out.println("Alegeti una dintre urmatoarele optiuni:");
            System.out.println("1. Adaugati un angajat (medic, asistent sau rezident)");
            System.out.println("1. Actualizati datele unui angajat");
            System.out.println("2. Concediati in angajat");
            System.out.println("3. Afisati toti angajatii in ordine alfabetica");
            System.out.println("5. Adaugati un pacient");
            System.out.println("4. Actualizati datele unui pacient");
            System.out.println("5. Adaugati o boala unui pacient");
            System.out.println("6. Scoateti o boala unui pacient");
            System.out.println("7. Stergeti un pacient");
            System.out.println("8. Afisati toti pacientii in ordine alfabetica");
            System.out.println("9. Adaugati o programare");
            System.out.println("10. Anulati o programare");
            System.out.println("11. Afisati toate programarile");
            System.out.println("12. Adaugati o reteta sau o trimitere unui pacient");
            System.out.println("13. Pentru un pacient afisati toate medicamentele pe care le ia");
            System.out.println("14. Iesire");

            int option = Integer.parseInt(scanner.nextLine());

            //update data for a stuff member
            if(option == 1) {
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
                    cabinetService.updateDoctor(cnp, lastName, firstName, age, email, phone, sex, salary, specialization);
                } else if(type == 2) {
                    System.out.println("Introduceti daca are sau nu studii superioare (T/F)");
                    boolean hs = scanner.nextLine().equals("T");
                    cabinetService.updateAssistant(cnp, lastName, firstName, age, email, phone, sex, salary, hs);
                } else {
                    System.out.println("Introduceti numarul de ani pana la finalizarea studiilor");
                    int date = Integer.parseInt(scanner.nextLine());
                    cabinetService.updateResident(cnp, lastName, firstName, age, email, phone, sex, salary, date);
                }
            }

            //delete a stuff member
            else if(option == 2) {
                System.out.println("Introduceti cnp-ul angajatului pe care vreti sa il stergeti:");
                String cnp = scanner.nextLine();

                cabinetService.deleteStuff(cnp);
            }

            //print all the stuff member in alphabetical order
            else if(option == 3) {
                cabinetService.printStuff();
            }

            //update data for a patient
            else if(option == 4) {
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

                cabinetService.updatePatient(cnp, firstName, lastName, age, email, phone, sex);
            }

            //add a disease to a patient
            else if(option == 5) {
                System.out.println("Introduceti cnp-ul persoanei: ");
                String cnp = scanner.nextLine();

                System.out.println("Introduceti boala pe care vreti sa o adaugati: ");
                String disease = scanner.nextLine();

                cabinetService.addDisease(cnp, disease);
            }

            //delete a disease from a patient
            else if(option == 6) {
                System.out.println("Introduceti cnp-ul persoanei: ");
                String cnp = scanner.nextLine();

                System.out.println("Introduceti boala pe care vreti sa o adaugati: ");
                String disease = scanner.nextLine();

                cabinetService.removeDisease(cnp, disease);
            }

            //delete a patient
            else if(option == 7) {
                System.out.println("Introduceti cnp-ul pacientului pe care vreti sa il stergeti:");
                String cnp = scanner.nextLine();

                cabinetService.deletePatient(cnp);
            }

            //print all the patients in alphabetical order
            else if(option == 8) {
                cabinetService.printPatients();
            }

            //add an appointment
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
                    surgery.setPatient(cabinetService.searchPatient(cnpPatient));
                    surgery.setDoctor(cabinetService.searchDoctor(cnpDoctor));
                    surgery.setPrice(price);

                    System.out.println("Introduceti numarul necesar de ore: ");
                    int time = Integer.parseInt(scanner.nextLine());

                    System.out.println("Introduceti numarul de asistenti: ");
                    int n = Integer.parseInt(scanner.nextLine());

                    List<Assistant> assistants = new ArrayList<>();
                    for(int i = 1; i <= n; ++i) {
                        System.out.println("Introduceti cnp-ul asistenului: ");
                        String cnpAssistant = scanner.nextLine();
                        Assistant assistant = cabinetService.searchAssistant(cnpAssistant);
                        assistants.add(assistant);
                    }

                    surgery.setTime(time);
                    surgery.setAssistants(assistants);
                    cabinetService.addAppointment(surgery);
                }

                else if(type == 2) {
                    Examination examination = new Examination();
                    examination.setDate(date);
                    examination.setPatient(cabinetService.searchPatient(cnpPatient));
                    examination.setDoctor(cabinetService.searchDoctor(cnpDoctor));
                    examination.setPrice(price);

                    System.out.println("Introduceti rezultatul examinarii: ");
                    String verdict = scanner.nextLine();

                    examination.setVerdict(verdict);
                    cabinetService.addAppointment(examination);
                }
            }

            //delete an appointment
            else if(option == 10) {
                System.out.println("Introduceti id-ul programarii pe care vreti sa o anulati");
                int id = Integer.parseInt(scanner.nextLine());
                cabinetService.deleteAppointment(id);
            }

            //print all appointments
            else if(option == 11) {
                cabinetService.printAppointments();
            }

            //add a prescription or an referral
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
                    List<Drug> drugs = new ArrayList<>();
                    for(int i = 1; i <= n; ++i) {
                        System.out.println("Indroduceti numele medicamentului: ");
                        String medName = scanner.nextLine();

                        System.out.println("Introduceti pretul: ");
                        int price = Integer.parseInt(scanner.nextLine());

                        List<String> ingredients = new ArrayList<>();
                        System.out.println("Introduceti numarul de ingrediente si apoi ingredientele: ");
                        int m = Integer.parseInt(scanner.nextLine());
                        for(int j = 1; j <= m; ++j) {
                            String ingredient = scanner.nextLine();
                            ingredients.add(ingredient);
                        }

                        Drug drug = new Drug(medName, price, ingredients);
                        drugs.add(drug);
                    }

                    Prescription prescription = new Prescription(date, cabinetService.searchDoctor(cnpDoctor), cabinetService.searchPatient(cnpPatient), drugs);
                    cabinetService.addDocument(prescription);
                }

                else {
                    System.out.println("Introduceti cnp-ul doctorului la care e trimiterea: ");
                    String cnpDoctorRef = scanner.nextLine();

                    Referral referral = new Referral(date, cabinetService.searchDoctor(cnpDoctor), cabinetService.searchPatient(cnpPatient), cabinetService.searchDoctor(cnpDoctorRef));
                    cabinetService.addDocument(referral);
                }
            }

            //print all the drugs for a patient
            else if(option == 13) {
                System.out.println("Introduceti cnp-ul persoanei despre care vreti sa aflati informatiile");
                String cnp = scanner.nextLine();
                cabinetService.printDrugs(cnp);
            }

            //exit
            else if(option == 14) {
                break;
            }

            else {
                System.out.println("Optiunea introdusa este invalida");
            }
        }

        //write the doctors in a csv file
        List<Doctor> doctors = cabinet.getDoctors();
        fw.writeDoctors("doctorsFinal.csv", doctors);

        //write the assistants in a csv file
        List<Assistant> assistants = cabinet.getAssistants();
        fw.writeAssistants("assistantsFinal.csv", assistants);

        //write the residents in a csv file
        List<Resident> residents = cabinet.getResidents();
        fw.writeResidents("residentsFinal.csv", residents);

        //write the patients in a csv file
        TreeSet<Patient> patients = cabinet.getPatients();
        fw.writePatients("patientsFinal.csv", patients); */
    }
}
