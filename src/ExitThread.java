import java.util.ArrayList;

public class ExitThread extends Thread {

    private long EXIT_INTERVAL = 1000;

    public void addToQueue() {
        int floor = (int) (Math.random() * 4) + 1;
        int customer = (int) (Math.random() * 5) + 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(customer);
        list.add(0);

        if (floor == 1) {
            App.FLOOR_1_QUEUE.add(list);
        } else if (floor == 2) {
            App.FLOOR_2_QUEUE.add(list);
        } else if (floor == 3) {
            App.FLOOR_3_QUEUE.add(list);
        } else if (floor == 4) {
            App.FLOOR_4_QUEUE.add(list);
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(EXIT_INTERVAL);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
}
