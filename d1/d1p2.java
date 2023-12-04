package d1;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;
import java.lang.Character;
import java.lang.StringBuilder;


/*
 * problem the little artist elf has added coordinances in a fun
 * way. We have to decode the coordinate by collecting the first
 * digit and the last digit of each line.
 *
 * Thinking that we'll need to just iterate through the first end
 * of the line to find the first integer and then iterate from the 
 * right end for the first digit.
 *
 * Might can check from left and right ends at the same time to speed
 * up process for finding the digits.
 *
 * */

/*
 * Part 2
 *
 * Now that that we've collected the digits we found out that some
 * of the coordinates are actually saved into the input as text as 
 * well. So 2 could show up as two in some lines. We'll need to 
 * find a way to parse text and check for digits.
 *
 * Ideas
 * Deque and StringBuilder?
 *
 * Check if digit,
 * if it is, take the digit. If not, add char to stringbuilder
 * Will have to do some sort of sliding window probably
 *
 * */

class D1 {
  public static void main(String... args) {
    System.out.println("Running for day 1 Part 2");
    List<String> inputList = readFile("input.txt");

    int left, right;
    boolean leftCheck, rightCheck;
    Integer leftDigit, rightDigit;

    StringBuilder coordBuilder;
    List<Integer> listOfCoords = new ArrayList<Integer>();

    for(String line : inputList) {
      coordBuilder = new StringBuilder();
      left = 0; right = line.length() - 1;
      leftCheck = false; rightCheck = false;

      leftDigit = 0;

      while(leftCheck == false || rightCheck == false) {
        if(leftCheck == false && Character.isDigit(line.charAt(left))) {
          coordBuilder.insert(0, line.charAt(left));
          leftCheck = true;
        }
        if(rightCheck == false && Character.isDigit(line.charAt(right))) {
          coordBuilder.append(line.charAt(right));
          rightCheck = true;
        }

        left += 1; right -= 1;
      }
      listOfCoords.add(Integer.valueOf(coordBuilder.toString())); 
    }

    int sumCoord = 0;
    for(int coord : listOfCoords) {
      sumCoord += coord;
    }

    System.out.println(sumCoord);
  }

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
