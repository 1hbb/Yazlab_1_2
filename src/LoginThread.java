import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LoginThread extends Thread {
    private long LOGIN_INTERVAL = 500;

    public void addCustomer() {
        int floor = (int) (Math.random() * 4) + 1;
        int customer = (int) (Math.random() * 10) + 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(customer);
        list.add(floor);

        App.FLOOR_0_QUEUE.add(list);
        System.out.println(App.FLOOR_0_QUEUE);
        ArrayList<ArrayList<Integer>> test = new ArrayList<ArrayList<Integer>>();
        test = App.FLOOR_0_QUEUE;

        Collections.sort(test, new Comparator<ArrayList<Integer>>() {

            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(1).compareTo(o2.get(1));
            }
            //
        });

        System.out.println("Sorted" + test);

    }

    @Override
    public void run() {
        super.run();
        while (true) {
            System.out.println("Running Thread Name:" + Thread.currentThread().getName());
            addCustomer();
            try {
                Thread.sleep(LOGIN_INTERVAL);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
