package service;

import model.*;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class ClinicService {
    private Clinic clinic;

    public ClinicService(Clinic clinic) {
        this.clinic = clinic;
    }

    public void addStuff(Stuff stuffMember) {
        TreeSet<Stuff> stuff = clinic.getStuff();
        stuff.add(stuffMember);
        clinic.setStuff(stuff);
    }

    public void printStuff() {
        TreeSet<Stuff> stuff = clinic.getStuff();
        for(Stuff temp : stuff) {
            System.out.println(temp);
        }
    }

    public void addPatient(Patient patient) {
        TreeSet<Patient> patients = clinic.getPatients();
        patients.add(patient);
        clinic.setPatients(patients);
    }

    public void printPatient() {
        TreeSet<Patient> patients = clinic.getPatients();
        for(Patient temp : patients) {
            System.out.println(temp);
        }
    }

    public void addAppointment(Appointment appointment) {
        List<Appointment> appointments = clinic.getAppointments();
        appointments.add(appointment);
        clinic.setAppointments(appointments);
    }
}
