package service;

import model.*;

import java.util.*;

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

    public void printPatients() {
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

    public Patient searchPatient(String cnp) {
        TreeSet<Patient> patients = clinic.getPatients();
        Iterator<Patient> it = patients.iterator();
        while(it.hasNext()) {
            Patient currentPatient = it.next();
            if(cnp.equals(currentPatient.getCnp())) {
                return currentPatient;
            }
        }

        return new Patient();
    }

    public void updatePatient(String cnp, String firstName, String lastName, int age, String email, String phone, boolean sex) {
        Patient patient = searchPatient(cnp);
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setAge(age);
    }
}
