import java.io.*;
import java.util.*;


public class CountFiles {
  private static void countFiles(String path) {
    // set initial directory
    File fs = new File(path);
    int fileCount = 0;

    // read the content and add it to the stack
    File[] dirContent = fs.listFiles();;
    Stack<File> stack = new Stack<>();
    stack.addAll(Arrays.asList(dirContent));

    // while stack has items in it, go through its contents
    while (!stack.empty()) {
      File file = stack.pop();

      // if current item is a file, then print its name
      if (file.isFile()) {
        System.out.println(file.getName());
        fileCount++;
      }
      // otherwise, it's a directory, add it to the stack
      else {
        stack.addAll(Arrays.asList(file.listFiles()));
      }
    }

    // list the count of files
    System.out.println("Total number of files: " + fileCount);
  }

  public static void main(String[] args) {
    countFiles("C:/Users/haosm/Downloads/Ex_Files_Advanced_SQL_Time_Series/Exercise Files");
  }
}