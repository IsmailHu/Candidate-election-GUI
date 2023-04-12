package OOP.ec22529.MP.contributions;

// File Candidate_ex21541.java
//
// Machine generated stub for Assignment
// This is a comment
class Candidate_ex21541 extends Candidate {
    
    public String getName() {
        return " Sid the Sloth ";
    }
    
    public String getSlogan() {
        return "My names Sid";
    }
    
    public Candidate vote(Candidate[] candidates) {
        Candidate r = new Candidate_ex21541();
        
        if (candidates.length != 0) r = candidates[0];
 
        // Add code that inspects the array candidates
        // calling the various methods of the Candidate objects
        // and finds a Candidate object to vote for.
        
        return r;
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        Candidate r = new Candidate_ex21541();
        
        if (votes.length != 0) r = votes[0];
 
        // Add code that either counts the votes
        // or uses some other way to return an element 
        // of the array vote as the winner of an election.
        
        return r;
    }
    
}
