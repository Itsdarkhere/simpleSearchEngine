package simpleSearchEngine;

import java.util.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        new Main().run();

    }

    public void run() {

        String fileName = "names.txt";
        ArrayList<String> names = new ArrayList<>();
        LinkedHashMap<String, ArrayList<Integer>> nameMap = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        boolean switchOn = true;
        int index = 0;


        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNextLine()) {
                String fileInput = fileScanner.nextLine();
                String line = fileInput.toLowerCase();
                names.add(fileInput);
                String[] namesInLowerCase = line.split(" ");

                for (String n: namesInLowerCase) {
                    ArrayList<Integer> i = new ArrayList<>();

                    nameMap.putIfAbsent(n,i);
                    nameMap.get(n).add(index);

                }
                index++;
            }
        } catch(Exception e) {
            System.out.println("File not found");
        }



        while (switchOn) {
            System.out.println(" ");
            System.out.println("=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all persons");
            System.out.println("0. Exit");

            int decision = scanner.nextInt();

            switch (decision) {
                case 1:
                    searchStrategy(names, nameMap, scanner);
                    break;
                case 2:
                    printAll(fileName);
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Bye!");
                    switchOn = false;
                    break;
                default:
                    System.out.println("Incorrect option! Try again!");

            }
        }

    }

    public static void searchStrategy (ArrayList<String> names, HashMap<String, ArrayList<Integer>> nameMap, Scanner scanner) {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        String answer = scanner.nextLine();

        if ("ALL".equals(answer)) {
            Find find = new All(names, nameMap);
            find.result();

        } else if ("ANY".equals(answer)) {
            Find find = new Any(names, nameMap);
            find.result();

        } else if ("NONE".equals(answer)) {
            Find find = new None(names, nameMap);
            find.result();
        }
    }

    public static void printAll(String fileName) {
        System.out.println("\n=== List of people ===");
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNext()) {
                String sport = fileScanner.nextLine();
                System.out.println(sport);
            }

        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
}
