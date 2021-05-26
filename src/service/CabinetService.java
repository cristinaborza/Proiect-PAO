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
        return cabinetRepository.retrieveAllDoctors();
    }

    public List<Resident> retrieveAllResidents() {
        return cabinetRepository.retrieveAllResidents();
    }

    public List<Assistant> retrieveAllAssistants() {
        return cabinetRepository.retrieveAllAssistants();
    }

    public List<Patient> retrieveAllPatients() {
        return cabinetRepository.retrieveAllPatients();
    }

    public int addNewDoctor(Doctor doctor) {
        return cabinetRepository.addNewDoctor(doctor);
    }

    public int addNewAssistant(Assistant assistant) {
        return cabinetRepository.addNewAssistant(assistant);
    }

    public int addNewResident(Resident resident) {
        return cabinetRepository.addNewResident(resident);
    }

    public int addNewPatient(Patient patient) {
        return cabinetRepository.addNewPatient(patient);
    }

    public void addNewDisease(Disease disease) {
        cabinetRepository.addNewDisease(disease);
    }

    public void addNewPatientDisease(int patientId, int diseaseId) {
        cabinetRepository.addNewPatientDisease(patientId, diseaseId);
    }

    public void updateDoctor(Doctor doctor, int id) {
        cabinetRepository.updateDoctor(doctor, id);
    }

    public void updateAssistant(Assistant assistant, int id) {
        cabinetRepository.updateAssistant(assistant, id);
    }

    public void updateResident(Resident resident, int id) {
        cabinetRepository.updateResident(resident, id);
    }

    public void updatePatient(Patient patient, int id) {
        cabinetRepository.updatePatient(patient, id);
    }

    public void deleteDoctor(int id) {
        cabinetRepository.deleteDoctor(id);
    }

    public void deleteAssistant(int id) {
        cabinetRepository.deleteAssistant(id);
    }

    public void deleteResident(int id) {
        cabinetRepository.deleteResident(id);
    }

    public void deletePatientDisease(int patientId, int diseaseId) {
        cabinetRepository.deletePatientDisease(patientId, diseaseId);
    }

    public void deletePatient(int id) {
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
    }

    public void printAppointments() {
        //print all appointments
        List<Appointment> appointments = cabinet.getAppointments();
        for(Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    public void addDocument(Document document) {
        //add a document
        Patient patient = document.getPatient();
        TreeMap<Integer, List<Document>> patientDocuments = cabinet.getPatientDocuments();
        if(patientDocuments.containsKey(patient.getId())) {
            List<Document> documents = patientDocuments.get(patient.getId());
            documents.add(document);
            patientDocuments.put(patient.getId(), documents);
            cabinet.setPatientDocuments(patientDocuments);
        } else {
            List<Document> documents = new ArrayList<>();
            documents.add(document);
            patientDocuments.put(patient.getId(), documents);
            cabinet.setPatientDocuments(patientDocuments);
        }
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
    }
}
