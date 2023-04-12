package OOP.ec22529.MP.contributions;

class Candidate_ec22977 extends Candidate {
    
    public String getName() {
        return "Eren";
    }
    
    public String getSlogan() {
        return "More trees!";
    }
    
    public Candidate vote(Candidate[] candidates) {
        // If array is empty, return instance of friend's class.
        if (candidates.length == 0) 
            return new Candidate_ec22977();
        
        // Search for a like minded candidate.
        for (Candidate c : candidates)
            if (c.getSlogan().equals("More trees!"))
                return c;
        
        // Otherwise, search for a friend.
        for (Candidate c : candidates)
            if (c.getName().equals("Eren"))
                return c;
 
        // Add code that inspects the array candidates
        // calling the various methods of the Candidate objects
        // and finds a Candidate object to vote for.
        
        return candidates[candidates.length-1];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        
        // If array is empty, return instance of friend's class.
        if (votes.length == 0) 
            return new Candidate_ec22977();
        
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


            
