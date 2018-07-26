package JavaTinkering.hsszyman.com.github.Streams;


import java.io.*;
import java.util.ArrayList;

public class OldStreamIOClassPractice {
    File file;
    public OldStreamIOClassPractice(File file) {
        this.file = file;
    }

    public void writeStringsToFile(String... strings) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String str : strings) {
                writer.write(str);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void appendStringsToFile(ArrayList<String> strings) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (String str : strings) {
                writer.write(str);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return : Array of strings from the file seperated by a newline
     */
    public ArrayList<String> readStringsFromFile() {
        ArrayList<String> fileContents = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            fileContents = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                fileContents.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return fileContents;
    }
}
