/*
The Problem:

Reconciliation is a term Addepar uses for a set of correctness and consistency measures applied to the data we receive and use in financial calculations.

One of the most common reconciliation checks is called *unit reconciliation*, which answers the question, "does the transaction history add up to the number of shares the bank says I have?". For example, if the bank said I had 100 shares of Apple at the end of yesterday, and I bought 20 shares of Apple today, then we expect the bank to report 120 shares at the end of today. This surprisingly isn't always the case! The bank may send incomplete data, we may be parsing it incorrectly, or there may be events like corporate actions or trade settlement lag that cause an inconsistency.

Unit reconciliation is very important, because numbers that don't add up shouldn't be trusted for any metrics.

The Input:

recon.in has three sections:

D0-POS describes the positions in the account at the end of Day 0. Each record is a space-separated pair of Symbol and Shares. For example "AAPL 10" means 10 shares of AAPL were held at the end of Day 0, and "Cash 122.16" means we had $122.16 in the account at the end of Day 0.

D1-TRN describes the transactions that occurred in the account on Day 1. Each record is space-separated collection of four items: Symbol, Transaction Code, Shares, and Total Value. For example, the record "AAPL BY 10 6123.21" means 10 shares of AAPL were bought for a total cost of $6123.21.

D1-POS describes the positions in the account at the end of Day 1, and has the same format as D0-POS.

The Output:

The objective is to write a program that produces recon.out. Each line should be a space-separated record indicating a position that fails unit reconciliation. For example, "AAPL 10" means that the reported shares of AAPL in D1-POS is 10 higher than expected based on the transactions.

recon.in
--------
D0-POS
AAPL 100
GOOG 200
Cash 10

D1-TRN
AAPL SL 50 30000
GOOG BY 10 10000

D1-POS
AAPL 50
GOOG 220
Cash 20000



recon.out
---------
Cash -10
GOOG 10

*/

import java.util.List;
import java.util.HashMap;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class Reconciler {

  private static HashMap<String, Long> map = new HashMap<String, Long>();
  private static double cash = 0.0;
  private final static String PART1 = "D0-POS";
  private final static String PART2 = "D1-TRN";
  private final static String PART3 = "D1-POS";

  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get("../recon.in"));
    doRecon(lines);
  }

  private static void doRecon(List<String> lines) {
    String status = ""; 
    
    for(String line : lines) {
      // TODO: implement
      line = line.trim();
      if (line.equals(PART1)) {
          status = PART1;
          continue;
      } else if (line.equals(PART2)) {
          status = PART2;
          continue;
      } else if (line.equals(PART3)) {
          status = PART3;
          continue;
      } else if (line.equals("")) {
          continue;
      }
      
      String[] tokens = line.split(" ");
      
      if (status.equals(PART1)) {
          /* get data */
          getData(tokens);
      } else if (status.equals(PART2)) {
          /* analysis */
          analysis(tokens);
      } else if (status.equals(PART3)) {
          /* reconciliation */
          reconciliation(tokens);
      }
    }
  }
  
  private static void getData(String[] tokens) {
      String name = tokens[0].trim();
      long number = Long.parseLong(tokens[1].trim());
      
      if (name.equals("Cash")) {
          cash = number;
      } else if {
          map.put(name, number);
      }
  }

  private static void analysis(String[] tokens) {
      String name = tokens[0].trim();
      String action = tokens[1].trim();
      long number = Long.parseLong(tokens[2].trim());
      double money = Double.parseDouble(tokens[3].trim());
      
      if (action.equals("SL")) {
          if (!map.containsKey(name)) {
              System.out.println("Invalid transaction.");
          } else {
              cash += money;
              number = map.get(name) - number;
          }
      } else if (action.equals("BY")) {
          cash -= money;
          number = map.getOfDefault(name, 0) + number;
      }
      
      map.put(name, number);
      
      
  }
  
  private static void reconciliation(String[] tokens) {
      String name = tokens[0].trim();
      if (name.equals("Cash")) {
          double m = Double.parseDouble(tokens[1].trim());
          double diff = m - cash;
          if (diff != 0.0) {
              System.out.println("Cash" + diff);
          }
      } else {
          if (!map.containsKey(name)) {
              System.out.println("There is no " + name + " in file.");
          } else {
              long n = Long.parseLong(tokens[1].trim());
              long diff = n - map.get(name);
              if (diff != 0) {
                  System.out.println(name + " " + diff);
              }
          }
      }
  }
}
