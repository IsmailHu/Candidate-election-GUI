package OOP.ec22529.MP.contributions;

import java.util.Random;

class Candidate_ec22707 extends Candidate {
    
    public String getName() {
        return "Boris";
    }
    
    public String getSlogan() {
        return "It's Party Time!";
    }
    
    public Candidate vote(Candidate[] candidates) {
        if (candidates.length == 0) 
            return new Candidate_ec22707();
        
        for (Candidate c : candidates)
            if (c.getName().equals("Boris"))
                return c;
        
        Random r = new Random();
        int c = r.nextInt(candidates.length);
        return candidates[c];
    }
    
    public Candidate selectWinner(Candidate[] votesCast) {
        if (votesCast.length == 0) 
            return new Candidate_ec22707();
        
        Random r = new Random();
        int c = r.nextInt(votesCast.length);
        return votesCast[c];
    }
}

//comment for lab 4
//another comment