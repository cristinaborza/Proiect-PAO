package Model;

public abstract class Appointment {
    private String date;
    private Patient patient;
    private Doctor doctor;
    private int price;

    public Appointment(String date, Patient patient, Doctor doctor, int price) {
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
