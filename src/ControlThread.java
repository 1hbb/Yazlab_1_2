public class ControlThread extends Thread {
    class Elevator1 extends Elevator {
        @Override
        public void run() {
            super.run();
        }
    }

    @Override
    public void run() {
        Elevator1 elevator1 = new Elevator1();
        elevator1.setName("Elevator1");
        elevator1.start();
    }

}
