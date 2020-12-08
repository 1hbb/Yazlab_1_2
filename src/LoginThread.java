import java.util.ArrayList;

public class LoginThread extends Thread {
    private long LOGIN_INTERVAL = 500;

    public void addCustomer() {
        int floor = (int) (Math.random() * 4) + 1;
        int customer = (int) (Math.random() * 10) + 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(customer);
        list.add(floor);

        App.FLOOR_0_QUEUE.add(list);

        //App.ALL_QUEUE += customer;
        App.FLOOR_0_QUEUE_COUNT += customer;

        System.out.println("All queue count: " + App.ALL_QUEUE);
        System.out.println("0. floor: queue: " + App.FLOOR_0_QUEUE_COUNT);
        System.out.println("1. floor:" + "all:" + App.FLOOR_1_ALL + " queue: " + App.FLOOR_1_QUEUE_COUNT);
        System.out.println("2. floor:" + "all:" + App.FLOOR_2_ALL + " queue: " + App.FLOOR_2_QUEUE_COUNT);
        System.out.println("3. floor:" + "all:" + App.FLOOR_3_ALL + " queue: " + App.FLOOR_3_QUEUE_COUNT);
        System.out.println("4. floor:" + "all:" + App.FLOOR_4_ALL + " queue: " + App.FLOOR_4_QUEUE_COUNT);

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
        }
    }
}
