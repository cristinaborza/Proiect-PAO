package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Surgery extends Appointment{
    private int time;
    private List<Assistant> assistants = new ArrayList<>();

    public  Surgery() {
        super();
    }
    public Surgery(LocalDate date, int id, Patient patient, Doctor doctor, int price, int time, List<Assistant> assistants) {
        super(id, date, patient, doctor, price);
        this.time = time;
        this.assistants = assistants;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<Assistant> getAssistants() {
        return assistants;
    }

    public void setAssistants(List<Assistant> assistants) {
        this.assistants = assistants;
    }

    @Override
    public String toString() {
        return "Tip programare: Operatie" +
                super.toString() +
                "Timp operatie: " + time + '\n';
    }
}
