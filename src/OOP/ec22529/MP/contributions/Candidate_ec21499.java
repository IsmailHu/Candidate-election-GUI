package OOP.ec22529.MP.contributions;// File Candidate_ec21499.java
//
// Machine generated stub for Assignment 2

class Candidate_ec21499 extends Candidate {
    
    public String getName() {
        return "Peter Parker";
    }
    
    public String getSlogan() {
        return "Your friendly neighbourhood Spiderman";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
        // If array is empty, return instance of this class.
        if (candidates.length == 0) 
            return new Candidate_ec21499();
        
        for (int i = 0; i < candidates.length; i++){
            if (candidates[i].getName().equals("Adam")){
                return candidates[i];
            }
        }
        
        for (int j = 0; j < candidates.length; j++){
            if (candidates[j].getSlogan().equals("I am speed")){
                return candidates[j];
            }
        }
        
        return candidates[candidates.length-1];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        
        // If array is empty, return instance of this class.
        if (votes.length == 0) 
            return new Candidate_ec21499();
        
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
            if (count >= highestCount) {
                highestCount = count;
                currentWinner = c;
            }
        }
        
        return currentWinner;
    }
    
}
