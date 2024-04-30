package helper;

public class WaitingClass {



    public static void waitResult() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
