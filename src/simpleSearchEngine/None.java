package simpleSearchEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class None extends Find {
    protected Scanner scanner;

    None (ArrayList<String> names, HashMap<String, ArrayList<Integer>> nameMap) {
        super(names, nameMap);
        this.scanner = new Scanner(System.in);
    }

    public void result() {
        System.out.println("Enter name or email to search for no suitable people");
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
                    System.out.println();
                }
            }

        } catch(Exception e) {
            System.out.print("");
        }

        ArrayList<Integer> toRemove = new ArrayList<>();
        for (ArrayList<Integer> a: arrays) {
            for(int i = 0; i < a.size(); i++) {
                int tempNum = a.get(i);
                if(!(toRemove.contains(tempNum))) {
                    toRemove.add(tempNum);
                }
            }
        }

        Collections.sort(toRemove);
        int remover = 0;

        for (int i = 0; i < toRemove.size(); i++) {
            int index2 = toRemove.get(i) + remover;
            names.remove(index2);
            remover--;

        }
        for (String s: names) {
            System.out.println(s);
        }


    }
}