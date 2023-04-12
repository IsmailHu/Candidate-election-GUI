package OOP.ec22529.MP.contributions;// File Candidate_ec22418.java
//
// Machine generated stub for Assignment 2

import java.util.Random;

class Candidate_ec22418 extends Candidate {
    
    public String getName() {
        return "Adekoyejo";
    }
    
    public String getSlogan() {
        return "Tax the rich!";
    }
    
    public Candidate vote(Candidate[] candidates) {
     
        // Add code that inspects the array candidates
        // calling the various methods of the Candidate objects
        // and finds a Candidate object to vote for.
        
         // First search for self on the list of candidates.
        for (Candidate c : candidates)
            if (c.getName().equals("Adekoyejo")) {
                return c;
            }

        // Otherwise search for a like minded candidate.
        for (Candidate b : candidates)
            if (b.getSlogan().equals("Tax the rich!")) {
                return b;
            }
        
        // Otherwise, default to random candidate on list.
        Random r = new Random();
        int d = r.nextInt(candidates.length);
        return candidates[d];
     
    }
    
    public Candidate selectWinner(Candidate[] votes) {
 
        // Add code that either counts the votes
        // or uses some other way to return an element 
        // of the array vote as the winner of an election.
        
        // If array is empty, return instance of this class.
        if (votes.length == 0) {
            return new Candidate_ec22418();
        }
        
        // Default to first vote, but this will be over-written.
        Candidate currentWinner = votes[0];
        
        // Count the votes for each object in the array,
        // selecting one with the most.
        int highestCount = 0;
        for (Candidate c : votes) {
            int count = 0;
            for (Candidate x : votes) {
                if (x == c) {
                    count++;
                }
            }
            
            if (count >= highestCount) {
                highestCount = count;
                currentWinner = c;
            }
        }
        
        return currentWinner;
        
    }
    
}
