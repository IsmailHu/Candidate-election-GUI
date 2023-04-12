package OOP.ec22529.MP.contributions;

import java.util.Random;

class Candidate_ec221218 extends Candidate {
    
    public String getName() {
        return "Nadal";
    }    
        
    
     public String getSlogan() {
        return "Greatest Player";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
        // If array is empty, return instance of this class.
        if (candidates.length == 0) 
            return new Candidate_ec221218();
        
        // Search for a candidate involved in tennis.
        for (Candidate c : candidates)
            if (c.getSlogan().contains("Tennis"))
                return c;
                
        
        // Otherwise, choose at random from list.
        Random r = new Random();
        int c = r.nextInt(candidates.length);
        return candidates[c];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        
       
        if (votes.length == 0) 
            return new Candidate_ec221218();
        
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
