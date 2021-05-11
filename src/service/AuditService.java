package service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Timestamp;
import java.util.Date;

public class AuditService {
    private static final String DIR_PATH = "D:\\Facultate\\_Informatica\\Anul II - Info\\Semestrul II\\PAO\\Proiect-PAO\\audit\\";
    private static final String FILE_PATH = "log.csv";

    public void logEvent(String actionName) {
        if(!Files.exists(Paths.get(DIR_PATH))) {
            try {
                Files.createDirectories(Paths.get(DIR_PATH));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        if(!Files.exists(Paths.get(DIR_PATH + FILE_PATH))) {
            try {
                Files.createFile(Paths.get(DIR_PATH + FILE_PATH));
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(DIR_PATH + FILE_PATH), StandardOpenOption.APPEND);
                writer.write("Action name,Timestamp\n");
                writer.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(DIR_PATH + FILE_PATH), StandardOpenOption.APPEND);
            Date date = new Date();
            long time = date.getTime();
            Timestamp timestamp = new Timestamp(time);
            writer.write(actionName + "," + timestamp + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
