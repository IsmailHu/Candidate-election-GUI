package OOP.ec22529.MP.contributions;// File Candidate_ec22923.java
//
// Machine generated stub for Assignment 2

class Candidate_ec22923 extends Candidate {
    
    public String getName() {
        return "Otto";
    }
    
    public String getSlogan() {
        return "racecar";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
        // If array is empty, return instance of friend's class.
        if (candidates.length == 0) 
            return new Candidate_ec22578();
        
        // String slogan = c.getSlogan().toLowerCase();
        // String name = c.getName().toLowerCase();
        String reverseString = "";
        
        // Search for a slogan that's also a palindrome
        for (Candidate c : candidates)
        {
            for (int i = c.getSlogan().length() - 1; i >= 0; i--)
            {
                reverseString += c.getSlogan().toLowerCase().charAt(i);
            }
            if (reverseString.equals(c.getSlogan()))
            {
                return c;
            }
        }
        
        
        // Otherwise, search for a name that's a palindrome
        for (Candidate c : candidates)
        {
            for (int i =c.getName().length() - 1; i >= 0; i--)
            {
                reverseString += c.getName().toLowerCase().charAt(i);
            }
            if (reverseString.equals(c.getName()))
            {
                return c;
            }
        }
        
        // Otherwise, default to first candidate on list.
        return candidates[0];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        
        // If array is empty, return instance of friend's class.
        if (votes.length == 0) 
            return new Candidate_ec22578();
        
        Candidate evenWinner = votes[0]; // default winner
        int highestVotes = 0;

        for(int i = 0; i < votes.length; i++) { 
            int numVotes = 0;
            for(int j = 0; j < votes.length; j++) {
                if(votes[j] == votes[i]) {
                       numVotes++;
                }
            }
            if(numVotes > highestVotes) {
                highestVotes = numVotes;
                if(highestVotes % 2 == 0) // if the number of votes is an even number, then current winner
                {
                    evenWinner = votes[i];
                }
            }
        }
        
        
        return evenWinner;
    }
    
}
