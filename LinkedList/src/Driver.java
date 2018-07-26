import JavaTinkering.hsszyman.com.github.List.List;

/**
 * Simple exercise i'm doing to practice linked list surgery and linked list collections
 */
public class Driver {
    public static void main(String[] args) {
        List<Integer> list1 = new List<>();
        List<Integer> list2 = new List<>();
        list1.addSet(1,2,3);
        list2.addSet(4,5,6);
        list1.concatList(list2);
        list2.concatList(list1);
        list2.printAll();
    }
}

