package OOP.ec22529.MP.contributions;// File Candidate_ec22573.java
//
// Machine generated stub for Assignment 2
import java.util.Random;
class Candidate_ec22573 extends Candidate {
    
    public String getName() {
        return "DnlKhn";
    }
    
    public String getSlogan() {
        return "NoSlogan";
    }
    
 public Candidate vote(Candidate[] candidates) {
        
        // If array is empty, return instance of this class.
        if (candidates.length == 0) 
            return new Candidate_ec22573();
        
        // First search for Ades Name on the list of candidates.
        for (Candidate c : candidates)
            if (c.getName().equals("Adewale"))
                return c;
        
        // Otherwise, choose at random from list.
        Random r = new Random();
        int c = r.nextInt(candidates.length);
        return candidates[c]; 
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        
        // If array is empty, return instance of this class.
        if (votes.length == 0) 
            return new Candidate_ec22573();
        
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
            if (count >= highestCount) {
                highestCount = count;
                currentWinner = c;
            }
        }
        
        return currentWinner;
    }
    
}

