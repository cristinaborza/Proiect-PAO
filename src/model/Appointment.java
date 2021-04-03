package model;

import java.util.Scanner;

public abstract class Appointment {
    private int id;
    private String date;
    private Patient patient;
    private Doctor doctor;
    private int price;

    public Appointment() { }
    public Appointment(int id, String date, Patient patient, Doctor doctor, int price) {
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
