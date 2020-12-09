import java.util.ArrayList;

public class LoginThread extends Thread {
    private long LOGIN_INTERVAL = 500;

    public void calculateAllQueue() {
        App.ALL_QUEUE = App.FLOOR_0_QUEUE_COUNT + App.FLOOR_1_QUEUE_COUNT + App.FLOOR_2_QUEUE_COUNT
                + App.FLOOR_3_QUEUE_COUNT + App.FLOOR_4_QUEUE_COUNT;

    }

    public void addCustomer() {
        int floor = (int) (Math.random() * 4) + 1;
        int customer = (int) (Math.random() * 20) + 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(customer);
        list.add(floor);

        App.FLOOR_0_QUEUE.add(list);

        App.ALL_QUEUE += customer;
        App.FLOOR_0_QUEUE_COUNT += customer;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                Thread.sleep(LOGIN_INTERVAL);
            } catch (Exception e) {
                e.printStackTrace();
            }
            addCustomer();
            calculateAllQueue();
        }
    }
}
