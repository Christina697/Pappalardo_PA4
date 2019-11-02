package com.company;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

class DuplicateCounter {

    private Integer wordCounter;
    private Map<String, Integer> map;

    public DuplicateCounter() {
        this.wordCounter = 0;
        this.map = new HashMap<>();
    }

    public void count(String dataFile) throws FileNotFoundException{
        Scanner ReadsFile = new Scanner(new File(dataFile));
            while (ReadsFile.hasNextLine()) {
                String line = ReadsFile.nextLine().trim();
                String[] data = line.split("[\\W]+");
                for (String word : data) {
                    this.wordCounter = map.get(word);
                    this.wordCounter = (this.wordCounter == null) ? 1 : ++this.wordCounter;
                    map.put(word, this.wordCounter);
                }
            }
    }

    public void write(String outputFile) throws IOException{
        FileWriter fw;
        PrintWriter pw;
            fw = new FileWriter(new File(outputFile));
            pw = new PrintWriter(fw);
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                pw.write(entry.getKey() + " occurs " + entry.getValue() + " times" + System.lineSeparator());
            }
    }
}


class Application {

    private static final String INPUT_FILE = "problem2.txt";
    private static final String OUTPUT_FILE = "unique_word_counts.txt";

    public static void main(String[] args) throws FileNotFoundException{
        DuplicateCounter DC = new DuplicateCounter();
        DC.count(INPUT_FILE);
        DC.write(OUTPUT_FILE);
    }
}