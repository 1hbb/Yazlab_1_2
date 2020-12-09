public class ShowInfos {
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String RESET_COLOR = "\033[0m";

    public void printFloorInfos() {
        System.out.println("All queue count: " + App.ALL_QUEUE);
        System.out.println("0. floor: queue: " + App.FLOOR_0_QUEUE_COUNT + " queue array: " + App.FLOOR_0_QUEUE);
        System.out.println("1. floor:" + "all:" + App.FLOOR_1_ALL + " queue: " + App.FLOOR_1_QUEUE_COUNT
                + " queue array: " + App.FLOOR_1_QUEUE);
        System.out.println("2. floor:" + "all:" + App.FLOOR_2_ALL + " queue: " + App.FLOOR_2_QUEUE_COUNT
                + " queue array: " + App.FLOOR_2_QUEUE);
        System.out.println("3. floor:" + "all:" + App.FLOOR_3_ALL + " queue: " + App.FLOOR_3_QUEUE_COUNT
                + " queue array: " + App.FLOOR_3_QUEUE);
        System.out.println("4. floor:" + "all:" + App.FLOOR_4_ALL + " queue: " + App.FLOOR_4_QUEUE_COUNT
                + " queue array: " + App.FLOOR_4_QUEUE);
        System.out.println();

    }
    

    public void printElevatorInfos(Elevator elevator) {
        System.out.println(elevator.getName().toUpperCase());
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
}
