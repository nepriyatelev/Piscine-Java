import java.io.*;
import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
        try {
            mainLoop(readSignatures());
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }
    private static HashMap<String, String> readSignatures() throws IOException {
        FileInputStream fin = new FileInputStream(new File("src/signatures.txt"));
        StringBuilder stringBuilder = new StringBuilder();
        int i;
        while ((i = fin.read()) > 0) {
            if ((char)i == ' ')
                continue;
            stringBuilder.append((char)i);
        }
        fin.close();
        String[] splitFin = stringBuilder.toString().split("\n");
        HashMap<String, String> sigMap = new HashMap<>();
        for (String s : splitFin) {
            sigMap.put(s.substring(s.indexOf(",") + 1, s.length() - 1), s.substring(0, s.indexOf(",")));
        }
        return sigMap;
    }

    private static void mainLoop(HashMap<String, String> sigMap) throws IOException {
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder stringBuilder = new StringBuilder();
            char c;
            while (true) {
                c = (char)br.read();
                if (c == '\n') {
                    break;
                }
                stringBuilder.append(c);
            }
            if (stringBuilder.toString().equals("42")) {
                br.close();
                break;
            }
            readInputFile(stringBuilder.toString(), sigMap);
        }
    }
    private static void readInputFile(String in, HashMap<String, String> sigMap) throws IOException {
        FileInputStream fin = new FileInputStream(in);
        boolean flag = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            stringBuilder.append(String.format("%02X", fin.read()));
        }
        for (String key : sigMap.keySet()) {
            if (key.equals(stringBuilder.toString().substring(0, key.length()))) {
                outFile(sigMap.get(key) + "\n");
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("UNDEFINED");
        }
        fin.close();
    }
    private static void outFile(String out) throws IOException {
        FileOutputStream fos = new FileOutputStream("result.txt", true);
        byte[] buffer = out.getBytes();
        fos.write(buffer);
        System.out.println("PROCESSED");
        fos.close();
    }
}
