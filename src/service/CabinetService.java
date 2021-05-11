package service;

import model.*;

import java.util.*;

public class CabinetService {
    private final Cabinet cabinet;
    private final AuditService auditService = new AuditService();

    public CabinetService(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    public void addStuff(Stuff stuffMember) {
        //add the stuff member to
        TreeSet<Stuff> stuff = cabinet.getStuff();
        stuff.add(stuffMember);
        cabinet.setStuff(stuff);

        //add the event to log.csv
        if(stuffMember instanceof Doctor) {
            auditService.logEvent("Add a Doctor");
        }

        if(stuffMember instanceof Assistant) {
            auditService.logEvent("Add an Assistant");
        }

        if(stuffMember instanceof Resident) {
            auditService.logEvent("Add an Resident");
        }
    }

    public void printStuff() {
        //print stuff
        TreeSet<Stuff> stuff = cabinet.getStuff();
        for(Stuff temp : stuff) {
            System.out.println(temp);
        }

        //add the event to log.csv
        auditService.logEvent("Print Stuff");
    }

    public Stuff searchStuff(String cnp) {
        TreeSet<Stuff> stuff = cabinet.getStuff();
        for(Stuff currentStuff : stuff) {
            if(cnp.equals(currentStuff.getCnp())) {
                return currentStuff;
            }
        }

        return new Doctor();
    }

    public void deleteStuff(String cnp) {
        //delete a stuff member
        Stuff stuffMember = searchStuff(cnp);
        TreeSet<Stuff> stuff = cabinet.getStuff();
        stuff.remove(stuffMember);
        cabinet.setStuff(stuff);

        //add the event to log.csv
        if(stuffMember instanceof Doctor) {
            auditService.logEvent("Delete a Doctor");
        }
    }

    public Doctor searchDoctor(String cnp) {
        TreeSet<Stuff> stuff = cabinet.getStuff();
        for(Stuff currentStuff : stuff) {
            if(cnp.equals(currentStuff.getCnp()) && currentStuff instanceof Doctor) {
                return (Doctor) currentStuff;
            }
        }

        return new Doctor();
    }

    public void updateDoctor(String cnp, String firstName, String lastName, int age, String email, String phone, boolean sex, int salary, String specialization) {
        //update the information for a doctor
        TreeSet<Stuff> stuff = cabinet.getStuff();
        Doctor doctor = searchDoctor(cnp);
        stuff.remove(doctor);

        doctor.setFirstName(firstName);
        doctor.setLastName(lastName);
        doctor.setAge(age);
        doctor.setEmail(email);
        doctor.setPhone(phone);
        doctor.setSex(sex);
        doctor.setSalary(salary);
        doctor.setSpecialization(specialization);

        stuff.add(doctor);
        cabinet.setStuff(stuff);

        //add the event to log.csv
        auditService.logEvent("Update a Doctor");
    }

    public Assistant searchAssistant(String cnp) {
        TreeSet<Stuff> stuff = cabinet.getStuff();
        for(Stuff currentStuff : stuff) {
            if(cnp.equals(currentStuff.getCnp()) && currentStuff instanceof Assistant) {
                return (Assistant) currentStuff;
            }
        }

        return new Assistant();
    }

    public void updateAssistant(String cnp, String firstName, String lastName, int age, String email, String phone, boolean sex, int salary, boolean haveSuperiorStudies) {
        //update information for an assistant
        TreeSet<Stuff> stuff = cabinet.getStuff();
        Assistant assistant = searchAssistant(cnp);
        stuff.remove(assistant);

        assistant.setFirstName(firstName);
        assistant.setLastName(lastName);
        assistant.setAge(age);
        assistant.setEmail(email);
        assistant.setPhone(phone);
        assistant.setSex(sex);
        assistant.setSalary(salary);
        assistant.setHaveSuperiorStudies(haveSuperiorStudies);

        stuff.add(assistant);
        cabinet.setStuff(stuff);

        //add event
        auditService.logEvent("Update an Assistant");
    }

    public Resident searchResident(String cnp) {
        TreeSet<Stuff> stuff = cabinet.getStuff();
        for(Stuff currentStuff : stuff) {
            if(cnp.equals(currentStuff.getCnp()) && currentStuff instanceof Resident) {
                return (Resident) currentStuff;
            }
        }

        return new Resident();
    }

    public void updateResident(String cnp, String firstName, String lastName, int age, String email, String phone, boolean sex, int salary, int expectedGraduation) {
        //update information for an resident
        TreeSet<Stuff> stuff = cabinet.getStuff();
        Resident resident = searchResident(cnp);
        stuff.remove(resident);

        resident.setFirstName(firstName);
        resident.setLastName(lastName);
        resident.setAge(age);
        resident.setEmail(email);
        resident.setPhone(phone);
        resident.setSex(sex);
        resident.setSalary(salary);
        resident.setExpectedGraduation(expectedGraduation);

        stuff.add(resident);
        cabinet.setStuff(stuff);

        //add event
        auditService.logEvent("Update an resident");
    }

    public void addPatient(Patient patient) {
        //add the patient
        TreeSet<Patient> patients = cabinet.getPatients();
        patients.add(patient);
        cabinet.setPatients(patients);

        //add event
        auditService.logEvent("Add a patient");
    }

    public void printPatients() {
        //print all patients
        TreeSet<Patient> patients = cabinet.getPatients();
        for(Patient temp : patients) {
            System.out.println(temp);
        }

        //add event
        auditService.logEvent("Print all patients");
    }

    public Patient searchPatient(String cnp) {
        TreeSet<Patient> patients = cabinet.getPatients();
        for(Patient currentPatient : patients) {
            if(cnp.equals(currentPatient.getCnp())) {
                return currentPatient;
            }
        }

        return new Patient();
    }

    public void deletePatient(String cnp) {
        //delete the patient
        Patient patient = searchPatient(cnp);
        TreeSet<Patient> patients = cabinet.getPatients();
        patients.remove(patient);
        cabinet.setPatients(patients);

        //add event
        auditService.logEvent("Delete a patient");
    }

    public void updatePatient(String cnp, String firstName, String lastName, int age, String email, String phone, boolean sex) {
        //update information for a patient
        TreeSet<Patient> patients = cabinet.getPatients();
        Patient patient = searchPatient(cnp);
        patients.remove(patient);

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setAge(age);
        patient.setEmail(email);
        patient.setPhone(phone);
        patient.setSex(sex);

        patients.add(patient);
        cabinet.setPatients(patients);

        //log event
        auditService.logEvent("Update a patient");
    }

    public void addDisease(String cnp, String disease) {
        //add a disease to a patient
        TreeSet<Patient> patients = cabinet.getPatients();
        Patient patient = searchPatient(cnp);
        patients.remove(patient);

        List<String> diseases = patient.getDiseases();
        boolean ok = true;
        for(String d : diseases) {
            if(d == disease) {
                System.out.println("Pacientul are deja aceasta boala");
                ok = false;
                break;
            }
        }

        if(ok) {
            diseases.add(disease);
            patient.setDiseases(diseases);
        }

        patients.add(patient);
        cabinet.setPatients(patients);

        //log event
        auditService.logEvent("Add a disease");
    }

    public void removeDisease(String cnp, String disease) {
        //remove a disease from a patient
        TreeSet<Patient> patients = cabinet.getPatients();
        Patient patient = searchPatient(cnp);
        patients.remove(patient);

        List<String> diseases = patient.getDiseases();
        boolean ok = true;
        for(String d : diseases) {
            if(d == disease) {
                diseases.remove(d);
                ok = false;
                break;
            }
        }

        if(ok) {
            System.out.println("Pacientul nu are aceasta boala!");
        }

        patient.setDiseases(diseases);
        patients.add(patient);
        cabinet.setPatients(patients);

        //log event
        auditService.logEvent("Delete a disease");
    }

    public void deleteAppointment(int id) {
        //delete an appointment
        List<Appointment> appointments = cabinet.getAppointments();
        for(Appointment appointment : appointments) {
            if(appointment.getId() == id) {
                appointments.remove(appointment);
                cabinet.setAppointments(appointments);
                return;
            }
        }

        //log event
        auditService.logEvent("Delete an appointment");
    }

    public void addAppointment(Appointment appointment) {
        //add an appointment
        List<Appointment> appointments = cabinet.getAppointments();
        appointments.add(appointment);
        cabinet.setAppointments(appointments);

        //log event
        auditService.logEvent("Add an appointment");
    }

    public void printAppointments() {
        //print all appointments
        List<Appointment> appointments = cabinet.getAppointments();
        for(Appointment appointment : appointments) {
            System.out.println(appointment);
        }

        //log event
        auditService.logEvent("Print all appointments");
    }

    public void addDocument(Document document) {
        //add a document
        Patient patient = document.getPatient();
        TreeMap<String, List<Document>> patientDocuments = cabinet.getPatientDocuments();
        if(patientDocuments.containsKey(patient.getCnp())) {
            List<Document> documents = patientDocuments.get(patient.getCnp());
            documents.add(document);
            patientDocuments.put(patient.getCnp(), documents);
            cabinet.setPatientDocuments(patientDocuments);
        } else {
            List<Document> documents = new ArrayList<>();
            documents.add(document);
            patientDocuments.put(patient.getCnp(), documents);
            cabinet.setPatientDocuments(patientDocuments);
        }

        //log event
        auditService.logEvent("Add a document");
    }

    public void printDrugs(String cnp) {
        //print all drugs for a patient
        TreeMap<String, List<Document>> documents = cabinet.getPatientDocuments();
        List<Document> myDoc = documents.get(cnp);
        List<Drug> drugs = new ArrayList<>();
        for(Document document : myDoc) {
            if(document instanceof Prescription) {
                for(Drug drug : ((Prescription) document).getDrugs()) {
                    drugs.add(drug);
                }
            }
        }

        for(Drug drug : drugs) {
            System.out.println(drug);
        }

        //log event
        auditService.logEvent("Print all drugs");
    }
}
