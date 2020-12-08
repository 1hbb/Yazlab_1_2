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

        while (true) {

            if (App.ALL_QUEUE > 20) {
                if (elevator2.MODE == "idle") {
                    elevator2.setMode("working");
                } else if (elevator3.MODE == "idle") {
                    elevator3.setMode("working");
                } else if (elevator4.MODE == "idle") {
                    elevator4.setMode("working");
                } else if (elevator5.MODE == "idle") {
                    elevator5.setMode("working");
                }
            } else {
                if (elevator2.MODE == "working") {
                    elevator2.setMode("idle");
                } else if (elevator3.MODE == "working") {
                    elevator3.setMode("idle");
                } else if (elevator4.MODE == "working") {
                    elevator4.setMode("idle");
                } else if (elevator5.MODE == "working") {
                    elevator5.setMode("idle");
                }
            }

            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
