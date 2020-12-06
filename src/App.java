import java.util.ArrayList;

public class App {
    public static ArrayList<ArrayList<Integer>> FLOOR_0_QUEUE = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> FLOOR_1_QUEUE = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> FLOOR_2_QUEUE = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> FLOOR_3_QUEUE = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> FLOOR_4_QUEUE = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) throws Exception {
        LoginThread loginThread = new LoginThread();
        loginThread.setName("Login Thread");

        loginThread.start();
    }
}
