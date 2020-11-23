package com.brainacad.passwordReminder;

import java.util.ArrayList;

public class Util {
    public static void printRecords(ArrayList<? extends Record> records) {
        int i = 1;
        for (Record record : records) {
            System.out.print((i++)+") ");
            System.out.println(record);
        }
    }
}
