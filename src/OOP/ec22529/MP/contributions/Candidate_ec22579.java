package OOP.ec22529.MP.contributions;// File Candidate_ec22579.java
//
// Machine generated stub for Assignment 2
//From sample ac1234

class Candidate_ec22579 extends Candidate {
    
    public String getName() {
        return "Obi-wan Kenobi";
    }
    
    public String getSlogan() {
        return "May the force be with you!";
    }
    
    public Candidate vote(Candidate[] candidates) {
        Candidate r = new Candidate_ec22579();
        
        if (candidates.length != 0) r = candidates[0];
 
        // Add code that inspects the array candidates
        // calling the various methods of the Candidate objects
        // and finds a Candidate object to vote for.
        
        // If array is empty, return instance of friend's class.
        if (candidates.length == 0) 
            return new Candidate_ec22441();
        
        // Search for a like minded candidate.
        for (Candidate c : candidates)
            if (c.getSlogan().equals("May the force be with you!"))
                return c;
        
        // Otherwise, search for a friend.
        for (Candidate c : candidates)
            if (c.getName().equals("Rochelle"))
                return c;
        
        return r;
    }
    
    public Candidate selectWinner(Candidate[] votes) {
 
        // If array is empty, return instance of friend's class.
        if (votes.length == 0) 
            return new Candidate_ec22441();
        
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
