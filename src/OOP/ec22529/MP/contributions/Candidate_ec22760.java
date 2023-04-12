package OOP.ec22529.MP.contributions;// File Candidate_ec22760.java
//
// Machine generated stub for Assignment 2

class Candidate_ec22760 extends Candidate {
    
    public String getName() {
        return "McQueen";
    }
    
    public String getSlogan() {
        return "I am speed";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
        // if array is empty, return an instance of this class.
        if(candidates.length == 0){
            return new Candidate_ec22760();
        }
        
        // Start by searching Adam from the list of candidates.
        for(int i = 0; i<candidates.length; i++){
            if(candidates[i].getName().equals("Adam")){
                return candidates[i];
            }
        }
        
        // Then, search for this slogan from the list.
        for(int z = 0; z<candidates.length; z++){
            if(candidates[z].getSlogan().equals("More Trees!")){
                return candidates[z];
            }
        }
         
        // Otherwise, default to the last candidate. 
        return candidates[candidates.length-1];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        
        // if array is empty, return an instance of this class.
        if(votes.length == 0) return new Candidate_ec22760();
        
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
