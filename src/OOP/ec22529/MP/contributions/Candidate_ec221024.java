package OOP.ec22529.MP.contributions;

import java.util.Scanner;
import java.util.Random;

public class Candidate_ec221024 extends Candidate {


    private static int integerInput(String message)
    {
        Scanner keyboard = new Scanner(System.in);// Create scanner
        int input = 0;
        boolean invalidInput = true;

        while (invalidInput) {

            System.out.println(message); // Print message

            if (keyboard.hasNextInt())
            {
                input = keyboard.nextInt();

                if (input < 0)
                { // Check if user entered a positive number as scores can be equal to 0
                    System.out.println("ERROR! Please enter a positive value!");// Print error message
                }
                else
                {
                    invalidInput = false;
                }
            }
            else
            {
                keyboard.next();
                System.out.println("ERROR! You have not inputted an integer!");// Print error message
            }
        }
        return input;
    }

    private static String stringInput(String message){

        Scanner keyboard = new Scanner(System.in);
        System.out.println(message);
        String input = keyboard.nextLine();

        while (input == null | input.isEmpty()){  // the isEmpty to check if the string is empty

            System.out.println("ERROR! Please use one of the options shown above!");  // Error message

            input = keyboard.nextLine();
        }

        return input;
    }

    private static void addRandomCand(Candidate[] ElectedCandidates, Candidate[] AllCandidates, int CandidatesCount){

        int position = new Random().nextInt(AllCandidates.length);
        ElectedCandidates[CandidatesCount] = AllCandidates[position];
        CandidatesCount++;
    }

    /*
    Doesnt check the array to find the candidate
    
    private static void addSpecificCand(String name, Candidate[] ElectedCandidates,Candidate[] AllCandidates, int CandidatesCount){

        Candidate temp = A3.getByUsername(name,AllCandidates);
        if (temp != null){

            System.out.println("Cannot find candidate");

        } else {

            ElectedCandidates[CandidatesCount] = temp;
            CandidatesCount++;
        }
    }
    */
    
    private static void addSpecificCand(String username, Candidate[] ElectedCandidates, Candidate[] AllCandidates, int CandidatesCount) {

        Candidate candidateToAdd = null;
        for (Candidate candidate : AllCandidates) {
            if (candidate.getName().equals(username)) {
                candidateToAdd = candidate;
                break;
            }
        }
        if (candidateToAdd == null) {
            System.out.println("Cannot find candidate " + username);
        } else {
            ElectedCandidates[CandidatesCount] = candidateToAdd;
            CandidatesCount++;
        }
    }
      
     public static void main(String [] a){

        try {
        boolean exit = false;
        Candidate[] AllCandidates = A3.getCandidateArray();
        Candidate[] ElectedCandidates = new Candidate[AllCandidates.length];
        int CandidatesCount = 0;


        while(!exit){

            String choice = stringInput("Would you like to: a) add a specific candidate b) add a candidate at random c) run the election?");

            if (choice.equals("a")){

                String username = stringInput("Please enter a username.");
                addSpecificCand(username, ElectedCandidates, AllCandidates, CandidatesCount);
                System.out.println(ElectedCandidates[CandidatesCount]);

            }else if (choice.equals("b")){

                addRandomCand(ElectedCandidates, AllCandidates, CandidatesCount);
                System.out.println(ElectedCandidates[CandidatesCount]);

            }else if (choice.equals("c")){

                String judge = stringInput("Who should count the votes?");
                        int ElectionRuns = integerInput("How many times shall we run the election?");
                        Candidate[] Winner = new Candidate[ElectionRuns];


                        for(int i = 0; i < ElectionRuns; i++) {

                            Candidate[] votes = new Candidate[CandidatesCount];
                            for(int j = 0; j < votes.length; j++) {
                                try {
                                    votes[j] = (AllCandidates[j]).vote(ElectedCandidates);

                                } catch (Exception e) {

                                    votes[j] = new Candidate_ec221024();
                                    System.out.println(e);
                                }
                            }

                            Winner[i] = (A3.getByUsername(judge, AllCandidates)).selectWinner(votes);
                        }

                        System.out.println("Most common winner is:");
                        for(int u = 0; u < Winner.length; u++)
                        {
                            System.out.println((Winner[u]).getName());
                        }
                exit = true;

            }else{

                System.out.println("That wasn't an option!");

            }


        }
} catch (Exception e) {
         System.out.println("Something went wrong.");
}
    }

    

     

    //A2 CODE IS HERE--------------------------
    
    public String getName() {
        return "Aadam";
    }
    
    public String getSlogan() {
        return "Okaaay lets gooo!";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
        // If array is empty, return instance of this class.
        if (candidates.length == 0) 
            return new Candidate_ec221024();
        
        // Search for a like minded candidate.
        for (Candidate c : candidates)
            if (c.getSlogan().equals("Okaaay lets gooo!"))
                return c;
        
        // Otherwise, search for a friend.
        for (Candidate c : candidates)
            if (c.getName().equals("Ayo"))
                return c;
        
        // Otherwise, default to last candidate on list.
        return candidates[candidates.length-1];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        
        // If array is empty, return instance of this class.
        if (votes.length == 0) 
            return new Candidate_ec221024();
        
        // Default to first vote, but this will be over-written.
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
        
