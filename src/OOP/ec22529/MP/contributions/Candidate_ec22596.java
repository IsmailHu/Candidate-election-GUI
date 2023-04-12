package OOP.ec22529.MP.contributions;// File Candidate_ec22596.java
//
// Machine generated stub for Assignment 2
import java.util.Random;
class Candidate_ec22596 extends Candidate {
    
    public String getName() {
        return "Omar";
    }
    
    public String getSlogan() {
        return "siiihhh";
    }
    
    public Candidate vote(Candidate[] candidates) {

        // First search for self on the list of candidates.
        for (Candidate c : candidates)
            if (c.getName().equals("omar"))
                return c;

        // Otherwise, default to ramdom candidate on list.
        Random r = new Random();
        int c = r.nextInt(candidates.length);
        return candidates[c];
    }

    public Candidate selectWinner(Candidate[] votesCast) {

        // If array is empty, return instance of this class.
        if (votesCast.length == 0)
            return new Candidate_ec22596();

        // Choose winner at random from votes cast.
        Random r = new Random();
        int c = r.nextInt(votesCast.length);
        return votesCast[c];
    }
    
}
