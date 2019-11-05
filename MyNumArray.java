import java.util.*;

/**
 * MyNumArray
 */
public class MyNumArray implements MaxMinNum, Cloneable, Comparable<MyNumArray> {
  private int[] data;

  public MyNumArray() {
    data = new int[16];
  }
  public MyNumArray(int size) {
    data = new int[size];
  }

  public int getSize() {
    return this.data.length;
  }

  public int getNumber(int index) {
    if (index < 0 || index > this.data.length) {
      throw new IndexOutOfBoundsException();
    }

    return data[index];
  }
  public void setNumber(int number, int index) {
    if (index < 0 || index > this.data.length) {
      throw new IndexOutOfBoundsException();
    }

    data[index] = number;
  }

  @Override
  public int getMaximum() {
    int max = this.getNumber(0);

    for (int i = 0; i < this.getSize(); i++) {
      max = Math.max(max, this.getNumber(i));
    }
    
    return max;
  }

  @Override
  public int getMinimum() {
    int min = this.getNumber(0);

    for (int i = 0; i < this.getSize(); i++) {
      min = Math.min(min, this.getNumber(i));
    }

    return min;
  }

  @Override
  public int compareTo(MyNumArray b) {
    if (b == null) {
      throw new NullPointerException("Attempted to used compareTo with a null value");
    }

    int minA = this.getMinimum();
    int minB = b.getMinimum();
    int maxA = this.getMaximum();
    int maxB = b.getMaximum();

    return (minA - minB) + (maxA - maxB);
  }

  @Override
  // deep copy
  public MyNumArray clone() {
    MyNumArray clone = new MyNumArray(this.getSize());
    for (int i = 0; i < this.getSize(); i++) {
      clone.setNumber(this.getNumber(i), i);
    }

    return clone;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof MyNumArray) {
      MyNumArray a = (MyNumArray) o;
      
      // equals if objects are of same size, and if the content is the same
      if (this.getSize() == a.getSize()) {
        for (int i = 0; i < this.getSize(); i++) {
          // elements at index don't match
          if (this.getNumber(i) != a.getNumber(i)) {
            return false;
          }
        }
        return true;
      }
      // size doesn't match
      else {
        return false;
      }
    }
    else {
      throw new IllegalArgumentException("Provided parameter is not of MyNumArray type");
    }
  }

  @Override
  public String toString() {
    return String.format("data: %s; maximum number: %d; minimum number: %d",
      Arrays.toString(this.data), this.getMaximum(), this.getMinimum()
    );
  }
}