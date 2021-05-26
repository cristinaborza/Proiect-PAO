package main;

import model.*;
import service.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Cabinet cabinet = new Cabinet();
        CabinetService cabinetService = new CabinetService(cabinet);
        FileWriterService fw = FileWriterService.getInstance();
        Scanner scanner = new Scanner(System.in);

        //interactive menu
        while(true) {
            System.out.println("Chose one of the following options:");
            System.out.println("1. Add a stuff member (doctor, assistant or resident)");
            System.out.println("2. Update a stuff member");
            System.out.println("3. Fire a stuff member");
            System.out.println("4. Print all employees in alphabetical order");
            System.out.println("5. Add a patient");
            System.out.println("6. Update a patient");
            System.out.println("7. Add a disease for a patient");
            System.out.println("8. Cure a disease for a patient");
            System.out.println("9. Delete a patient");
            System.out.println("10. Print all patients in alphabetical order");
            System.out.println("11. Add an appointment");
            System.out.println("12. Delete an appointment");
            System.out.println("13. Print all appointments");
            System.out.println("14. Add a prescription or a referral");
            System.out.println("15. Print all the medications a patient is taking");
            System.out.println("16. Exit");

            int option = Integer.parseInt(scanner.nextLine());

            if(option == 1) {
                System.out.println("First name: ");
                String firstName = scanner.nextLine();

                System.out.println("Last name: ");
                String lastName = scanner.nextLine();

                System.out.println("Age: ");
                int age = Integer.parseInt(scanner.nextLine());

                System.out.println("Email: ");
                String email = scanner.nextLine();

                System.out.println("Phone: ");
                String phone = scanner.nextLine();

                System.out.println("Sex(F/M): ");
                String sex = scanner.nextLine();

                System.out.println("Salary: ");
                int salary = Integer.parseInt(scanner.nextLine());

                System.out.println("Experience: ");
                int experience = Integer.parseInt(scanner.nextLine());

                System.out.println("What kind of employee do you want to add? (1 - doctor, 2 - assistant, 3 - resident) ");
                int type = Integer.parseInt(scanner.nextLine());
                if (type == 1) {
                    System.out.println("Specialization: ");
                    String specialization = scanner.nextLine();

                    Doctor doctor = new Doctor(firstName, lastName, age, email, phone, sex, salary, experience, specialization);
                    int doctorID = cabinetService.addNewDoctor(doctor);
                    doctor.setId(doctorID);
                } else if (type == 2) {
                    System.out.println("Studies: ");
                    String studies = scanner.nextLine();

                    Assistant assistant = new Assistant(firstName, lastName, age, email, phone, sex, salary, experience, studies);
                    int assistantId = cabinetService.addNewAssistant(assistant);
                    assistant.setId(assistantId);
                } else {
                    System.out.println("Expected graduation date: (dd/MM/yyyy)");
                    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate localDate = LocalDate.parse(scanner.nextLine(), format);

                    Resident resident = new Resident(firstName, lastName, age, email, phone, sex, salary, experience, localDate);
                    int residentId = cabinetService.addNewResident(resident);
                    resident.setId(residentId);
                }
            } else if(option == 2) {
                System.out.println("The id of the employee you want to update: ");
                int id = Integer.parseInt(scanner.nextLine());

                System.out.println("New first name: ");
                String firstName = scanner.nextLine();

                System.out.println("New last name: ");
                String lastName = scanner.nextLine();

                System.out.println("New age: ");
                int age = Integer.parseInt(scanner.nextLine());

                System.out.println("New email: ");
                String email = scanner.nextLine();

                System.out.println("New phone: ");
                String phone = scanner.nextLine();

                System.out.println("New sex: (F/M)");
                String sex = scanner.nextLine();

                System.out.println("New salary: ");
                int salary = Integer.parseInt(scanner.nextLine());

                System.out.println("New experience: ");
                int experience = Integer.parseInt(scanner.nextLine());

                System.out.println("What kind of employee do you want to update? (1 - doctor, 2 - assistant, 3 - resident)");
                int type = Integer.parseInt(scanner.nextLine());

                if (type == 1) {
                    System.out.println("New specialization: ");
                    String specialization = scanner.nextLine();

                    Doctor doctor = new Doctor(firstName, lastName, age, email, phone, sex, salary, experience, specialization);
                    cabinetService.updateDoctor(doctor, id);
                } else if (type == 2) {
                    System.out.println("New studies: ");
                    String studies = scanner.nextLine();

                    Assistant assistant = new Assistant(firstName, lastName, age, email, phone, sex, salary, experience, studies);
                    cabinetService.updateAssistant(assistant, id);
                } else {
                    System.out.println("Expected graduation date: ");
                    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate localDate = LocalDate.parse(scanner.nextLine(), format);

                    Resident resident = new Resident(firstName, lastName, age, email, phone, sex, salary, experience, localDate);
                    cabinetService.updateResident(resident, id);
                }
            } else if(option == 3) {
                System.out.println("What kind of employee do you want to fire? (1 - doctor, 2 - assistant, 3 - resident)");
                int type = Integer.parseInt(scanner.nextLine());

                System.out.println("Id: ");
                int id = Integer.parseInt(scanner.nextLine());

                if (type == 1) {
                    cabinetService.deleteDoctor(id);
                } else if (type == 2) {
                    cabinetService.deleteAssistant(id);
                } else {
                    cabinetService.deleteResident(id);
                }
            } else if(option == 4) {
                List<Doctor> doctorList = cabinetService.retrieveAllDoctors();
                List<Resident> residentList = cabinetService.retrieveAllResidents();
                List<Assistant> assistantList = cabinetService.retrieveAllAssistants();

                List<Stuff> stuffList = new ArrayList<>();
                stuffList.addAll(doctorList);
                stuffList.addAll(residentList);
                stuffList.addAll(assistantList);

                Collections.sort(stuffList);
                for (Stuff stuff : stuffList) {
                    System.out.println(stuff);
                }
            } else if(option == 5) {
                System.out.println("First name: ");
                String firstName = scanner.nextLine();

                System.out.println("Last name: ");
                String lastName = scanner.nextLine();

                System.out.println("Age: ");
                int age = Integer.parseInt(scanner.nextLine());

                System.out.println("Email: ");
                String email = scanner.nextLine();

                System.out.println("Phone: ");
                String phone = scanner.nextLine();

                System.out.println("Sex(F/M): ");
                String sex = scanner.nextLine();

                Patient patient = new Patient(firstName, lastName, age, email, phone, sex);
                int patientID = cabinetService.addNewPatient(patient);
                patient.setId(patientID);
            } else if(option == 6) {
                System.out.println("The id of the patient you want to update: ");
                int id = Integer.parseInt(scanner.nextLine());

                System.out.println("New first name: ");
                String firstName = scanner.nextLine();

                System.out.println("New last name: ");
                String lastName = scanner.nextLine();

                System.out.println("New age: ");
                int age = Integer.parseInt(scanner.nextLine());

                System.out.println("New email: ");
                String email = scanner.nextLine();

                System.out.println("New phone: ");
                String phone = scanner.nextLine();

                System.out.println("New sex: (F/M)");
                String sex = scanner.nextLine();

                Patient patient = new Patient(firstName, lastName, age, email, phone, sex);
                cabinetService.updatePatient(patient, id);
            } else if(option == 7) {
                System.out.println("Enter patient id: ");
                int id = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter disease name: ");
                String diseaseName = scanner.nextLine();
                Disease disease = new Disease(diseaseName);

                if (cabinetService.checkDisease(disease)) {
                    cabinetService.addNewDisease(disease);
                }

                int diseaseID = cabinetService.getDiseaseId(disease);
                cabinetService.addNewPatientDisease(id, diseaseID);
            } else if(option == 8) {
                System.out.println("Enter patient id: ");
                int id = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter disease name: ");
                String diseaseName = scanner.nextLine();
                Disease disease = new Disease(diseaseName);

                if (cabinetService.checkDisease(disease)) {
                    System.out.println("This disease doesn't exist!");
                    continue;
                }

                int diseaseID = cabinetService.getDiseaseId(disease);
                cabinetService.deletePatientDisease(id, diseaseID);
            } else if(option == 9) {
                System.out.println("Enter patient id: ");
                int id = Integer.parseInt(scanner.nextLine());
                cabinetService.deletePatient(id);
            } else if(option == 10) {
                List<Patient> patientList = cabinetService.retrieveAllPatients();
                for(Patient pat : patientList) {
                    System.out.println(pat);
                }
            } else if(option == 11) {
                System.out.println("Appointment id: ");
                int appointmentId = Integer.parseInt(scanner.nextLine());

                System.out.println("Date: ");
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(scanner.nextLine(), format);

                System.out.println("Patient id: ");
                int patientId = Integer.parseInt(scanner.nextLine());

                System.out.println("Doctor id: ");
                int doctorId = Integer.parseInt(scanner.nextLine());

                System.out.println("Price:");
                int price = Integer.parseInt(scanner.nextLine());

                System.out.println("What kind of appointment is this?: (1 - surgery, 2 - examination)");
                int type = Integer.parseInt(scanner.nextLine());

                Patient pat = cabinetService.getPatient(patientId);
                Doctor doc = cabinetService.getDoctor(doctorId);
                if (type == 1) {
                    System.out.println("The number of hours required: ");
                    int time = Integer.parseInt(scanner.nextLine());

                    System.out.println("Number of assistants: ");
                    int n = Integer.parseInt(scanner.nextLine());

                    List<Assistant> assistants = new ArrayList<>();
                    for (int i = 1; i <= n; ++i) {
                        System.out.println("Assistant id: ");
                        int assistantId = Integer.parseInt(scanner.nextLine());
                        Assistant assistant = cabinetService.getAssistant(assistantId);
                        assistants.add(assistant);
                    }

                    Surgery surgery = new Surgery(date, appointmentId, pat, doc, price, time, assistants);
                    surgery.setTime(time);
                    surgery.setAssistants(assistants);
                    cabinetService.addAppointment(surgery);
                } else {
                    System.out.println("Examination result: ");
                    String verdict = scanner.nextLine();
                    Examination examination = new Examination(appointmentId, date, pat, doc, price, verdict);
                    examination.setVerdict(verdict);
                    cabinetService.addAppointment(examination);
                }
            } else if(option == 12) {
                System.out.println("Appointment id: ");
                int appointmentId = Integer.parseInt(scanner.nextLine());
                cabinetService.deleteAppointment(appointmentId);
            } else if(option == 13) {
                cabinetService.printAppointments();
            } else if(option == 14) {
                System.out.println("Patient id: ");
                int patientId = Integer.parseInt(scanner.nextLine());

                System.out.println("Doctor id: ");
                int doctorId = Integer.parseInt(scanner.nextLine());

                System.out.println("Issue date: ");
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(scanner.nextLine(), format);

                System.out.println("What kind of document do you want to issue(1 - prescription, 2 - referral): ");
                int type = Integer.parseInt(scanner.nextLine());

                Patient pat = cabinetService.getPatient(patientId);
                Doctor doc = cabinetService.getDoctor(doctorId);
                if (type == 1) {
                    System.out.println("Number of drugs: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    List<Drug> drugs = new ArrayList<>();
                    for (int i = 1; i <= n; ++i) {
                        System.out.println("Drug name: ");
                        String medName = scanner.nextLine();

                        System.out.println("Price: ");
                        int price = Integer.parseInt(scanner.nextLine());

                        List<String> ingredients = new ArrayList<>();
                        System.out.println("Number of ingredients then ingredients name: ");
                        int m = Integer.parseInt(scanner.nextLine());
                        for (int j = 1; j <= m; ++j) {
                            String ingredient = scanner.nextLine();
                            ingredients.add(ingredient);
                        }

                        Drug drug = new Drug(medName, price, ingredients);
                        drugs.add(drug);
                    }

                    Prescription prescription = new Prescription(date, doc, pat, drugs);
                    cabinetService.addDocument(prescription);
                } else {
                    System.out.println("The ID of the doctor you are referring to: ");
                    int idDoctorRef = Integer.parseInt(scanner.nextLine());

                    Referral referral = new Referral(date, doc, pat, cabinetService.getDoctor(idDoctorRef));
                    cabinetService.addDocument(referral);
                }
            } else if(option == 15) {
                System.out.println("Patient id: ");
                int patientId = Integer.parseInt(scanner.nextLine());
                cabinetService.printDrugs(patientId);
            } else if(option == 16) {
                System.out.println("Bye bye!");
                break;
            } else {
                System.out.println("Invalid option. Please try it again!");
            }
        }

        //write the doctors in a csv file
        List<Doctor> doctors = cabinetService.retrieveAllDoctors();
        fw.writeDoctors("doctorsFinal.csv", doctors);

        //write the assistants in a csv file
        List<Assistant> assistants = cabinetService.retrieveAllAssistants();
        fw.writeAssistants("assistantsFinal.csv", assistants);

        //write the residents in a csv file
        List<Resident> residents = cabinetService.retrieveAllResidents();
        fw.writeResidents("residentsFinal.csv", residents);

        //write the patients in a csv file
        List<Patient> patients = cabinetService.retrieveAllPatients();
        fw.writePatients("patientsFinal.csv", patients);
    }
}
