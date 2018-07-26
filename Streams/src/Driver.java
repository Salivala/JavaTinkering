import JavaTinkering.hsszyman.com.github.Streams.OldStreamIOClassPractice;

import java.io.*;

public class Driver {
    public static void main(String[] args) {
        OldStreamIOClassPractice oldStream = new OldStreamIOClassPractice(new File("./src/wow.txt"));
        String[] strs = {
                "this is kinda like json, but not really",
                "I like beans",
                "But a lot of beans have high sodium",
                "well.... not the beans themselves,",
                "But if you buy the beans in a can with syrup,",
                "depending on the can, it might have shockingly",
                "high sodium and sugar!"
        };
        oldStream.writeStringsToFile(strs);
        for (String k : oldStream.readStringsFromFile()) {
            System.out.println(k);
        }
        test();
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
