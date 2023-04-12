package OOP.ec22529.MP.contributions;// File Candidate_jpp308479.java
//
// Machine generated stub for Assignment 2
import java.util.Random;
class Candidate_jpp308479 extends Candidate {
    
    public String getName() {
        return "Nikita";
    }
    
    public String getSlogan() {
        return "More doors";
    }
    
    public Candidate vote(Candidate[] candidates) {
        Random r = new Random();
        int c = r.nextInt(candidates.length);
        return candidates[c];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        Random r = new Random();
        int c = r.nextInt(votes.length);
        return votes[c];

    }
    
}
