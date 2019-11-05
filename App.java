import java.util.*;

/**
 * App
 */
public class App {

  public static void main(String[] args) {
    MyNumArray m1 = new MyNumArray(5);
    MyNumArray m2 = new MyNumArray(3);
    MyNumArray m3 = new MyNumArray(3);
    m1.setNumber(1, 0);
    m1.setNumber(5, 1);
    m1.setNumber(3, 2);
    m1.setNumber(8, 3);
    m1.setNumber(0, 4);

    m2.setNumber(1, 0);
    m2.setNumber(1, 1);
    m2.setNumber(5, 2);

    m3.setNumber(1, 0);
    m3.setNumber(1, 1);
    m3.setNumber(5, 2);
    

    ArrayList<MyNumArray> list = new ArrayList<>();
    list.add(m1);
    list.add(m2);
    list.add(m3);

    System.out.println(m2.compareTo(m3));
  }
}