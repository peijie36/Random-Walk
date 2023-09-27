import java.io.*;
import java.util.*;

public class FileIOExample {

   public static final String outputFileName = "danceWordByWord.txt";

   public static void main(String[] args) throws FileNotFoundException{
      System.out.println("I will print each word in the file dance.txt to a new file" 
          + " so that each word is on a new line.");
      
      File danceFile = new File("dance.txt");
      if(!danceFile.exists()) {
          System.out.println("Make sure the file dance.txt is in the same directory as"
              + "this java file and try again.");
      } else {
          Scanner fileInput = new Scanner(danceFile);
          createOutputFile(fileInput);
          System.out.println("File processing completed. You can view the new file: " + outputFileName);
      } 
   }
   
   public static void createOutputFile(Scanner fileInput) throws FileNotFoundException{
      PrintStream outputFile = new PrintStream(new File(outputFileName));
      // Make sure there is a line to process
      while (fileInput.hasNextLine()) {
         String line = fileInput.nextLine();
         
         // Loop over the tokens in the line
         Scanner lineScan = new Scanner(line);
         while(lineScan.hasNext()){
            outputFile.println(lineScan.next());
         }
      }
   }
}
