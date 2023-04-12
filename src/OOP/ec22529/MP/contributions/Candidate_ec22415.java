package OOP.ec22529.MP.contributions;// File Candidate_ec22415.java
//
// Machine generated stub for Assignment 2
import java.util.Random;

class Candidate_ec22415 extends Candidate {

    public String getName() {
        return "Walter Hartwell White";
    }
	
	public String getSlogan() {
        return "let me cook 🥺👉👈";
    }
	
	public Candidate vote(Candidate[] candidates) {
        // search for self in the candidates list 
        for (Candidate c : candidates) {
            if(c.getName().equals("Walter Hartwell White")) {
                return c;
            }
        }
		
		// or default to random 
			Random r = new Random();
			int c = r.nextInt(candidates.length);
			return candidates[c];
		}
		
	public Candidate selectWinner(Candidate[] votesCast) {
        // If array is empty, return instance of this class.
        if (votesCast.length == 0) 
            return new Candidate_ec22415();

        // or chose random
        Random r = new Random();
        int c = r.nextInt(votesCast.length);
        return votesCast[c];
    }

}
