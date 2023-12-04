package d2;

import java.lang.StringBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.lang.Integer;


class D2 {
  public static void main(String... args) {
    List<String> listOfRounds = readFile("input.txt");
    Map<String, Integer> maxes = new HashMap<>();
    maxes.put("red", 12); 
    maxes.put("green", 13); 
    maxes.put("blue", 14); 
    int sum = 0;

    for(String round : listOfRounds) {

      String[] splitInfo = round.split(":");
      String[] games = splitInfo[1].split(";");
      Map<String, Integer> leastMap = new HashMap<>();
      leastMap.put("green", null);
      leastMap.put("red", null);
      leastMap.put("blue", null);

      for(String game : games) {
        String[] counts = game.split(",\\s");
        for(String count : counts) {
          String[] pairs = count.trim().split("\\s");
          int val = Integer.valueOf(pairs[0]);
          String color = pairs[1].trim();
          if(maxes.get(color) < val) {
            continue;
          }
          if(leastMap.get(color) == null) {
            leastMap.put(color, val);
          }
          if(leastMap.get(color) > val) {
            leastMap.put(color, val);
          }
        }
      }

      int power = 1;
      for(int occ : leastMap.values()) {
        power = occ * power;
      }
      System.out.println(leastMap + "This is the power " + power);
      sum += power;
    }

    System.out.println(sum);
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
