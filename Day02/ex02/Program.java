import java.io.File;
import java.io.IOException;
import java.util.*;

public class Program {

    public static void main(String[] args) {
        if (!(args[0].substring(0, 17).equals("--current-folder="))) {
            System.err.print("Invalid argument : " + args[0]);
            System.exit(-1);
        }
        if (!new File(args[0].substring(17)).exists()) {
            System.err.print("Invalid argument : " + args[0].substring(17));
            System.exit(-1);
        }
        String path = args[0].substring(17);
        System.out.println(path);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                scanner.close();
                break;
            }
            else if (input.equals("ls")) {
                ls(path);
            } else if (input.length() > 2) {
                if (input.substring(0, 2).equals("cd")) {
                    try {
                        path = cd(path, input.substring(3));
                        System.out.println(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (input.substring(0, 2).equals("mv")) {
                    mv(input.substring(3), path);
                } else {
                    System.out.println("Command not found!");
                }
            } else if (!input.equals("")) {
                System.out.println("Command not found!");
            }
        }
    }

    private static void mv(String param, String path) {
        String[] tmp = param.split("\\s+");
        File file1 = new File(path, tmp[0]);
        File file2 = new File(path, tmp[1]);
        boolean success = false;
        if (file1.exists()) {
            if (file2.isDirectory()) {
                try {
                    success = file1.renameTo(new File(file2.getCanonicalPath(), file1.getName()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (!new File(path, file2.getName()).exists()) {
                success = file1.renameTo(new File(path, file2.getName()));
            } else {
                System.err.println("No such file or directory");
            }
            if (!success) {
                System.err.println("File was not successfully renamed!");
            }
        }
    }
    private static String cd (String dir1, String dir2) throws IOException {
        File file1 = new File(dir1);
        File file2 = new File(file1, dir2);
        if (!file2.isDirectory()) {
            System.err.println(file2.getCanonicalPath() + " is not a directory!");
            return dir1;
        }
        return file2.getCanonicalPath();
    }
    private static void ls(String path) {
        File file = new File(path);
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
