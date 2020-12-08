import java.util.ArrayList;

public class Elevator extends Thread {
    public long ELEVATOR_INTERVAL = 200;
    public String MODE = "idle";
    public int FLOOR = 0;
    public int DESTINATION = 0;
    public String DIRECTION = "up";
    //public int CAPACITY = 10;
    public int COUNT_INSIDE = 0;
    public ArrayList<ArrayList<Integer>> INSIDE = new ArrayList<ArrayList<Integer>>();
    private int ELEVATOR_CAPACITY = 10;

    public void moveElevator() {

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

    }

    public void setMode(String mode) { // setter function
        MODE = mode;
    }

    public void getPassengerLogic(ArrayList<ArrayList<Integer>> queue) { // yolcu alma logic kısmı

        while (COUNT_INSIDE < ELEVATOR_CAPACITY && queue.isEmpty() == false) {

            int capacity = ELEVATOR_CAPACITY - COUNT_INSIDE;
            if (queue.get(0).get(0) > capacity) {
                int tmp = queue.get(0).get(0);
                queue.get(0).set(0, tmp - capacity);

                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(capacity);
                arrayList.add(queue.get(0).get(1));

                App.ALL_QUEUE -= capacity;

                INSIDE.add(arrayList);
                COUNT_INSIDE += capacity;
                removerFromQueue(capacity);

            } else {
                COUNT_INSIDE += queue.get(0).get(0);
                INSIDE.add(queue.get(0));

                App.ALL_QUEUE -= queue.get(0).get(0);
                removerFromQueue(queue.get(0).get(0));

                queue.remove(0);

            }
        }
    }

    public void removerFromQueue(int value) {
        if (FLOOR == 0) {
            App.FLOOR_0_QUEUE_COUNT -= value;

        } else if (FLOOR == 1) {
            App.FLOOR_1_QUEUE_COUNT -= value;

        } else if (FLOOR == 2) {
            App.FLOOR_2_QUEUE_COUNT -= value;

        } else if (FLOOR == 3) {
            App.FLOOR_3_QUEUE_COUNT -= value;

        } else if (FLOOR == 4) {
            App.FLOOR_4_QUEUE_COUNT -= value;

        }
    }

    public void getPassenger() { // yolcu alma fonksiyonu

        if (FLOOR == 0) {
            getPassengerLogic(App.FLOOR_0_QUEUE);

        } else if (FLOOR == 1) {
            getPassengerLogic(App.FLOOR_1_QUEUE);

        } else if (FLOOR == 2) {
            getPassengerLogic(App.FLOOR_2_QUEUE);

        } else if (FLOOR == 3) {
            getPassengerLogic(App.FLOOR_3_QUEUE);

        } else if (FLOOR == 4) {
            getPassengerLogic(App.FLOOR_4_QUEUE);

        }

    }

    public int leavePassengerLogic() { // yolcu indirme logic kısmı
        int value = 0;
        for (int i = 0; i < INSIDE.size(); i++) {
            if (FLOOR == INSIDE.get(i).get(1)) {
                value += INSIDE.get(i).get(0);
                COUNT_INSIDE -= INSIDE.get(i).get(0);

                // App.ALL_QUEUE -= INSIDE.get(i).get(0);

                value += INSIDE.get(i).get(0);

                INSIDE.remove(i);
            }
        }
        return value;
    }

    public void leavePassenger() { // yolcu indirme foknsiyonu
        if (FLOOR == 0) {
            leavePassengerLogic();

        } else if (FLOOR == 1) {
            App.FLOOR_1_ALL = leavePassengerLogic();

        } else if (FLOOR == 2) {
            App.FLOOR_2_ALL = leavePassengerLogic();

        } else if (FLOOR == 3) {
            App.FLOOR_3_ALL = leavePassengerLogic();

        } else if (FLOOR == 4) {
            App.FLOOR_4_ALL = leavePassengerLogic();

        }
    }

    public void runElevator() { // asansörü çalıştırma fonskiyonu
        System.out.println(Thread.currentThread().getName() + " Elevator currentfloor: " + FLOOR);

        leavePassenger(); // yolcu bırak
        getPassenger(); // yolcu al
        moveElevator(); // asansörü sıradaki kata hareket ettir

        System.out.println(Thread.currentThread().getName() + " inside: " + INSIDE);
        System.out.println(Thread.currentThread().getName() + " count inside: " + COUNT_INSIDE);

    }

    @Override
    public void run() {
        while (true) {
            if (MODE == "working") {
                runElevator();
            }
            try {
                Thread.sleep(ELEVATOR_INTERVAL);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
