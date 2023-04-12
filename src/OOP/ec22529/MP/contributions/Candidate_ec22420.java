package OOP.ec22529.MP.contributions;// File Candidate_ec22420.java

import java.util.Random;

class Candidate_ec22420 extends Candidate {
    
    public String getName() {
        return "Humairaa";
    }
    
    public String getSlogan() {
        return "Chop life, dont let life chop you.";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
        for (Candidate c : candidates)
            if (c.getName().equals("Alesha"))
                return c;
        
        // Otherwise, default to ramdom candidate on list.
        Random r = new Random();
        int c = r.nextInt(candidates.length);
        return candidates[c];
    }
    
    public Candidate selectWinner(Candidate[] votesCast) {
        
        // If array is empty, return instance of this class.
        if (votesCast.length == 0) 
            return new Candidate_ec22420();
        
        // Choose winner at random from votes cast.
        Random r = new Random();
        int c = r.nextInt(votesCast.length);
        return votesCast[c];        
    }
}
