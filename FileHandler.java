import java.io.*;
import java.util.*;

public class FileHandler {

    public static void saveToFile(ArrayList<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            for (Student s : students) {
                writer.write(s.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    public static ArrayList<Student> loadFromFile() {
        ArrayList<Student> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                list.add(new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        data[3]
                ));
            }
        } catch (IOException e) {
            System.out.println("No previous data found.");
        }
        return list;
    }
}