package OOP.ec22529.MP.contributions;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

class Candidate_ec22467 extends Candidate {


    
    public static void main(String[] args)
    {
        Candidate [] ALLCANDI = A3.getCandidateArray();
        additional_candidates(ALLCANDI);
        return;
    }
    
    public static void pr(String message){
   
        System.out.println(message);
        return;
        
    }
       
       //getting users input
       public static String input (String message){

        Scanner scanner = new Scanner (System.in); 
        String inputs;


        System.out.println(message);
        inputs = scanner.nextLine(); 

        return inputs;
       }

        public static void additional_candidates(Candidate [] ALLCANDI)
        {

       
            ArrayList <Candidate> GetCandi = new ArrayList<Candidate>();

            Random r = new Random();
            String answer = " ";
        

            answer = input("Would you like to a) add a specific candidate b) add a candidate at random c) run the election?");
        
            while(!answer.equals("c")) 
            {
                int howBig = 0;
                if(answer.equals("a"))
                {
                    String ID = input("Please enter the username of the candidate you would like to add");   
                    Candidate specificCandidate = A3.getByUsername(ID, ALLCANDI);
                        if (specificCandidate != null)
                        {
                            GetCandi.add(specificCandidate);
                            pr("Candidates are:" + GetCandi);
                            howBig++;
                        }
            
                        else 
                        {
                            pr("User not found.");
                        }

                            if (answer.equals("b"))
                            {

                                //Random r = new Random();
                                int randomCandi = r.nextInt(ALLCANDI.length);
                                GetCandi.add(ALLCANDI[randomCandi]);
                                pr("Candidates are:" + GetCandi);
                            }
                            answer = input("Would you like to a) add a specific candidate b) add a candidate at random c) run the election?"); 

                        

                } 
            }
        

    
                // who should count the votes
                if(answer.equals("c"))
                {
                    String ID = input("Who should count the votes?");
                    Candidate  countingVotes = A3.getByUsername(ID, ALLCANDI);
                }
        }
    
     public String getName() {
        return "Gift";
    }
    
    public String getSlogan() {
        return "watch Transformers";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
        // returnS instance of friend's clas       
        if (candidates.length == 0) 
            return new Candidate_ec22411();
        
        // Search for candidate with same slogan as me.
        for (Candidate c : candidates)
            if (c.getSlogan().equals("watch Transformers"))
                return c;
        
        //search for a friend 
        for (Candidate c : candidates)
            if (c.getName().equals("Natalie"))
                return c;
        
        // if we cannot find a candidate who has the same slogan as me AND cannot find the instance of a friends class - return the last person in the array 
        return candidates[candidates.length-1];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        
        // If array is empty, return instance of Class Candidate_ec22467 which is my self
        if (votes.length == 0) 
            return new Candidate_ec22467();
        
        // Default to first vote, but this will be over-written.
        Candidate currentWinner = votes[0];
        
        // Count the votes for each object in the array,
        // The winner is who ever gets the most votes casted in the Candidate vote section
        int HC = 0;
        for (Candidate c : votes) {
            
            int countScore = 0;
            for (Candidate x : votes)
                if (x == c)
                    countScore++;
            if (countScore > HC) {
                HC = countScore;
                currentWinner = c;
            }
        }
        
        return currentWinner;
    }
 
}
