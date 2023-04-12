package OOP.ec22529.MP.contributions;// File Candidate_ec22503.java
//
// Machine generated stub for Assignment 2

import java.util.Random;

class Candidate_ec22503 extends Candidate {
    
    public String getName() {
        return "Buzz";
    }
    
    public String getSlogan() {
        return "To the infinity and beyond";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
        // Search for Buzz on the the list of candidates.
        for (Candidate c : candidates)
            if (c.getName().equals("Buzz"))
                return c;
        
        // If not choose random candidate on list.
        Random randome = new Random();
        int n = randome.nextInt(candidates.length);
        return candidates[n];
    }
    
    public Candidate selectWinner(Candidate[] votesCast) {
        
        // If array is empty return instance of this clas
        if (votesCast.length == 0) 
            return new Candidate_ec22503();
        
        // Choose winner random 
        Random random = new Random();
        int n = random.nextInt(votesCast.length);
        return votesCast[n];        
    }
}
