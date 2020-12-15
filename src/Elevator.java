import java.util.ArrayList;

public class Elevator extends Thread {
    public long ELEVATOR_INTERVAL = 200;
    public String MODE = "idle";
    public int FLOOR = 0;
    public int DESTINATION = 0;
    public String DIRECTION = "up";
    public int COUNT_INSIDE = 0;
    public ArrayList<ArrayList<Integer>> INSIDE = new ArrayList<ArrayList<Integer>>();
    public int ELEVATOR_CAPACITY = 10;

    public void moveElevator() { //asansörü hareket ettirme kısmı

        if (DIRECTION == "up") {
            FLOOR++;
            DESTINATION = FLOOR + 1;
            if (FLOOR == 4) {
                DIRECTION = "down";
                DESTINATION -= 2;
            }
        } else if (DIRECTION == "down") {
            FLOOR--;
            DESTINATION = FLOOR - 1;
            if (FLOOR == 0) {
                DIRECTION = "up";
                DESTINATION += 2;
            }
        }

    }

    public void setMode(String mode) { // setter function
        MODE = mode;
    }

    public ArrayList<ArrayList<Integer>> getPassengerLogic(ArrayList<ArrayList<Integer>> list) { // yolcu alma logic
                                                                                                 // kısmı
        ArrayList<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
        queue = list;

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
        return queue;
    }

    public void removerFromQueue(int value) {
        if (FLOOR == 0) {
            int x = 0;
            for (int i = 0; i < App.FLOOR_0_QUEUE.size(); i++) {
                x += App.FLOOR_0_QUEUE.get(i).get(0);
            }
            App.FLOOR_0_QUEUE_COUNT = x;

        } else if (FLOOR == 1) {
            int x = 0;
            for (int i = 0; i < App.FLOOR_1_QUEUE.size(); i++) {
                x += App.FLOOR_1_QUEUE.get(i).get(i);
            }
            App.FLOOR_1_QUEUE_COUNT = x;

        } else if (FLOOR == 2) {
            int x = 0;
            // App.FLOOR_2_QUEUE_COUNT -= value;
            for (int i = 0; i < App.FLOOR_2_QUEUE.size(); i++) {
                x += App.FLOOR_2_QUEUE.get(i).get(i);
            }
            App.FLOOR_2_QUEUE_COUNT = x;
        } else if (FLOOR == 3) {
            int x = 0;
            for (int i = 0; i < App.FLOOR_3_QUEUE.size(); i++) {
                x += App.FLOOR_3_QUEUE.get(i).get(i);
            }
            App.FLOOR_3_QUEUE_COUNT = x;

        } else if (FLOOR == 4) {
            int x = 0;
            for (int i = 0; i < App.FLOOR_4_QUEUE.size(); i++) {
                x += App.FLOOR_4_QUEUE.get(i).get(i);
            }
            App.FLOOR_4_QUEUE_COUNT = x;

        }
    }

    public void getPassenger() { // yolcu alma fonksiyonu

        if (FLOOR == 0) {
            App.FLOOR_0_QUEUE = getPassengerLogic(App.FLOOR_0_QUEUE);

        } else if (FLOOR == 1) {
            App.FLOOR_1_QUEUE = getPassengerLogic(App.FLOOR_1_QUEUE);

        } else if (FLOOR == 2) {
            App.FLOOR_2_QUEUE = getPassengerLogic(App.FLOOR_2_QUEUE);

        } else if (FLOOR == 3) {
            App.FLOOR_3_QUEUE = getPassengerLogic(App.FLOOR_3_QUEUE);

        } else if (FLOOR == 4) {
            App.FLOOR_4_QUEUE = getPassengerLogic(App.FLOOR_4_QUEUE);

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
        leavePassenger(); // yolcu bırak
        getPassenger(); // yolcu al
        moveElevator(); // asansörü sıradaki kata hareket ettir
    }

    @Override
    public void run() {
        while (true) {

            try {
                if (MODE == "working") {
                    runElevator();
                }
                Thread.sleep(ELEVATOR_INTERVAL);
            } catch (Exception e) {
                // e.printStackTrace();
            }
        }
    }
}
