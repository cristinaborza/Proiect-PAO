package model;

public class Referral extends Document{
    private Doctor doctorRef;

    public Referral(String date, Doctor doctor, Patient patient, Doctor doctorRef) {
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
