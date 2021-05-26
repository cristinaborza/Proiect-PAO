package service;

import model.*;
import repository.CabinetRepository;

import java.util.*;

public class CabinetService {
    private final Cabinet cabinet;
    private final AuditService auditService = new AuditService();
    private final CabinetRepository cabinetRepository = new CabinetRepository();

    public CabinetService(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    public List<Doctor> retrieveAllDoctors() {
        auditService.logEvent("Get all doctors");
        return cabinetRepository.retrieveAllDoctors();
    }

    public List<Resident> retrieveAllResidents() {
        auditService.logEvent("Get all residents");
        return cabinetRepository.retrieveAllResidents();
    }

    public List<Assistant> retrieveAllAssistants() {
        auditService.logEvent("Get all assistants");
        return cabinetRepository.retrieveAllAssistants();
    }

    public List<Patient> retrieveAllPatients() {
        auditService.logEvent("Get all patients");
        return cabinetRepository.retrieveAllPatients();
    }

    public int addNewDoctor(Doctor doctor) {
        auditService.logEvent("Add new doctor");
        return cabinetRepository.addNewDoctor(doctor);
    }

    public int addNewAssistant(Assistant assistant) {
        auditService.logEvent("Add new assistant");
        return cabinetRepository.addNewAssistant(assistant);
    }

    public int addNewResident(Resident resident) {
        auditService.logEvent("Add new doctors");
        return cabinetRepository.addNewResident(resident);
    }

    public int addNewPatient(Patient patient) {
        auditService.logEvent("Add new doctors");
        return cabinetRepository.addNewPatient(patient);
    }

    public void addNewDisease(Disease disease) {
        auditService.logEvent("Add new disease");
        cabinetRepository.addNewDisease(disease);
    }

    public void addNewPatientDisease(int patientId, int diseaseId) {
        auditService.logEvent("Add new disease to a patient");
        cabinetRepository.addNewPatientDisease(patientId, diseaseId);
    }

    public void updateDoctor(Doctor doctor, int id) {
        auditService.logEvent("Update a doctor");
        cabinetRepository.updateDoctor(doctor, id);
    }

    public void updateAssistant(Assistant assistant, int id) {
        auditService.logEvent("Update a assistant");
        cabinetRepository.updateAssistant(assistant, id);
    }

    public void updateResident(Resident resident, int id) {
        auditService.logEvent("Update a resident");
        cabinetRepository.updateResident(resident, id);
    }

    public void updatePatient(Patient patient, int id) {
        auditService.logEvent("Update a patient");
        cabinetRepository.updatePatient(patient, id);
    }

    public void deleteDoctor(int id) {
        auditService.logEvent("Delete a doctor");
        cabinetRepository.deleteDoctor(id);
    }

    public void deleteAssistant(int id) {
        auditService.logEvent("Delete a assistant");
        cabinetRepository.deleteAssistant(id);
    }

    public void deleteResident(int id) {
        auditService.logEvent("Delete a resident");
        cabinetRepository.deleteResident(id);
    }

    public void deletePatientDisease(int patientId, int diseaseId) {
        auditService.logEvent("Delete a patient disease");
        cabinetRepository.deletePatientDisease(patientId, diseaseId);
    }

    public void deletePatient(int id) {
        auditService.logEvent("Delete a patient");
        cabinetRepository.deletePatient(id);
    }

    public boolean checkDisease(Disease disease) {
        int nr = cabinetRepository.countDiseases(disease);
        return nr == 0;
    }

    public int getDiseaseId(Disease disease) {
        return cabinetRepository.getDiseaseId(disease);
    }

    public Patient getPatient(int id) {
        return cabinetRepository.getPatient(id);
    }

    public Doctor getDoctor(int id) {
        return cabinetRepository.getDoctor(id);
    }

    public Assistant getAssistant(int id) {
        return cabinetRepository.getAssistant(id);
    }

    public void addAppointment(Appointment appointment) {
        //add an appointment
        List<Appointment> appointments = cabinet.getAppointments();
        appointments.add(appointment);
        cabinet.setAppointments(appointments);

        //log event
        auditService.logEvent("Add an appointment");
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
        TreeMap<Integer, List<Document>> patientDocuments = cabinet.getPatientDocuments();
        List<Document> documents;
        if(patientDocuments.containsKey(patient.getId())) {
            documents = patientDocuments.get(patient.getId());
        } else {
            documents = new ArrayList<>();
        }
        documents.add(document);
        patientDocuments.put(patient.getId(), documents);
        cabinet.setPatientDocuments(patientDocuments);

        //log event
        auditService.logEvent("Add a new document");

    }

    public void printDrugs(int cnp) {
        //print all drugs for a patient
        TreeMap<Integer, List<Document>> documents = cabinet.getPatientDocuments();
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
