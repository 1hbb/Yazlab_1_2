public class ControlThread extends Thread {
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String RESET_COLOR = "\033[0m";

    public void printFloorInfos() {
        System.out.println("All queue count: " + App.ALL_QUEUE);
        System.out.println("0. floor: queue: " + App.FLOOR_0_QUEUE_COUNT + " array: " + App.FLOOR_0_QUEUE);
        System.out.println("1. floor:" + "all:" + App.FLOOR_1_ALL + " queue: " + App.FLOOR_1_QUEUE_COUNT + " array: "
                + App.FLOOR_1_QUEUE);
        System.out.println("2. floor:" + "all:" + App.FLOOR_2_ALL + " queue: " + App.FLOOR_2_QUEUE_COUNT + " array: "
                + App.FLOOR_2_QUEUE);
        System.out.println("3. floor:" + "all:" + App.FLOOR_3_ALL + " queue: " + App.FLOOR_3_QUEUE_COUNT + " array: "
                + App.FLOOR_3_QUEUE);
        System.out.println("4. floor:" + "all:" + App.FLOOR_4_ALL + " queue: " + App.FLOOR_4_QUEUE_COUNT + " array: "
                + App.FLOOR_4_QUEUE);
        System.out.println();

    }

    public void printElevatorInfos(Elevator elevator) {
        if (elevator.MODE == "working") {
            System.out.println(ANSI_GREEN_BACKGROUND + "mode: " + elevator.MODE + RESET_COLOR);
        } else {
            System.out.println(ANSI_RED_BACKGROUND + "mode: " + elevator.MODE + RESET_COLOR);
        }
        System.out.println("floor: " + elevator.FLOOR);
        System.out.println("destination: " + elevator.DESTINATION);
        System.out.println("direction: " + elevator.DIRECTION);
        System.out.println("capacity: " + elevator.ELEVATOR_CAPACITY);
        System.out.println("count inside: " + elevator.COUNT_INSIDE);
        System.out.println("inside: " + elevator.INSIDE);
        System.out.println(RESET_COLOR);
    }

    @Override
    public void run() {
        Elevator elevator1 = new Elevator();
        elevator1.setName("Elevator1");
        elevator1.start();
        elevator1.setMode("working");

        Elevator elevator2 = new Elevator();
        elevator2.setName("Elevator2");
        elevator2.setMode("idle");
        elevator2.start();

        Elevator elevator3 = new Elevator();
        elevator3.setName("Elevator3");
        elevator3.start();

        Elevator elevator4 = new Elevator();
        elevator4.setName("Elevator4");
        elevator4.start();

        Elevator elevator5 = new Elevator();
        elevator5.setName("Elevator5");
        elevator5.start();

        while (true) {
            printFloorInfos();
            printElevatorInfos(elevator1);

            if (App.ALL_QUEUE > 20 && App.ALL_QUEUE < 40) {
                elevator2.setMode("working");
            }
            if (App.ALL_QUEUE < 20 && elevator2.COUNT_INSIDE == 0) {
                elevator2.setMode("idle");
            }

            if (App.ALL_QUEUE > 40 && App.ALL_QUEUE < 60) {
                elevator3.setMode("working");
            }
            if (App.ALL_QUEUE < 40 && elevator3.COUNT_INSIDE == 0) {
                elevator3.setMode("idle");
            }
            if (App.ALL_QUEUE > 60 && App.ALL_QUEUE < 80) {
                elevator4.setMode("working");
            }
            if (App.ALL_QUEUE < 60 && elevator4.COUNT_INSIDE == 0) {
                elevator4.setMode("idle");
            }
            if (App.ALL_QUEUE > 80 && App.ALL_QUEUE < 100) {
                elevator5.setMode("working");
            }
            if (App.ALL_QUEUE < 80 && elevator5.COUNT_INSIDE == 0) {
                elevator5.setMode("idle");
            }

            printElevatorInfos(elevator2);
            printElevatorInfos(elevator3);
            printElevatorInfos(elevator4);
            printElevatorInfos(elevator5);

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
