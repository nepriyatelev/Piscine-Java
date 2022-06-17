public class Program {
    public static void main(String[] args) {
        int count = parser(args);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < count; i++) {
                    {
                        synchronized (this) {
                            this.notify();
                            System.out.println(Thread.currentThread().getName());
                            try {
                                this.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        };
        Thread egg = new Thread(runnable, "Egg");
        egg.start();
        Thread hen = new Thread(runnable, "Hen");
        hen.start();
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

