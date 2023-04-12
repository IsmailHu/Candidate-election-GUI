package OOP.ec22529.MP.contributions;

import java.util.Random;

class Candidate_ec22726 extends Candidate {
    
    public String getName() {
        return "Noor";
    }
    
    public String getSlogan() {
        return "More opportunities!";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
        // First search for self on the list of candidates.
        for (Candidate c : candidates)
            if (c.getName().equals("Noor"))
                return c;
        
        // Otherwise, default to ramdom candidate on list.
        Random r = new Random();
        int c = r.nextInt(candidates.length);
        return candidates[c];
    }
    
    public Candidate selectWinner(Candidate[] votesCast) {
        
        // If array is empty, return instance of this class.
        if (votesCast.length == 0) 
            return new Candidate_ec22726();
        
        
        // Choose winner at random from votes cast.
        Random r = new Random();
        int c = r.nextInt(votesCast.length);
        return votesCast[c];        
    }
}
