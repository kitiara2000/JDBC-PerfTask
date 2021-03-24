package com.example.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public static String[] fileToArray(String filename) {
        BufferedReader reader = null;
        List<String> textFromFile = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(filename));
            while (reader.ready()) {
                textFromFile.add(reader.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return textFromFile.toArray(new String[0]);
    }
}
