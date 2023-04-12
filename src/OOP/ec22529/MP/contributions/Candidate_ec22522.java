package OOP.ec22529.MP.contributions;// File Candidate_ec22522.java
//
// Machine generated stub for Assignment 2

class Candidate_ec22522 extends Candidate {
    
    public String getName() {
        return "Sami";
    }
    
    public String getSlogan() {
        return "Criminalise becoming a Candidate once I'm in charge";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
        // If array is empty, return instance of friend's class.
        if (candidates.length == 0) 
            return new Candidate_ec22510();
        
        // Search for a like minded candidate.
        for (Candidate c : candidates)
            if (c.getSlogan().equals("FRANCIUM FOR SENATE!!!"))
                return c;
        
        // Otherwise, search for a friend.
        for (Candidate c : candidates)
            if (c.getName().equals("Ehimen"))
                return c;
        
        // Otherwise, default to last candidate on list.
        return candidates[candidates.length-1];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        Candidate r = new Candidate_ec22522();
        
        if (votes.length != 0) 
            r = votes[0];
 
        // Add code that either counts the votes
        // or uses some other way to return an element 
        // of the array vote as the winner of an election.
        
        return r;
    }
    
}
