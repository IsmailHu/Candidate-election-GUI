package OOP.ec22529.MP.contributions;// File Candidate_ec22445.java
//
// Machine generated stub for Assignment 2

// Kareem Al Yousef

import java.util.ArrayList;

class Candidate_ec22445 extends Candidate {
    
    public String getName() {
        return "Andrew";
    }
    
    public String getSlogan() {
        return "Teddy!";
    }
    
    public Candidate vote(Candidate[] candidates) {
        Candidate r = new Candidate_ec22445();
        
          if (candidates.length == 0 || candidates == null){
			return r;
		}

		// the first candidate with a name of six letters and a slogan longer than ten letters
		// If there is no such candidate, the slogan length requirement is lowered until it equals 0
		// Return my own class instance if no such candidate with name length 6 exists 
		ArrayList<Candidate> tempList = new ArrayList<Candidate>();
		for (int i = 0; i < candidates.length; i++){
			if (candidates[i].getName().length() == 6){
				tempList.add(candidates[i]);
			}
		}

		for (int necessarySloganLength = 10; necessarySloganLength > 0; necessarySloganLength--){
			for (int i = 0; i < tempList.size(); i++){
				if (tempList.get(i).getSlogan().length() > necessarySloganLength){
					return tempList.get(i);
				}
			}
		}
        
        return r;
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        Candidate r = new Candidate_ec22445();
        
        if (votes.length == 0 || votes == null){
			return r;
		}
        
        // The candidate with the most letters in the slogan, with an easy-to-remember name, wins the election!
		// Shorter names have a two times greater weighting than lengthier slogans
		// Score is calculated as follows: (name length * 2) / slogan length [Short name and long slogan provide greater score]
		int highestScore = -1000;
		int highestScorerIndex = 0;
		int currentVoteScore = 0;

		for (int i = 0; i < votes.length; i++){
			currentVoteScore = votes[i].getSlogan().length() - (votes[i].getName().length() * 2);

			if (currentVoteScore > highestScore){
				highestScore = currentVoteScore;
				highestScorerIndex = i;
			}
		} 

		r = votes[highestScorerIndex];
        
        return r;
    }
    
}
