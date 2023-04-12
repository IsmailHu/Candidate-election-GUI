package OOP.ec22529.MP.contributions;// File Candidate_ec21413.java
//
// Machine generated stub for Assignment 2
// Assignment 3

import java.util.Scanner;
import java.util.Random;

class Candidate_ec21413 extends Candidate {
    
    public String getName() {
        return "Khadijah";
    }
    
    public String getSlogan() {
        return "More trees!";
    }
    
    public Candidate vote(Candidate[] candidates) {
        // If array is empty, return instance of friend's class.
        if (candidates.length == 0) 
            return new Candidate_ec21416();
        
        // Search for a like minded candidate.
        for (Candidate c : candidates)
            if (c.getSlogan().equals("More trees!"))
                return c;
        
        // Otherwise, search for a friend.
        for (Candidate c : candidates)
            if (c.getName().equals("Safaa"))
                return c;
        
        // Otherwise, default to last candidate on list.
        return candidates[candidates.length-1];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        if (votes.length == 0){
            return new Candidate_ec21416();
        }
       
        else{
            Candidate currentWinner = votes[0];
            // Count the votes for each object in the array,
            // selecting one with the most.
            int highestCount = 0;
            for (Candidate c : votes) {
                int count = 0;
                for (Candidate x : votes)
                    if (x == c)
                        count++;
                if (count > highestCount) {
                    highestCount = count;
                    currentWinner = c;
                }
            }
            return currentWinner;
        }

    }
    
    public static String inputString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    //Takes input from the user and returns it as an integer
    public static int inputInteger(String message) {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println(message);
        return Integer.parseInt(scanner2.nextLine());
    }

    public static void main(String[] args) {
        //Creates an array of all the candidates by calling the A3 method
        Candidate[] allCandidates = A3.getCandidateArray();

        //Creates a new array at the size of candidates to add to
        Candidate[] votes = new Candidate[allCandidates.length];

        //Keep track of number of candidates
        int counter = 0;
        String input = inputString("Would you like to a) add a specific candidate b) add a candidate at random c) run the election?").toLowerCase();

        if (input.equals("a")){
            //Gets the username of candidate to add
            String username = inputString("Please enter a username.");
            Candidate newCandidate = A3.getByUsername(username, allCandidates);
            //Adds to the array
            votes[counter] = newCandidate;
            //Increases the index by 1
            counter++;
            printCandidates(votes, counter);
        } else if (input.equals("b")){
            //Generates a random number between the length of the candidates array and 0
            Random random = new Random();
            int randomInt = random.nextInt(allCandidates.length);
            //Adds to the array
            votes[counter] = allCandidates[randomInt];
            //Increases the index by 1
            counter++;
            printCandidates(votes, counter);
        } else if (input.equals("c")){
            String voteCounter = inputString("Who should count the votes?");
            Candidate chosenCounter = A3.getByUsername(voteCounter, allCandidates);
            //Asks the user the number of times they would like to run the election
            int howManyTimes = inputInteger("How many times shall we run the election?");
            //Calls the method that would run the election
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
                    winningCandidates[j] = new Candidate_ec21413();
                }
            }
        }
        //Stores the winning candidate
        Candidate actualWinner = voteCounter.selectWinner(winningCandidates);
        //Prints out the winner
        System.out.println("Most common winner is: " + actualWinner.getName());
    }
    
}
