import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        String[] file1 = readFile(args[0]);
        String[] file2 = readFile(args[1]);
        Set<String> dictionary = fillingDictionary(file1, file2);
        HashMap<String, Integer> sumWord1 = outSumWord(file1, dictionary);
        HashMap<String, Integer> sumWord2 = outSumWord(file2, dictionary);
        double result = param1(sumWord1, sumWord2);
        outDictionary(dictionary);
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Similarity = " + df.format(result));
    }
    private static String[] readFile(String file) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bf.readLine()) != null) {
                line = line.replaceAll("(?U)\\pP", "");
                stringBuilder.append(line);
            }
            bf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString().split("\\s");
    }
    private static Set<String> fillingDictionary (String[] file1, String[] file2) {
        Set<String> dictionary = new HashSet<>();
        dictionary.addAll(Arrays.asList(file1));
        dictionary.addAll(Arrays.asList(file2));
        return dictionary;
    }

    private static void outDictionary(Set<String> dictionary) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(" dictionary.txt"));
            StringBuilder sb = new StringBuilder();
            for (String s : dictionary) {
                sb.append(s).append(", ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            bw.write(sb.toString());
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static HashMap<String, Integer> outSumWord (String[] file, Set<String> dictionary) {
        HashMap<String, Integer> sumWord = new HashMap<>();
        for (String s : dictionary) {
            sumWord.put(s, 0);
        }
        for (String s : file) {
            if (sumWord.containsKey(s)) {
                sumWord.put(s, sumWord.get(s) + 1);
            }
        }
        return sumWord;
    }

    private static double param1 (HashMap<String, Integer> sumWord1, HashMap<String, Integer> sumWord2) {
        double param1 = 0;
        int i = 0;
        for(String s : sumWord1.keySet()) {
            param1 += sumWord1.get(s) * sumWord2.get(s);
            i++;
        }
        int[] arr1 = new int[i];
        int[] arr2 = new int[i];
        i = 0;
        for (Map.Entry<String, Integer> pair : sumWord1.entrySet()) {
            arr1[i] = pair.getValue();
            i++;
        }
        i = 0;
        for (Map.Entry<String, Integer> pair : sumWord2.entrySet()) {
            arr2[i] = pair.getValue();
            i++;
        }
        double param2 = 0;
        double param3 = 0;
        for (int j = 0; j < arr1.length; j++) {
            param2 += arr1[j] * arr1[j];
            param3 += arr2[j] * arr2[j];
        }
        return param1 / (Math.sqrt(param2) * Math.sqrt(param3));
    }

}
