import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.io.FileWriter;
import java.util.Iterator;

public class DuplicateRemover {

    //a set for to be used to store the unique words found in the dataFile
    private Set<String> uniqueWords;

    //method to remove non-unique words by taking all unique words and placing them in a separate set
    public static void remove(String dataFile) throws FileNotFoundException {
        HashSet<String> uniqueWords = new  HashSet<String>();
        Scanner scnr = new Scanner(new File(dataFile));
        String wordsFromFile;

        //while there is a next line, take the unique words and add them to the set
        while(scnr.hasNextLine()){
            wordsFromFile = scnr.next();
            uniqueWords.add(wordsFromFile);
        }
    }

    public void write(String outputFile)throws IOException{

        FileWriter writingInFile = new FileWriter(outputFile);
        File OrigOutputFile = new File(outputFile);

        String wordFromUniqueWords;
        //after a few hours of trying for loops, i found iterators online. I've never been more excited
        Iterator i = uniqueWords.iterator();

        //checking to see if the file exists or not
        if(OrigOutputFile.isFile()){
            while(i.hasNext()){
                wordFromUniqueWords  = (String)i.next();
                writingInFile.write(wordFromUniqueWords + "\n");
            }
        }
        else{
            OrigOutputFile.createNewFile();
            writingInFile = new FileWriter(OrigOutputFile);
            while(i.hasNext()){
                wordFromUniqueWords  = (String)i.next();
                writingInFile.write(wordFromUniqueWords + "\n");
            }
        }
    }
}
class Application {
    public static void main(String[] args) throws IOException {
        DuplicateRemover dr =new DuplicateRemover();
        dr.remove("problem1.txt");
        dr.write("unique_words.txt");


    }

}