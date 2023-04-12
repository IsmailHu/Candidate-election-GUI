package OOP.ec22529.MP.contributions;// File Candidate_ec221028.java
//
// Machine generated stub for Assignment 2
// Sefa A. Y.
// test commit 2 hooray
import java.util.ArrayList;

class Candidate_ec221028 extends Candidate {

    public static void main (String[] args){
	Candidate c = new Candidate_ec221028();
	Candidate[] allContributions = A3.getCandidateArray();
	String temp = "";
	for (int i = 0; i < allContributions.length; i++){
			temp = allContributions[i].getName();
			if (temp.length() > 7){
				if (temp.substring(0,7).equals("No name")){
				continue;
				}
			}
			System.out.println("Name: " + allContributions[i].getName());
            System.out.println("     Slogan: " + allContributions[i].getSlogan());
			System.out.println();
        }
        System.out.println(A3.getByUsername("eey577",allContributions).getSlogan());
        System.out.println(allContributions[479].un);
    
	//c = c.selectWinner(allContributions);
	//System.out.println("sefa voted for:" + c.getName() + ", slogan: " + c.getSlogan());
	}
	
    
    public String getName() {
        return "Mr. Bean";
    }
    
    public String getSlogan() {
        return "Teddy!";
    }
    
    public Candidate vote(Candidate[] candidates) {
        Candidate r = new Candidate_ec221028();
        if (candidates.length == 0 || candidates == null){
			return r;
		}
		
		// return first candidate with a name exactly six letters long and slogan longer than 10 letters long
		// if no such candidate exists reduce requirement for slogan length until slogan length == 0
		// if no such candidate with name length 6 exists (unlikely) return my own class instance (vote Mr. Bean)
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
        Candidate r = new Candidate_ec221028();
		if (votes.length == 0 || votes == null){
			return r;
		}
                // hello test
		// winner is decided by candidate with longest slogan, he is very persuasive, and his name easy to remember!
		// name is 2x weighted, shorter name more important than long slogan.
		// score is decided by slogan length - (name length * 2) [long slogan and short name results in higher score]
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
