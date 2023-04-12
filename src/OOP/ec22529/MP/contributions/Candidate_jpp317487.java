package OOP.ec22529.MP.contributions;// File Candidate_jpp317487.java
//
// Assignment 3

import java.util.Random;
import java.util.Scanner;

class Candidate_jpp317487 extends Candidate {

  //input returns it as a string
  public static String inputString(String message) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(message);
    return scanner.nextLine();
  }

  //input returns it as an integer
    public static int inputInteger(String message) {
      Scanner scanner2 = new Scanner(System.in);
      System.out.println(message);
      return Integer.parseInt(scanner2.nextLine());
    }
    
    public String getName() {
        return "Finngolfinn";
    }
    
    public String getSlogan() {
        return "24 pack!";
    }

    public static void main(String[] args) {
      Candidate[] allCandidates = A3.getCandidateArray();

      Candidate[] votes = new Candidate[allCandidates.length];

      int counter = 0;
      String input = inputString("Would you like to a) add a specific candidate b) add a candidate at random c) run the election?").toLowerCase();
      

      if (input.equals("a")){
        String username = inputString("Please enter a username.");
        Candidate newCandidate = A3.getByUsername(username, allCandidates);
        votes[counter] = newCandidate;
        counter++;
        printCandidates(votes, counter);
      } else if (input.equals("b")){
        Random random = new Random();
        int randomInt = random.nextInt(allCandidates.length);
        votes[counter] = allCandidates[randomInt];
          counter++;
          printCandidates(votes, counter);
      } else if (input.equals("c")){
          String voteCounter = inputString("Who should count the votes?");
          Candidate chosenCounter = A3.getByUsername(voteCounter, allCandidates);
          int howManyTimes = inputInteger("How many times shall we run the election?");
          runElection(votes, counter, howManyTimes, chosenCounter, allCandidates);
      }
    }


    public static void printCandidates(Candidate[] candidates, int counter) {
      //Prints all the candidates in the current election
      System.out.println("Candidates are: ");
      for (int i = 0; i < counter; i++) {
          System.out.println(candidates[i].getName() + " with their slogan: " + candidates[i].getSlogan());
      }
      return;
    }

  public static void runElection(Candidate[] votes, int counter, int howManyTimes, Candidate voteCounter, Candidate[] allCandidates){
      //Creates an array filled with candidates
      Candidate[] newElection = new Candidate[counter];
      for (int i = 0; i < counter; i++) {
          newElection[i] = votes[counter];
      }

      Candidate[] winningCandidates = new Candidate[howManyTimes * (counter - 1)];
      //Repeat as many times as the user requests
      for (int i = 0; i <= howManyTimes; i++) {
          for (int j = 0; j < counter; j++) {
              try {
                  winningCandidates[(counter * i) + j] = newElection[j].vote(newElection);
              } catch (Exception e) {
                  //If voting doesn't work, vote for myself
                  winningCandidates[j] = new Candidate_jpp317487();
              }
          }
      }
      //Stores the winning candidate
      Candidate actualWinner = voteCounter.selectWinner(winningCandidates);
      //Prints out the winner
      System.out.println("Most common winner is: " + actualWinner.getName());
    }



    public Candidate vote(Candidate[] candidates)
    {
        // If array is empty, return instance of this class.
        if (candidates.length == 0)
        {
            return new Candidate_jpp317487();
        }

        //searching for a friend
        for (Candidate c : candidates)
        {
            if (c.getName().equals("Finn"))
            {
                return c;
            }
        }
        // Otherwise, search for a like minded people.
        for (Candidate c : candidates)
        {
            if (c.getName().equals("Moby"))
            {
                return c;
            }
        }
        //otherwise return the last item in the candidate array
        return candidates[candidates.length-1];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        Candidate r = new Candidate_jpp317487();
        
        if (votes.length == 0){
            return new Candidate_jpp317487();
        }
        Candidate currentWinner = votes[0];
 
        int highestCount = 0;
        for (Candidate c : votes) 
        {
            int count = 0;
            for (Candidate x : votes)
            {
                if (x == c)
                {
                    count++;  
                }
            }
            if (count >= highestCount) 
            {
                highestCount = count;
                currentWinner = c;
            }
        }
        return currentWinner;
    }
    
}
