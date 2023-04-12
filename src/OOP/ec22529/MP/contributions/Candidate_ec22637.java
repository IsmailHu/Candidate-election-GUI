package OOP.ec22529.MP.contributions;// File Candidate_ec22637.java
//
// Machine generated stub for Assignment 2

class Candidate_ec22637 extends Candidate
{
    
    public String getName()
    {
        return "Daniel";
    }
    
    public String getSlogan()
    {
        return "Escape the matrix and find reality";
    }
    
    public Candidate vote(Candidate[] candidates)
    {
    	if (candidates.length == 0)
    		return new Candidate_ec22637();	
        
        // Search for a friend
        for (Candidate c : candidates)
        	if (c.getName().equals("Theo"))
        		return c;
       
        return candidates[candidates.length-1];
    }
    
    public Candidate selectWinner(Candidate[] votes)
    {
    	if (votes.length == 0)
    		return new Candidate_ec22637();
    	
    	Candidate currentWinner = votes[0];
    	
    	int highestCount = 0;
    	for (Candidate c : votes)
    	{
    		int count = 0;
    		for (Candidate x : votes)
    			if (x == c)
    				count++;
		if (count > highestCount)
		{
			highestCount = count;
			currentWinner = c;
		}
	}
	
        // Search for a condidate with the slogan "More Sleep!"
        for (Candidate winner : votes)
            if (winner.getSlogan().equals("More Sleep!"))
                return winner;
        
        return currentWinner;
    }
}
