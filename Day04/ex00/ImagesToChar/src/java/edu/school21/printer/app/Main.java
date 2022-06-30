package edu.school21.printer.app;

import edu.school21.printer.logic.Converting;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hey, dude!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character for white: ");
        String white = scanner.nextLine();
        if (white.length() > 1){
            System.err.println(white + " not suitable, compile and try again");
            scanner.close();
            System.exit(-1);
        }
        System.out.print("Enter a character for black: ");
        String black = scanner.nextLine();
        if (black.length() > 1){
            System.err.println(black + " not suitable, compile and try again");
            scanner.close();
            System.exit(-1);
        }
        System.out.print("Enter the path to the image: ");
        File file = new File(scanner.nextLine());
        if(!file.exists() || !file.isFile()) {
            System.err.println(file + " there is no such file, compile and try again");
            scanner.close();
            System.exit(-1);
        }
        scanner.close();
        Converting converting = new Converting(white.charAt(0), black.charAt(0), file);
        converting.draw();
    }
}
