package repository;

import model.Assistant;
import model.Doctor;
import model.Patient;
import model.Resident;
import utils.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import static utils.Queries.*;

public class CabinetRepository {
    private final DbConnection dbConnection = DbConnection.getInstance();

    public List<Patient> retrieveAllPatients() {
        List<Patient> patients = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(RETRIEVE_ALL_PATIENT_DISEASES);
            ResultSet resultSet = preparedStatement.executeQuery();

            HashMap<Integer, Patient> mp = new HashMap<>();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                List<String> diseases = new ArrayList<>();
                if(mp.containsKey(id)) {
                    diseases = mp.get(id).getDiseases();
                }

                diseases.add(resultSet.getString(11));
                mp.put(id, new Patient(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), diseases));
            }

            patients.addAll(mp.values());
        } catch(SQLException exception) {
            exception.printStackTrace();
        }

        return patients;
    }

    public List<Doctor> retrieveAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(RETRIEVE_ALL_DOCTORS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Doctor doctor = new Doctor(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getString(10));
                doctors.add(doctor);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return doctors;
    }

    public List<Resident> retrieveAllResidents() {
        List<Resident> residents = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(RETRIEVE_ALL_RESIDENTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Resident resident = new Resident(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getDate(10).toLocalDate());
                residents.add(resident);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return residents;
    }

    public List<Assistant> retrieveAllAssistants() {
        List<Assistant> assistants = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(RETRIEVE_ALL_ASSISTANTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Assistant assistant = new Assistant(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getString(10));
                assistants.add(assistant);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return assistants;
    }

    public int addNewDoctor(Doctor doctor) {
        ResultSet resultSet;
        try {
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_DOCTOR, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, doctor.getFirstName());
            preparedStatement.setString(2, doctor.getLastName());
            preparedStatement.setInt(3, doctor.getAge());
            preparedStatement.setString(4, doctor.getEmail());
            preparedStatement.setString(5, doctor.getPhone());
            preparedStatement.setString(6, doctor.getSex());
            preparedStatement.setInt(7, doctor.getSalary());
            preparedStatement.setInt(8, doctor.getExperience());
            preparedStatement.setString(9, doctor.getSpecialization());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            return Integer.parseInt(resultSet.getString(1));
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem occurred during adding doctor");
        }
    }

    public int addNewAssistant(Assistant assistant) {
        ResultSet resultSet;
        try {
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_ASSISTANT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, assistant.getFirstName());
            preparedStatement.setString(2, assistant.getLastName());
            preparedStatement.setInt(3, assistant.getAge());
            preparedStatement.setString(4, assistant.getEmail());
            preparedStatement.setString(5, assistant.getPhone());
            preparedStatement.setString(6, assistant.getSex());
            preparedStatement.setInt(7, assistant.getSalary());
            preparedStatement.setInt(8, assistant.getExperience());
            preparedStatement.setString(9, assistant.getStudies());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            return Integer.parseInt(resultSet.getString(1));
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem occurred during adding assistant");
        }
    }

    public int addNewResident(Resident resident) {
        ResultSet resultSet;
        try {
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_RESIDENT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, resident.getFirstName());
            preparedStatement.setString(2, resident.getLastName());
            preparedStatement.setInt(3, resident.getAge());
            preparedStatement.setString(4, resident.getEmail());
            preparedStatement.setString(5, resident.getPhone());
            preparedStatement.setString(6, resident.getSex());
            preparedStatement.setInt(7, resident.getSalary());
            preparedStatement.setInt(8, resident.getExperience());
            preparedStatement.setDate(9, Date.valueOf(resident.getGraduationDate()));
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            return Integer.parseInt(resultSet.getString(1));
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem occurred during adding resident");
        }
    }

    public void updateDoctor(Doctor doctor, int id) {
        try {
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(UPDATE_DOCTOR);
            preparedStatement.setString(1, doctor.getFirstName());
            preparedStatement.setString(2, doctor.getLastName());
            preparedStatement.setInt(3, doctor.getAge());
            preparedStatement.setString(4, doctor.getEmail());
            preparedStatement.setString(5, doctor.getPhone());
            preparedStatement.setString(6, doctor.getSex());
            preparedStatement.setInt(7, doctor.getSalary());
            preparedStatement.setInt(8, doctor.getExperience());
            preparedStatement.setString(9, doctor.getSpecialization());
            preparedStatement.setInt(10, id);
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem occurred during updating a doctor");
        }
    }

    public void updateAssistant(Assistant assistant, int id) {
        try {
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(UPDATE_ASSISTANT);
            preparedStatement.setString(1, assistant.getFirstName());
            preparedStatement.setString(2, assistant.getLastName());
            preparedStatement.setInt(3, assistant.getAge());
            preparedStatement.setString(4, assistant.getEmail());
            preparedStatement.setString(5, assistant.getPhone());
            preparedStatement.setString(6, assistant.getSex());
            preparedStatement.setInt(7, assistant.getSalary());
            preparedStatement.setInt(8, assistant.getExperience());
            preparedStatement.setString(9, assistant.getStudies());
            preparedStatement.setInt(10, id);
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem occurred during updating a assistant");
        }
    }

    public void updateResident(Resident resident, int id) {
        try {
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(UPDATE_RESIDENT);
            preparedStatement.setString(1, resident.getFirstName());
            preparedStatement.setString(2, resident.getLastName());
            preparedStatement.setInt(3, resident.getAge());
            preparedStatement.setString(4, resident.getEmail());
            preparedStatement.setString(5, resident.getPhone());
            preparedStatement.setString(6, resident.getSex());
            preparedStatement.setInt(7, resident.getSalary());
            preparedStatement.setInt(8, resident.getExperience());
            preparedStatement.setDate(9, Date.valueOf(resident.getGraduationDate()));
            preparedStatement.setInt(10, id);
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem occurred during updating a assistant");
        }
    }
}
