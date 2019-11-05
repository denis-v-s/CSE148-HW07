import java.io.*;

public class FindAndReplace {
  public static void main(String[] args) {
    int count = 0;
    
    count = findAndReplace("C:/Users/haosm/Downloads/Ex_Files_Advanced_SQL_Time_Series/Exercise Files/test.txt", "six", "replaced", true);
    System.out.println(count);
  }
  
  private static int findAndReplace(String file, String originalWord, String newWord, boolean caseSensitive) {
    String line = "";
    StringBuilder content = new StringBuilder();
    int counter = 0;

    // parse the file, and update content variable. Replace matching words.
    try (
      FileReader r = new FileReader(file);
      BufferedReader reader = new BufferedReader(r);
      ) {
      while ((line = reader.readLine()) != null) {
        counter += parseLine(line, content, originalWord, newWord, caseSensitive);
      }
    }
    catch (Exception ex) {
      System.out.println(ex.getMessage());
      System.exit(1);
    }
    
    // override the content if any word matches exist.
    if (counter > 0) {
      try (FileWriter writer = new FileWriter(file)) {
        writer.write(content.toString());
      }
      catch (Exception ex) {
        System.out.println(ex.getMessage());
        System.exit(1);
      }
    }
    
    return counter;
  }

  /**
   * @summary - parses a string, word by word, and replaces words (if matched.)
   * @param line - string that's being parsed
   * @param content - StringBuilder object that holds cumulative content
   * @param oldWord - word that's being replaced
   * @param newWord - the word that replaces oldWord
   * @return - the number of words that were replaced
   */
  private static int parseLine(String line, StringBuilder content, String oldWord, String newWord, boolean caseSensitive) {
    int counter = 0;
    int match = 0; // match will be negative, 0, or positive integer. 0 means it's equal
    
    // got through each word in the string and push it to new content
    // if current word matches oldWord, then replace it with newWord
    for (String word : line.split("\\s+")) {
      match = (caseSensitive) ? word.compareToIgnoreCase(oldWord) : word.compareTo(oldWord);
      
      if (match == 0) {
        counter++;
        content.append(newWord + " ");
      }
      else {
        content.append(word + " ");
      }
    }

    content.append(System.lineSeparator());
    return counter;
  }
}