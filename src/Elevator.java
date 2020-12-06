import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Elevator extends Thread {

    public static String MODE = "working";
    public static int FLOOR = 0;
    public static int DESTINATION = 0;
    public static String DIRECTION = "up";
    public static int CAPACITY = 10;
    public static int COUNT_INSIDE = 0;
    public static ArrayList<ArrayList<Integer>> INSIDE = new ArrayList<ArrayList<Integer>>();

    public void sort(ArrayList<ArrayList<Integer>> INSIDE) {
        Collections.sort(INSIDE, new Comparator<ArrayList<Integer>>() {

            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(1).compareTo(o2.get(1));
            }
        });
    }

    @Override
    public void run() {
        super.run();
    }
}
