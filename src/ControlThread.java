public class ControlThread extends Thread {

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
        ShowInfos showInfos = new ShowInfos();

        while (true) {

            if (App.ALL_QUEUE > 20 && elevator2.FLOOR != elevator1.FLOOR) {
                elevator2.setMode("working");
            }
            if (App.ALL_QUEUE < 20 && elevator2.COUNT_INSIDE == 0) {
                elevator2.setMode("idle");
            }

            if (App.ALL_QUEUE > 40 && elevator1.FLOOR != elevator3.FLOOR && elevator2.FLOOR != elevator3.FLOOR) {
                elevator3.setMode("working");
            }
            if (App.ALL_QUEUE < 40 && elevator3.COUNT_INSIDE == 0) {
                elevator3.setMode("idle");
            }
            if (App.ALL_QUEUE > 60 && elevator4.FLOOR != elevator1.FLOOR && elevator4.FLOOR != elevator2.FLOOR
                    && elevator4.FLOOR != elevator3.FLOOR) {
                elevator4.setMode("working");
            }
            if (App.ALL_QUEUE < 60 && elevator4.COUNT_INSIDE == 0) {
                elevator4.setMode("idle");
            }
            if (App.ALL_QUEUE > 80 && elevator5.FLOOR != elevator1.FLOOR && elevator5.FLOOR != elevator2.FLOOR
                    && elevator5.FLOOR != elevator3.FLOOR && elevator5.FLOOR != elevator4.FLOOR) {
                elevator5.setMode("working");
            }
            if (App.ALL_QUEUE < 80 && elevator5.COUNT_INSIDE == 0) {
                elevator5.setMode("idle");
            }

            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                showInfos.printFloorInfos();
                showInfos.printElevatorInfos(elevator1);
                showInfos.printElevatorInfos(elevator2);
                showInfos.printElevatorInfos(elevator3);
                showInfos.printElevatorInfos(elevator4);
                showInfos.printElevatorInfos(elevator5);
            } catch (Exception e) {
                // TODO: handle exception
                //e.printStackTrace();
            }

        }

    }

}
