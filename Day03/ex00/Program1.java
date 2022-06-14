public class Program {
    public static void main(String[] args) {
        int count = Integer.parseInt(args[0].substring(args[0].indexOf('=') + 1));
        Runnable hen = () -> {
            for (int i = 0; i < count; i++) {
                System.out.println("Hen");
            }
        };
        Runnable egg = () -> {
            for (int i = 0; i < count; i++) {
                System.out.println("Egg");
            }
        };
        Thread thread1 = new Thread(egg);
        Thread thread2 = new Thread(hen);
        thread1.start();
        thread2.start();
        while (true) {
            if (!thread1.isAlive() && !thread2.isAlive()) {
                break;
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }
}

