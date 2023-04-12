package OOP.ec22529.MP.contributions;

import java.util.Random;
import java.util.Scanner;

public class Candidate_ec221247 extends Candidate{
    
    public static void main(String[] args){
        
       // Candidate[] allContributions = A3.getCandidateArray();
        
        System.out.println("- Running repeated elecitions -");
        
        for(int i=0; i<10; i++){
            System.out.print("Would you like to a) add a specific candidate");
            System.out.println("b) add a candidate at random c) run the election");
            String input = getMessage();
            
            if(input.equals("a")){
            addSpecificCandidate();
            }
            else if(input.equals("b")){
            addRandomCandidate();
            }
            else if(input.equals("c")){
            runElection();
            return;
            }
        }
            return;
    }
    
    public static void addSpecificCandidate(){
       // String specificName = getString("Which specific user would you like to include?");
      //  Candidate specificCandidate = A2.getByUsername(specificName, allContributions);
       // if (specificCandidate != null) candidates[0] = specificCandidate;
       // else pr("User not found.");
        return;
    }
    
    public static void addRandomCandidate(){
      //  System.out.println(allContributions[42].getSlogan());
      //  System.out.println(A2.getByUsername("eey577",allContributions).getSlogan());
      //  System.out.println(allContributions[479].un);
        return;
    }
    
    public static void runElection(){
        return;
    }
    
        //get message from the user
    public static String getMessage() {
        String message;
        Scanner scanner= new Scanner(System.in);
        message = scanner.nextLine();
        return message;
    }


    public String getName() {
        return "Kumaran";
    }

    public String getSlogan() {
        return "Stronger Together!";
    }

    public Candidate vote(Candidate[] candidates) {
        
        // If array is empty, return instance of friend's class.
        if (candidates.length == 0)
            return new Candidate_ec22981();

        // Search for a like minded candidate.
        for (Candidate c : candidates)
            if (c.getSlogan().equals("Stronger Together!"))
                return c;

        // Otherwise, search for a friend.
        for (Candidate c : candidates)
            if (c.getName().equals("Andrew"))
                return c;

        // Otherwise, choose at random from list.
        Random r = new Random();
        int c = r.nextInt(candidates.length);
        return candidates[c];
    }

    public Candidate selectWinner(Candidate[] votes) {

        // If array is empty, return instance of friend's class.
        if (votes.length == 0)
            return new Candidate_ec22981();

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
