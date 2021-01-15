package simpleSearchEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Find {
    protected ArrayList<String> names;
    protected HashMap<String, ArrayList<Integer>> nameMap;
    protected Scanner scanner;

    Find (ArrayList<String>names, HashMap<String, ArrayList<Integer>> nameMap) {
        this.names = names;
        this.nameMap = nameMap;
        this.scanner = new Scanner(System.in);
    }

    public abstract void result();

}