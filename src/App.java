import java.util.ArrayList;

public class App {
    public static ArrayList<ArrayList<Integer>> FLOOR_0_QUEUE = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> FLOOR_1_QUEUE = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> FLOOR_2_QUEUE = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> FLOOR_3_QUEUE = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> FLOOR_4_QUEUE = new ArrayList<ArrayList<Integer>>();

    public static int ALL_QUEUE = 0;
    public static int FLOOR_0_QUEUE_COUNT = 0;
    public static int FLOOR_1_QUEUE_COUNT = 0;
    public static int FLOOR_2_QUEUE_COUNT = 0;
    public static int FLOOR_3_QUEUE_COUNT = 0;
    public static int FLOOR_4_QUEUE_COUNT = 0;

    public static int FLOOR_0_ALL = 0;
    public static int FLOOR_1_ALL = 0;
    public static int FLOOR_2_ALL = 0;
    public static int FLOOR_3_ALL = 0;
    public static int FLOOR_4_ALL = 0;

    public static void main(String[] args) throws Exception {
        LoginThread loginThread = new LoginThread();
        loginThread.setName("Login Thread");
        loginThread.start();

        ControlThread controlThread = new ControlThread();
        controlThread.setName("Control Thread");
        controlThread.start();

        ExitThread exitThread = new ExitThread();
        exitThread.setName("Exit Thread");
        exitThread.start();
    }
}
