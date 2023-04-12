package OOP.ec22529.MP.contributions;

class Candidate_ec22979 extends Candidate {
    
    public String getName() {
        return "Bill";
    }
    
    public String getSlogan() {
        return "Whenever I'm about to do something, I think, 'Would an idiot do that? ' And if they would, I do not do that thing.!";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
        
        if (candidates.length == 0) 
            return new Candidate_ec22802();
        
        // Search for a like minded candidate.
        for (Candidate c : candidates)
            if (c.getSlogan().equals("Whenever I'm about to do something, I think, 'Would an idiot do that? ' And if they would, I do not do that thing."))
                return c;
        
        // Otherwise, search for Joe
        for (Candidate c : candidates)
            if (c.getName().equals("Dwight"))
                return c;
        
        // Otherwise, default to 69th candidate on list.
        return candidates[69];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        
        // If array is empty, return instance of friend's class.
        if (votes.length == 0) 
            return new Candidate_ec22979();
        
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
