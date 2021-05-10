package service;

import model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

public class FileWriterService {
    private static final String DIR_PATH = "D:\\Facultate\\_Informatica\\Anul II - Info\\Semestrul II\\PAO\\Proiect-PAO\\data\\";

    private FileWriterService() { }

    private static class SingletonHelper {
        private static final FileWriterService INSTANCE = new FileWriterService();
    }

    public static FileWriterService getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void writeDoctors(String FILE_PATH, List<Doctor> doctors) {
        File file = new File(DIR_PATH + FILE_PATH);

        try {
            FileWriter output = new FileWriter(file);

            String[] header = {"CNP", "First Name", "Last Name", "Age", "Email", "Phone", "Sex", "Salary", "Experience", "Specialization"};
            output.append(String.join(",", header));
            output.append("\n");

            for(Doctor doctor : doctors) {
                String[] line = {doctor.getCnp(), doctor.getFirstName(), doctor.getLastName(), String.valueOf(doctor.getAge()), doctor.getEmail(), doctor.getPhone(), String.valueOf(doctor.getSex()), String.valueOf(doctor.getSalary()), String.valueOf(doctor.getExperience()), doctor.getSpecialization()};
                output.append(String.join(",", line));
                output.append("\n");
            }

            output.flush();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeAssistants(String FILE_PATH, List<Assistant> assistants) {
        File file = new File(DIR_PATH + FILE_PATH);

        try {
            FileWriter output = new FileWriter(file);

            String[] header = {"CNP", "First Name", "Last Name", "Age", "Email", "Phone", "Sex", "Salary", "Experience", "Have superior studies"};
            output.append(String.join(",", header));
            output.append("\n");

            for(Assistant assistant : assistants) {
                String[] line = {assistant.getCnp(), assistant.getFirstName(), assistant.getLastName(), String.valueOf(assistant.getAge()), assistant.getEmail(), assistant.getPhone(), String.valueOf(assistant.getSex()), String.valueOf(assistant.getSalary()), String.valueOf(assistant.getExperience()), String.valueOf(assistant.getHaveSuperiorStudies())};
                output.append(String.join(",", line));
                output.append("\n");
            }

            output.flush();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeResidents(String FILE_PATH, List<Resident> residents) {
        File file = new File(DIR_PATH + FILE_PATH);

        try {
            FileWriter output = new FileWriter(file);

            String[] header = {"CNP", "First Name", "Last Name", "Age", "Email", "Phone", "Sex", "Salary", "Experience", "Years to Graduation"};
            output.append(String.join(",", header));
            output.append("\n");

            for(Resident resident : residents) {
                String[] line = {resident.getCnp(), resident.getFirstName(), resident.getLastName(), String.valueOf(resident.getAge()), resident.getEmail(), resident.getPhone(), String.valueOf(resident.getSex()), String.valueOf(resident.getSalary()), String.valueOf(resident.getExperience()), String.valueOf(resident.getExpectedGraduation())};
                output.append(String.join(",", line));
                output.append("\n");
            }

            output.flush();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writePatients(String FILE_PATH, TreeSet<Patient> patients) {
        File file = new File(DIR_PATH + FILE_PATH);

        try {
            FileWriter output = new FileWriter(file);

            String[] header = {"CNP", "First Name", "Last Name", "Age", "Email", "Phone", "Sex", "Number of diseases"};
            output.append(String.join(",", header));
            output.append("\n");

            for(Patient patient : patients) {
                String[] line = {patient.getCnp(), patient.getFirstName(), patient.getLastName(), String.valueOf(patient.getAge()), patient.getEmail(), patient.getPhone(), String.valueOf(patient.getSex()), String.valueOf(patient.getDiseases().size())};
                output.append(String.join(",", line));
                output.append("\n");
            }

            output.flush();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
