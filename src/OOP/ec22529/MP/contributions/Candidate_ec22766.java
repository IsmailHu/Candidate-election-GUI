package OOP.ec22529.MP.contributions;// File Candidate_ec22766.java
//
// Machine generated stub for Assignment 2

class Candidate_ec22766 extends Candidate {
    
    public String getName() {
        return "Nikitha";
    }
    
    public String getSlogan() {
        return "More Trees! and World Peace!";
    }
    
    public Candidate vote(Candidate[] candidates) {
        Candidate r = new Candidate_ec22766();
        
        if (candidates.length != 0) 
        {
            
        // Add code that inspects the array candidates
        // calling the various methods of the Candidate objects
        // and finds a Candidate object to vote for.
        
            // Search for a like minded candidate.
            for (Candidate c : candidates)
                if ((c.getSlogan().equals("More trees!"))|(c.getSlogan().equals("World Peace!")))
                    return c;
        }
        
        return r;
    }
    
    public Candidate selectWinner(Candidate[] votes) {
 
        // Add code that either counts the votes
        // or uses some other way to return an element 
        // of the array vote as the winner of an election.
        Candidate winner;
        
        if (votes.length != 0)
        {
            // Default to 0 times.
            int numberOfVotes = 0;
            int[] numberOfVotesArray = new int[votes.length];
            //To count the number of times the element occurs in the array
            int k=0;
            while (k<votes.length)
            {
                Candidate candidate=votes[k];
                for (int i=0;i<votes.length;i++)
                {
                    if (candidate.equals(votes[i]))
                    {
                        numberOfVotes = numberOfVotes + 1; //Incrementing count as item is found in array allPeople
                    }
                }
                numberOfVotesArray[k]=numberOfVotes;
                k=k+1;
                numberOfVotes=0;
            }  
        
            //Default to first element in the array
            int largestNumber = numberOfVotesArray[0];
            Candidate largestSoFar = votes[0];
            for (int j=1;j<votes.length;j++)
            {
                if (largestNumber < numberOfVotesArray[j])
                {
                    largestNumber = numberOfVotesArray[j];
                    largestSoFar = votes[j];
                }
            }
            
            winner = largestSoFar; //The Candidate with the highest number of votes.
        }
        //if votes array has length of 0
        else
        {
            winner = new Candidate_ec22766();
        }
        return winner;
    }
    
}
