package model;

import java.time.LocalDate;

public abstract class Appointment {
    private int id;
    private LocalDate date;
    private Patient patient;
    private Doctor doctor;
    private int price;

    public Appointment() { }
    public Appointment(int id, LocalDate date, Patient patient, Doctor doctor, int price) {
        this.id = id;
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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

    @Override
    public String toString() {
        return  "Data: '" + date + '\n' +
                "Nume pacient: " + patient.getLastName() + '\n' +
                "Prenume pacient: " + patient.getFirstName() + '\n' +
                "Nume doctor" + doctor.getLastName() + '\n' +
                "Prenume doctor: " + doctor.getFirstName() + '\n'+
                "Pret: " + price + '\n';
    }
}
