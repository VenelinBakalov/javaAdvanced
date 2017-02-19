
public class SingleThread {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 1; i <= 10; i++) {
                System.out.print(i + " ");
            }
        };

        Thread thread = new Thread(task);

        thread.start();
        thread.join();
        System.exit(1);
    }
}
