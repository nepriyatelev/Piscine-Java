import java.io.File;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        if (!(args[0].substring(0, 17).equals("--current-folder="))) {
            System.err.print("Invalid argument :" + args[0]);
            System.exit(-1);
        }
        File currentDir = new File(args[0].substring(17));
        System.out.println(currentDir);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit")) break;
            else if (input.equals("ls")) {
                ls(currentDir);
            } else if (input.substring(0, 2).equals("cd")) {
                cd(currentDir, input.substring(3));
            }
            System.out.println(currentDir);
        }
    }
    private static void cd (File currentDir, String dir) {
        File file = new File(currentDir + "/" + dir);
        System.out.println(file);
        if (file.isDirectory() && currentDir.renameTo(file)) {
            System.out.println(currentDir);
        } else {
            System.err.println(dir + " is not a directory!");
        }
    }
    private static void ls(File file) {
        for (File f : Objects.requireNonNull(file.listFiles()))
        {
            if (f.isFile()) {
                System.out.println(f.getName() + " " + f.length() / 1024 + " КБ");
            } else {
                System.out.println(f.getName() + " " + directorySize(f) + " КБ");
            }
        }
    }
    public static long directorySize(File directory) {
        long length = 0;
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isFile())
                length += file.length();
            else
                length += directorySize(file);
        }
        return length / 1024;
    }
}
