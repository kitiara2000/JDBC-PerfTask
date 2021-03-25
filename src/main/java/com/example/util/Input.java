package com.example.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Input {

    public static String[] fileToArray(String filename) {
        BufferedReader reader = null;
        List<String> textFromFile = new ArrayList<>();

        try {
            log.info("Reading .csv file");
            reader = new BufferedReader(new FileReader(filename));
            while (reader.ready()) {
                textFromFile.add(reader.readLine());
            }
            log.info("File read with success");
        } catch (Exception e) {
            log.error("The system cannot access the file specified", e);
        }

        return textFromFile.toArray(new String[0]);
    }
}
