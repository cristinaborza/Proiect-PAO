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
    private TreeMap<String, List<Document>> patientDocuments = new TreeMap<>();

    public Cabinet() { }
    public Cabinet(String location, TreeSet<Stuff> stuff, TreeSet<Patient> patients, List<Appointment> appointments, TreeMap<String, List<Document>> patientDocuments) {
        this.location = location;
        this.stuff = stuff;
        this.patients = patients;
        this.appointments = appointments;
        this.patientDocuments = patientDocuments;
    }

    public TreeMap<String, List<Document>> getPatientDocuments() {
        return patientDocuments;
    }

    public void setPatientDocuments(TreeMap<String, List<Document>> patientDocuments) {
        this.patientDocuments = patientDocuments;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
