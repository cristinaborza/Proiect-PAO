package model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Cabinet {
    private String location;
    private List<Appointment> appointments = new ArrayList<>();
    private TreeMap<Integer, List<Document>> patientDocuments = new TreeMap<>();

    public Cabinet() { }
    public Cabinet(String location, List<Appointment> appointments, TreeMap<Integer, List<Document>> patientDocuments) {
        this.location = location;
        this.appointments = appointments;
        this.patientDocuments = patientDocuments;
    }

    public TreeMap<Integer, List<Document>> getPatientDocuments() {
        return patientDocuments;
    }

    public void setPatientDocuments(TreeMap<Integer, List<Document>> patientDocuments) {
        this.patientDocuments = patientDocuments;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
