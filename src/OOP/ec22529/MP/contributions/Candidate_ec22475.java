package OOP.ec22529.MP.contributions;// File Candidate_ec22475.java
//
// Machine generated stub for Assignment 2
import java.util.Random;

class Candidate_ec22475 extends Candidate {
    
    public String getName() {
        return "Uto";
    }
    
    public String getSlogan() {
        return "Road of Resistance";
    }
    
    public Candidate vote(Candidate[] candidates) {

        for (Candidate c : candidates)
            if (c.getName().equals("Uto"))
                return c;
        
        Random r = new Random();
        int c = r.nextInt(candidates.length);
        return candidates[c];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
  
        if (votes.length == 0) 
            return new Candidate_ec22475();
        
        // Choose winner at random from votes
        Random r = new Random();
        int c = r.nextInt(votes.length);
        return votes[c];        
        
    }
    
}
//Added a comment 
