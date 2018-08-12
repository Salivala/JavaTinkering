import JavaTinkering.hsszyman.com.github.Streams.newFileStreamStuff.StreamPractice;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message;
        while (!(message = scan.nextLine()).equals("end") ) {
            writeFile(message);
        }
    }


    public static void writeFile(String message) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("./src/playingAround.txt"), StandardOpenOption.APPEND) ) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test() {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("./src/wow.txt"))) {
            int length;
            byte[] bytes = new byte[3];
            while ((length = bufferedInputStream.read(bytes)) >= 0) {
                for (int i = 0; i < length ; i++) {
                    System.out.print((char) bytes[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
