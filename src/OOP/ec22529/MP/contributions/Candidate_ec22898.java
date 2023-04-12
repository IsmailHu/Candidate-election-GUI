package OOP.ec22529.MP.contributions;

class Candidate_ec22898 extends Candidate
{
    public String getName()
    {
        return "Sandeep";
    }

    public String getSlogan()
    {
        return "I will preavail!";
    }

    public Candidate vote(Candidate[] candidates)
    {
        // If array is empty, return instance of this class.
        if (candidates.length == 0)
        {
            return new Candidate_ec22898();
        }

        //searching for a friend
        for (Candidate c : candidates)
        {
            if (c.getName().equals("Ben"))
            {
                return c;
            }
        }
        
        // Otherwise, search for a like minded people.
        for (Candidate c : candidates)
        {
            if (c.getName().equals("Don't stop"))
            {
                return c;
            }
        }
        
        //otherwise return the last item in the candidate array
        return candidates[candidates.length-1];
    }

    public Candidate selectWinner(Candidate[] votes)
    {
        // If array is empty, return instance of this class.
        if (votes.length == 0) 
        {
            return new Candidate_ec22898();
        }

        // Default to first vote, but this will be over-written.
        Candidate currentWinner = votes[0];
        
        // Count the votes for each object in the array,
        // selecting one with the most.
        int highestCount = 0;
        for (Candidate c : votes) 
        {
            int count = 0;
            for (Candidate x : votes)
            {
                if (x == c)
                {
                    count++;  
                }
            }
            if (count >= highestCount) 
            {
                highestCount = count;
                currentWinner = c;
            }
        }
        
        return currentWinner;
    }
}
