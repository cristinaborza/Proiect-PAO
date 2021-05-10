package service;

import model.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderService {
    private static final String DIR_PATH = "D:\\Facultate\\_Informatica\\Anul II - Info\\Semestrul II\\PAO\\Proiect-PAO\\data\\";

    private FileReaderService() { }

    private static class SingletonHelper {
        private static final FileReaderService INSTANCE = new FileReaderService();
    }

    public static FileReaderService getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void readDoctors(String FILE_PATH, CabinetService cabinetService) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(DIR_PATH + FILE_PATH));
            String line = reader.readLine();
            while((line = reader.readLine()) != null) {
                String[] dataLine = line.split(",");

                //read the data
                String cnp = dataLine[0];
                String firstName = dataLine[1];
                String lastName = dataLine[2];
                int age = Integer.parseInt(dataLine[3]);
                String email = dataLine[4];
                String phone = dataLine[5];
                boolean sex = dataLine[6].equals("F");
                int salary = Integer.parseInt(dataLine[7]);
                int experience = Integer.parseInt(dataLine[8]);
                String specialization = dataLine[9];

                //add the doctors to the cabinet
                Doctor doctor = new Doctor(cnp, firstName, lastName, age, email, phone, sex, salary, experience, specialization);
                cabinetService.addStuff(doctor);
            }
        } catch (NoSuchFileException e) {
            System.out.println("The file with the name " + FILE_PATH + " doesn't exist.");
        } catch (IOException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }

    public void readAssistants(String FILE_PATH, CabinetService cabinetService) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(DIR_PATH + FILE_PATH));
            String line = reader.readLine();
            while((line = reader.readLine()) != null) {
                String[] dataLine = line.split(",");

                //read the data
                String cnp = dataLine[0];
                String firstName = dataLine[1];
                String lastName = dataLine[2];
                int age = Integer.parseInt(dataLine[3]);
                String email = dataLine[4];
                String phone = dataLine[5];
                boolean sex = dataLine[6].equals("F");
                int salary = Integer.parseInt(dataLine[7]);
                int experience = Integer.parseInt(dataLine[8]);
                boolean studies = dataLine[9].equals("T");

                //add the assistants to the cabinet
                Assistant assistant = new Assistant(cnp, firstName, lastName, age, email, phone, sex, salary, experience, studies);
                cabinetService.addStuff(assistant);
            }
        } catch (NoSuchFileException e) {
            System.out.println("The file with the name " + FILE_PATH + " doesn't exist.");
        } catch (IOException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }

    public void readResidents(String FILE_PATH, CabinetService cabinetService) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(DIR_PATH + FILE_PATH));
            String line = reader.readLine();
            while((line = reader.readLine()) != null) {
                String[] dataLine = line.split(",");

                //read the data
                String cnp = dataLine[0];
                String firstName = dataLine[1];
                String lastName = dataLine[2];
                int age = Integer.parseInt(dataLine[3]);
                String email = dataLine[4];
                String phone = dataLine[5];
                boolean sex = dataLine[6].equals("F");
                int salary = Integer.parseInt(dataLine[7]);
                int experience = Integer.parseInt(dataLine[8]);
                int expectedGraduation = Integer.parseInt(dataLine[9]);

                //add the residents to the cabinet
                Resident resident = new Resident(cnp, firstName, lastName, age, email, phone, sex, salary, experience, expectedGraduation);
                cabinetService.addStuff(resident);
            }
        } catch (NoSuchFileException e) {
            System.out.println("The file with the name " + FILE_PATH + " doesn't exist.");
        } catch (IOException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }

    public void readPatients(String FILE_PATH, CabinetService cabinetService) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(DIR_PATH + FILE_PATH));
            String line = reader.readLine();
            while((line = reader.readLine()) != null) {
                String[] dataLine = line.split(",");

                //read the data
                String cnp = dataLine[0];
                String firstName = dataLine[1];
                String lastName = dataLine[2];
                int age = Integer.parseInt(dataLine[3]);
                String email = dataLine[4];
                String phone = dataLine[5];
                boolean sex = dataLine[6].equals("F");
                List<String> diseases = new ArrayList<>();

                //add the patients to the cabinet
                Patient patient = new Patient(cnp, firstName, lastName, age, email, phone, sex, diseases);
                cabinetService.addPatient(patient);
            }
        } catch (NoSuchFileException e) {
            System.out.println("The file with the name " + FILE_PATH + " doesn't exist.");
        } catch (IOException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }
}
