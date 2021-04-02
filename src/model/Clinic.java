package model;

import com.sun.jdi.event.ClassUnloadEvent;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class Clinic {
    private String location;
    private TreeSet<Stuff> stuff;
    private TreeSet<Patient> patients;
    private List<Appointment> appointments;

    public Clinic() {
        location = "";
        stuff = new TreeSet();
        patients = new TreeSet();
        appointments = new ArrayList<>();
    }

    public Clinic(String location, TreeSet<Stuff> stuff, TreeSet<Patient> patients, List<Appointment> appointments) {
        this.location = location;
        this.stuff = stuff;
        this.patients = patients;
        this.appointments = appointments;
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
