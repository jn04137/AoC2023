package d3;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.lang.StringBuilder;

import java.lang.Character;
import java.lang.NumberFormatException;

class D3 {
  public static void main(String... args) {
    System.out.println("Day 3 solution");
    int sum = 0;

    // Will have to go through each line and pick up numbers + coordinates
    // Will have to check if there are symbols that are adjacent to each of the coordinates
    // Store coordinates in a list and then add to sum if the number is adjacent
    List<String> linesFromFile = readFile("input");

    for(int line = 0; line < linesFromFile.size(); line++) {
      StringBuilder sb = new StringBuilder();
      List<List<Integer>> coords = new ArrayList<>();

      for(int element = 0; element < linesFromFile.get(line).length(); element++) {
        
        // lets collect the numbers first and coords first
        // If char is a digit, add it to the string builder
        if(Character.isDigit(linesFromFile.get(line).charAt(element))){
          sb.append(linesFromFile.get(line).charAt(element)); 
          coords.add(new ArrayList(Arrays.asList(line, element)));
        } else {
          try {
            int number = Integer.parseInt(sb.toString());
          } catch(NumberFormatException nfe) {
            continue;
          }
        }
      }

      System.out.println(Arrays.toString(coords.toArray()));
    }
  }
  
  // Method for reading in input
  public static List<String> readFile(String filePath) {
    File file = new File(filePath);
    List<String> list = new ArrayList<String>();

    try {
      BufferedReader br = new BufferedReader(new FileReader(file));
      String line;

      while((line = br.readLine()) != null) {
        list.add(line);
      }
    } catch(IOException ioException) {
      System.out.println(ioException.getMessage());
    }

    return list;
  }
}
