public class Program {
    public static void main(String[] args) {
        int count = Integer.parseInt(args[0].substring(args[0].indexOf('=') + 1));
        MyThread hen = new MyThread("Hen", count);
        MyThread egg = new MyThread("Egg", count);
        hen.start();
        egg.start();
        try {
            hen.join();
            egg.join();
        } catch (InterruptedException ignored) {}
        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }
}
