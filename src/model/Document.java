package model;

public abstract class Document {
    private String date;
    private Doctor doctor;
    private Patient patient;

    public Document() { };
    public Document(String date, Doctor doctor, Patient patient) {
        this.date = date;
        this.doctor = doctor;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
