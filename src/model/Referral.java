package model;

import java.time.LocalDate;

public class Referral extends Document{
    private Doctor doctorRef;

    public Referral(LocalDate date, Doctor doctor, Patient patient, Doctor doctorRef) {
        super(date, doctor, patient);
        this.doctorRef = doctorRef;
    }

    public Doctor getDoctorRef() {
        return doctorRef;
    }

    public void setDoctorRef(Doctor doctorRef) {
        this.doctorRef = doctorRef;
    }
}
