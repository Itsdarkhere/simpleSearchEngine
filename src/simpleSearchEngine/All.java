package simpleSearchEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class All extends Find {
    protected Scanner scanner;

    All (ArrayList<String> names, HashMap<String, ArrayList<Integer>> nameMap) {
        super(names, nameMap);
        this.scanner = new Scanner(System.in);
    }

    public void result() {
        System.out.println("Enter name or email to search for all suitable people");
        String data = scanner.nextLine().toLowerCase();
        String[] toSearchFor = data.split(" ");
        ArrayList<String> temp = new ArrayList<>();
        Collections.addAll(temp, toSearchFor);
        int index = 0;
        ArrayList<ArrayList<Integer>> arrays = new ArrayList<>();

        try {
            while(temp.get(index) != null) {
                String key = temp.get(index);
                index++;
                if (nameMap.containsKey(key)) {
                    arrays.add(nameMap.get(key));

                } else {
                    System.out.print("");
                }
            }

        } catch(Exception e) {
            System.out.print("");
        }
        if (arrays.size() == 0) {
            System.out.println("No suitable people found!");
        }

        ArrayList<Integer> printList = new ArrayList<>();
        ArrayList<Integer> stopRepeat = new ArrayList<>();

        for (int a = 1; a < arrays.size(); a++) {
            for(int b = 0; b < arrays.get(a).size(); b++) {
                int tempNum1 = arrays.get(a).get(b);
                if(arrays.get(a - 1).contains(tempNum1)) {
                    printList.add(tempNum1);
                }
            }
        }

        for (Integer p: printList) {
            int temporary = p;
            if(!(stopRepeat.contains(temporary))) {
                System.out.println(names.get(temporary));
                stopRepeat.add(temporary);
            }
        }

    }

}
