package Model;

import java.util.List;

public class Clinic {
    private String location;
    private List<Stuff> stuff;
    private List<Patient> patients;
    private List<Appointment> appointments;

    public Clinic(String location, List<Stuff> stuff, List<Patient> patients, List<Appointment> appointments) {
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

    public List<Stuff> getStuff() {
        return stuff;
    }

    public void setStuff(List<Stuff> stuff) {
        this.stuff = stuff;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
