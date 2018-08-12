import JavaTinkering.hsszyman.com.github.List.List;

/**
 * Simple exercise i'm doing to practice linked list surgery and linked list collections
 */
public class Driver {
    public static void main(String[] args) {
        List<Integer> list1 = new List<>();
        list1.addSet(1,2,3);
        list1.add(4);
        list1.printAll();
    }
}

