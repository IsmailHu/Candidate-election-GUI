package OOP.ec22529.MP.contributions;

class Candidate_ec20258 extends Candidate {

    public String getName() {
        return "John Doe";
    }

    public String getSlogan() {
        return "I don't really want to win tbh.";
    }

    public Candidate vote(Candidate[] candidates) {
        Candidate r = new Candidate_ec20258();
        
        if(candidates.length==0)
        {
            return new Candidate_ec20258();
        }
        
  

        return r;
    }

    public Candidate selectWinner(Candidate[] votes) {
  
          if (votes.length == 0)      // If nothing in the array
        {
            return new Candidate_ec20258(); // Claim I won.
        }

      

        // Add code that either counts the votes
        // or uses some other way to return an element 
        // of the array vote as the winner of an election.
         // Default to first item.
        Candidate winner = votes[0]; 

        // Track highest votes currently
        int currentHighest = 0;

        //Loop over every vote
        for (int i=0; i<votes.length; i++)
        {
            int currentCount = 0;

            //count how many times a vote has been repeated so far
            for (int j=0; j<i; j++)
            {
                if (votes[i].getName() == votes[j].getName()) {currentCount++;}
            }

            // keep track of current highest count (winner)
            if (currentCount > currentHighest)
            {
                currentHighest = currentCount;
                winner = votes[i];
            }
        }

        return winner;


      
    }
    
}
