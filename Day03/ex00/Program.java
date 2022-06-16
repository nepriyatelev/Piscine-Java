public class Program {
    public static void main(String[] args) throws InterruptedException {
        int count = parser(args);
        Runnable runnable = () -> {
            for (int i = 0; i < count; i++) {

                +
            }
        };
        Thread egg = new Thread(runnable, "egg");
        Thread hen = new Thread(runnable, "hen");
        egg.start(); hen.start();
        egg.join(); hen.join();
        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }

    private static int parser(String[] args) {
        if (args.length != 1) {
            System.err.println("Incorrect number of arguments!");
            System.exit(-1);
        }
        if (!(args[0].substring(0, args[0].indexOf('=') + 1).equals("--count="))) {
            System.err.println("Invalid argument name!");
            System.exit(-1);
        }
        int count = Integer.parseInt(args[0].substring(args[0].indexOf('=') + 1));
        if (count < 1) {
            System.err.println("The counter is less than 1!");
            System.exit(-1);
        }
        return count;
    }
}

