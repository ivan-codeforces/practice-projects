package ru.ivan;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Duplicates {
    public static void main(String args[]) throws IOException {
        Map<String, Integer> value = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ikhizhkin\\IdeaProjects\\Calculator\\test.txt"));
            String readLine = reader.readLine();
            while (readLine != null) {
                if (value.containsKey(readLine)) {
                    int temp = value.get(readLine) + 1;
                    value.put(readLine, temp);
                } else {
                    value.put(readLine, 1);
                }
                readLine = reader.readLine();
            }
            LinkedHashMap<String, Integer> sortedValue = new LinkedHashMap<>();
            value.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEachOrdered(x -> sortedValue.put(x.getKey(), x.getValue()));
            File file = new File("C:\\Users\\ikhizhkin\\IdeaProjects\\Calculator\\test1.txt");
            FileWriter writerLine = new FileWriter(file);
            for (String key : sortedValue.keySet()) {
                writerLine.write(key + " [" + value.get(key) + "]\n");
            }
            writerLine.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}