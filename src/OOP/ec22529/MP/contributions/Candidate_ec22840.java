package OOP.ec22529.MP.contributions;// File Candidate_ec22840.java
//
// Machine generated stub for Assignment 2

import java.util.Random;

class Candidate_ec22840 extends Candidate 
{
    
    public String getName() {
        return "Meow";
    }
    
    public String getSlogan() {
        return "I always love Cat !!!!!";
    }
    
    public Candidate vote(Candidate[] candidates) 
    {
        Random x = new Random();
        int w = x.nextInt(100);
        Candidate m = candidates[0];
        
        if (candidates.length != 0) 
        {
            for (int i = 0; i < candidates.length; i++) 
            {
                w = w / 2 +1;
                m = candidates[w];
            }
            
        }
        return m;
        
    }
    
    public Candidate selectWinner(Candidate[] votes) 
    {
        
        if (votes.length > 0 & votes.length < 5) 
        return new Candidate_ec22840();
        
        Random x = new Random();
        int b = x.nextInt(200);
        Candidate v = votes[0];
        
        int hi = 0;
        if (votes.length > 50)
        {
            hi = 2*5/4*12;
            v = votes[hi];
            
        }
        else
        {
            v = votes[b];
        }
        
        return v;
    }
    
}
