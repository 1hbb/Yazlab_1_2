import java.util.ArrayList;

public class Elevator extends Thread {
    private long ELEVATOR_INTERVAL = 200;
    public static String MODE = "working";
    public static int FLOOR = 0;
    public static int DESTINATION = 0;
    public static String DIRECTION = "up";
    public static int CAPACITY = 10;
    public static int COUNT_INSIDE = 0;
    public static ArrayList<ArrayList<Integer>> INSIDE;

    public void runElevator() {

        if (DIRECTION == "up") {
            FLOOR++;
            if (FLOOR == 4) {
                DIRECTION = "down";
            }
        } else if (DIRECTION == "down") {
            FLOOR--;
            if (FLOOR == 0) {
                DIRECTION = "up";
            }
        }
        System.out.println("Elevator current floor: " + FLOOR);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(ELEVATOR_INTERVAL);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Running Thread Name:" + Thread.currentThread().getName());
            runElevator();
        }
    }
}
