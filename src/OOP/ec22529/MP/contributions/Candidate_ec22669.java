package OOP.ec22529.MP.contributions;

class Candidate_ec22669 extends Candidate {
    
    public String getName() {
        return "Ershy";
    }
    
    public String getSlogan() {
        return "SEWEY";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
        // If array is empty, return instance of friend's class.
        if (candidates.length == 0) 
            return new Candidate_ec22669();
        
        // Search for a like minded candidate.
        for (Candidate c : candidates)
            if (c.getSlogan().equals("SEWEY"))
                return c;
        
        // Otherwise, search for a friend.
        for (Candidate c : candidates)
            if (c.getName().equals("Ershy"))
                return c;
        
        // Otherwise, default to last candidate on list.
        return candidates[candidates.length-1];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        
        // If array is empty, return instance of friend's class.
        if (votes.length == 0) 
            return new Candidate_ec22669();
        
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
