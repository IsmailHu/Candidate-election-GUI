package OOP.ec22529.MP.contributions;// File Candidate_ec221013.java

import java.util.Random;
import java.util.Scanner;

class Candidate_ec221013 extends Candidate {
    
    
    // Modified code from my Lab 1.1.5 Counting Occurences
    // to work with Candidate object
    static int numberOfTimes(Candidate x, Candidate[]  a)
    {
        int r = 0;
        for (int i = 0; i < a.length; i++)
        {
            if (x.equals(a[i]))
            {
                r++;
            }
        }
    
        return r;
    }

    static int[] eachNumberOfTimes(Candidate[] a)
    {
        int[] r = new int[a.length];
    
        // Loop that calls numberOfTimes.
        for (int i = 0; i < a.length; i++)
        {
            r[i] = numberOfTimes(a[i], a);
        }
    
        return r;
    }

    public static void main(String[] args)
    {
        Candidate[] allContributions = A3.getCandidateArray();
        Candidate[] electionCandidates = new Candidate[10];
        
        for (int i = 0; i < 10; i++)
        {

            System.out.println("a) Add specific candidate\nb) Add random candidate\nc) Run election");   
           
            Scanner keyboard = new Scanner(System.in); 
            String option = keyboard.nextLine();

            // Add specific candidates to an election
            if (option.equals("a"))
            {
                keyboard = new Scanner(System.in);
                System.out.println("Enter username: ");
                String specificName = keyboard.nextLine();

                Candidate specificCandidate = A3.getByUsername(specificName, allContributions);
                if (specificCandidate != null)
                {
                    electionCandidates[i] = specificCandidate;
                }

                else
                {
                    System.out.println("User not found. Random candidate added instead");
                    Random random = new Random();
                    electionCandidates[i] = allContributions[random.nextInt(allContributions.length)];
                }
            }
            
            else if (option.equals("b"))
            {
                System.out.println("Adding random candidate");
                Random random = new Random();
                electionCandidates[i] = allContributions[random.nextInt(allContributions.length)];
            }

            // Run the same election many times
            else if (option.equals("c"))
            {
                
            // Ask how many times, take as integer
                System.out.println("How many times should we run this election?");
                keyboard = new Scanner(System.in);
                System.out.println("Enter number: ");
                int elections = keyboard.nextInt();
            
            
            // Choose random selectWinner() method from other user methods
            // Look in Lab 1.1.5 Counting Occurences; create array returning most common winner for set of elections
                int indexOfMostCommon = 0;
                Candidate[] winnersArray = new Candidate[elections];
                for (int j = 0; j < elections; j++)
                {
                    
                    Random random = new Random();
                    winnersArray[j] = electionCandidates[random.nextInt(electionCandidates.length)].selectWinner(electionCandidates);
                    
                    // Report the most common winner(s).
                    // Counting occurences
                    int[] numberOfTimes = eachNumberOfTimes(winnersArray);
                    
                    // Highest value in array indicates most common winners
                    for ( int q = 1; q < winnersArray.length; q++ )
                    {
                        if (numberOfTimes[q] > numberOfTimes[indexOfMostCommon])
                        {
                            indexOfMostCommon = q;
                        }
                    }
                }
          
                System.out.println("Most common winner is: "+ winnersArray[indexOfMostCommon].getName());
                // Return this value
            }
            
            else
            {
                System.out.println("Adding random candidate");
                Random random = new Random();
                electionCandidates[i] = allContributions[random.nextInt(allContributions.length)];
            }
        }
    }
    
    public String getName()
    {
        return "Kenneth";
    }
    
    public String getSlogan()
    {
        return "Free boats for all!";
    }
    
    public Candidate vote(Candidate[] candidates)
    {
        // Empty array
        // If array is empty, return instance of this class.
        if (candidates.length == 0) 
            return new Candidate_ec221013();
        
        // Non-empty array
        // Search for instance of this class
        for (Candidate c : candidates)
            if (c.getName().equals("Kenneth"))
                return c;
        
        // Otherwise, search for a friend.
        for (Candidate c : candidates)
            if (c.getName().equals("Lee"))
                return c;
        
        // Otherwise, default to first candidate on list.
        return candidates[0];
    }
    
    public Candidate selectWinner(Candidate[] votes)
    {
        // Empty array
        // If array is empty, return instance of this class.
        if (votes.length == 0) {
            return new Candidate_ec221013();
        }

        // Non-empty array
        // Return middle array value
        int winnerIndex = votes.length / 2;
        Candidate winner = votes[winnerIndex];

        return winner;
    }
}
