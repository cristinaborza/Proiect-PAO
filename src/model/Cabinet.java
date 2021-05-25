package model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class Cabinet {
    private String location;
    private TreeSet<Stuff> stuff = new TreeSet<>();
    private TreeSet<Patient> patients = new TreeSet<>();
    private List<Appointment> appointments = new ArrayList<>();
    private TreeMap<Integer, List<Document>> patientDocuments = new TreeMap<>();

    public Cabinet() { }
    public Cabinet(String location, TreeSet<Stuff> stuff, TreeSet<Patient> patients, List<Appointment> appointments, TreeMap<Integer, List<Document>> patientDocuments) {
        this.location = location;
        this.stuff = stuff;
        this.patients = patients;
        this.appointments = appointments;
        this.patientDocuments = patientDocuments;
    }

    public List<Doctor> getDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        for(Stuff stuffMember : stuff) {
            if(stuffMember instanceof Doctor) {
                doctors.add((Doctor)stuffMember);
            }
        }

        return doctors;
    }

    public List<Assistant> getAssistants() {
        List<Assistant> assistants = new ArrayList<>();
        for(Stuff stuffMember : stuff) {
            if(stuffMember instanceof Assistant) {
                assistants.add((Assistant) stuffMember);
            }
        }

        return assistants;
    }

    public List<Resident> getResidents() {
        List<Resident> residents = new ArrayList<>();
        for(Stuff stuffMember : stuff) {
            if(stuffMember instanceof Resident) {
                residents.add((Resident) stuffMember);
            }
        }

        return residents;
    }

    public TreeMap<Integer, List<Document>> getPatientDocuments() {
        return patientDocuments;
    }

    public void setPatientDocuments(TreeMap<Integer, List<Document>> patientDocuments) {
        this.patientDocuments = patientDocuments;
    }

    public TreeSet<Stuff> getStuff() {
        return stuff;
    }

    public void setStuff(TreeSet<Stuff> stuff) {
        this.stuff = stuff;
    }

    public TreeSet<Patient> getPatients() {
        return patients;
    }

    public void setPatients(TreeSet<Patient> patients) {
        this.patients = patients;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
