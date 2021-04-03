package service;

import model.*;

import java.util.*;

public class ClinicService {
    private final Clinic clinic;

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

    public Stuff searchStuff(String cnp) {
        TreeSet<Stuff> stuff = clinic.getStuff();
        for(Stuff currentStuff : stuff) {
            if(cnp.equals(currentStuff.getCnp())) {
                return currentStuff;
            }
        }

        return new Doctor();
    }

    public void deleteStuff(String cnp) {
        Stuff stuffMember = searchStuff(cnp);
        TreeSet<Stuff> stuff = clinic.getStuff();
        stuff.remove(stuffMember);
        clinic.setStuff(stuff);
    }

    public Doctor searchDoctor(String cnp) {
        TreeSet<Stuff> stuff = clinic.getStuff();
        for(Stuff currentStuff : stuff) {
            if(cnp.equals(currentStuff.getCnp()) && currentStuff instanceof Doctor) {
                return (Doctor) currentStuff;
            }
        }

        return new Doctor();
    }

    public void updateDoctor(String cnp, String firstName, String lastName, int age, String email, String phone, boolean sex, int salary, String specialization) {
        TreeSet<Stuff> stuff = clinic.getStuff();
        Doctor doctor = searchDoctor(cnp);
        stuff.remove(doctor);

        doctor.setFirstName(firstName);
        doctor.setLastName(lastName);
        doctor.setAge(age);
        doctor.setEmail(email);
        doctor.setPhone(phone);
        doctor.setSex(sex);
        doctor.setSalary(salary);
        doctor.setSpecialization(specialization);

        stuff.add(doctor);
        clinic.setStuff(stuff);
    }

    public Assistant searchAssistant(String cnp) {
        TreeSet<Stuff> stuff = clinic.getStuff();
        for(Stuff currentStuff : stuff) {
            if(cnp.equals(currentStuff.getCnp()) && currentStuff instanceof Assistant) {
                return (Assistant) currentStuff;
            }
        }

        return new Assistant();
    }

    public void updateAssistant(String cnp, String firstName, String lastName, int age, String email, String phone, boolean sex, int salary, boolean haveSuperiorStudies) {
        TreeSet<Stuff> stuff = clinic.getStuff();
        Assistant assistant = searchAssistant(cnp);
        stuff.remove(assistant);

        assistant.setFirstName(firstName);
        assistant.setLastName(lastName);
        assistant.setAge(age);
        assistant.setEmail(email);
        assistant.setPhone(phone);
        assistant.setSex(sex);
        assistant.setSalary(salary);
        assistant.setHaveSuperiorStudies(haveSuperiorStudies);

        stuff.add(assistant);
        clinic.setStuff(stuff);
    }

    public Resident searchResident(String cnp) {
        TreeSet<Stuff> stuff = clinic.getStuff();
        for(Stuff currentStuff : stuff) {
            if(cnp.equals(currentStuff.getCnp()) && currentStuff instanceof Resident) {
                return (Resident) currentStuff;
            }
        }

        return new Resident();
    }

    public void updateResident(String cnp, String firstName, String lastName, int age, String email, String phone, boolean sex, int salary, int expectedGraduation) {
        TreeSet<Stuff> stuff = clinic.getStuff();
        Resident resident = searchResident(cnp);
        stuff.remove(resident);

        resident.setFirstName(firstName);
        resident.setLastName(lastName);
        resident.setAge(age);
        resident.setEmail(email);
        resident.setPhone(phone);
        resident.setSex(sex);
        resident.setSalary(salary);
        resident.setExpectedGraduation(expectedGraduation);

        stuff.add(resident);
        clinic.setStuff(stuff);
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

    public Patient searchPatient(String cnp) {
        TreeSet<Patient> patients = clinic.getPatients();
        for(Patient currentPatient : patients) {
            if(cnp.equals(currentPatient.getCnp())) {
                return currentPatient;
            }
        }

        return new Patient();
    }

    public void deletePatient(String cnp) {
        Patient patient = searchPatient(cnp);
        TreeSet<Patient> patients = clinic.getPatients();
        patients.remove(patient);
        clinic.setPatients(patients);
    }

    public void updatePatient(String cnp, String firstName, String lastName, int age, String email, String phone, boolean sex) {
        TreeSet<Patient> patients = clinic.getPatients();
        Patient patient = searchPatient(cnp);
        patients.remove(patient);

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setAge(age);
        patient.setEmail(email);
        patient.setPhone(phone);
        patient.setSex(sex);

        patients.add(patient);
        clinic.setPatients(patients);
    }

    public void deleteAppointment(int id) {
        List<Appointment> appointments = clinic.getAppointments();
        for(Appointment appointment : appointments) {
            if(appointment.getId() == id) {
                appointments.remove(appointment);
                clinic.setAppointments(appointments);
                return;
            }
        }
    }

    public void addAppointment(Appointment appointment) {
        List<Appointment> appointments = clinic.getAppointments();
        appointments.add(appointment);
        clinic.setAppointments(appointments);
    }

    public void printAppointments() {
        List<Appointment> appointments = clinic.getAppointments();
        for(Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }
}
