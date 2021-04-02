package main;

import model.*;
import service.*;

public class Main {
    public static void main(String args[]){
        Clinic clinic = new Clinic();
        ClinicService clinicService = new ClinicService(clinic);

        Doctor doctor1 = new Doctor("Vasile", "Ionel", 32, "qwqw", "03918", true, 2000, 10, "Chirugie");
        Doctor doctor2 = new Doctor("Gigel", "Popescu", 32, "qwqw", "03918", true, 2000, 10, "ORL");
        clinicService.addStuff(doctor1);
        clinicService.addStuff(doctor2);
        clinicService.printStuff();
    }
}
