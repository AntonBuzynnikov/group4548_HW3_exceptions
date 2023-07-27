package homework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveEntry {

    public static void save(Entry entry){
        try(FileWriter writer = new FileWriter(entry.getLastName(), true)) {
            writer.write(entry.toString() +"\n");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
