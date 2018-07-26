import JavaTinkering.hsszyman.com.github.Streams.OldStreamIOClassPractice;

import java.io.File;

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
    }
}
