package OOP.ec22529.MP.contributions;

class Candidate_ec22723 extends Candidate {
    
    public String getName() {
        return "Rohaan";
    }
    
    public String getSlogan() {
        return "More video games";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
       
        if (candidates.length == 0) 
            return new Candidate_ec22723();
     
        for (Candidate c : candidates)
            if (c.getSlogan().equals("More video games"))
                return c;
        
      
        for (Candidate c : candidates)
            if (c.getName().equals("Mebs"))
                return c;
        
      
        return candidates[candidates.length-1];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        
       
        if (votes.length == 0) 
            return new Candidate_ec22723();
        
       
        Candidate currentWinner = votes[0];
        
       
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
