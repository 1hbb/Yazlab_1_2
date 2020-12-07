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
        System.out.println("Floor 0 queue: " + App.FLOOR_0_QUEUE);

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
            System.out.println("Running Thread Name:" + Thread.currentThread().getName());
            addCustomer();
        }
    }
}
