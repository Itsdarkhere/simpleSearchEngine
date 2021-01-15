package simpleSearchEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Any extends Find {
    protected Scanner scanner;

    Any (ArrayList<String> names, HashMap<String, ArrayList<Integer>> nameMap) {
        super(names, nameMap);
        this.scanner = new Scanner(System.in);
    }

    public void result () {
        System.out.println("Enter name or email to search for all suitable people");
        String data = scanner.nextLine().toLowerCase();
        String[] toSearchFor = data.split(" ");
        ArrayList<String> temp = new ArrayList<>();
        Collections.addAll(temp, toSearchFor);
        ArrayList<ArrayList<Integer>> arrays = new ArrayList<>();
        int index = 0;

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

        ArrayList<Integer> stopRepeat = new ArrayList<>();

        for (ArrayList<Integer> a: arrays) {
            for (int i = 0; i < a.size(); i++) {
                int temporary = a.get(i);
                if(!(stopRepeat.contains(temporary))) {
                    System.out.println(names.get(temporary));
                    stopRepeat.add(temporary);
                }

            }
        }
    }

}