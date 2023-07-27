package homework;


import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Input in = new Input();
        Scanner scanner = new Scanner(System.in);
        SaveEntry.save(in.parseLine(scanner.nextLine()));

    }
}