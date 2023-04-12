package OOP.ec22529.MP.contributions;// File Candidate_ec22551.java

import java.util.Scanner;

class Candidate_ec22551 extends Candidate {

    //comment+
    public String getName() {
        return "RK";
    }
    
    public String getSlogan() {
        return "Go big or go home!";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
        // if array is empty return instance of my own class
        if (candidates.length == 0)
        {
            return new Candidate_ec22551();
        }
        
        // search for a like minded candidate
        for (Candidate c : candidates)
        {
            if (c.getSlogan().equals("Go big or go home!"))
            {
                return c;
            } 
        }
        
        // search for myself otherwise
        for (Candidate c : candidates)
        {
            if (c.getName().equals("RK"))
            {
                return c;
            } 
        }
        
        // otherwise return last candidate on list
        return candidates[candidates.length-1];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        
        // if array is empty return instance of myself.
        if (votes.length == 0) 
            return new Candidate_ec22551();
        
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
    
    public static String printString(String message)
    {
        final String output;

        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        output = scanner.nextLine();
        return output;
    }
    
    public static int printInt(String message)
    {
        int output = 0;
        boolean isInt = false;
        Scanner scanner = new Scanner(System.in);

        while (!isInt)
        {
            System.out.println(message);
            if (scanner.hasNextInt())
            {
                output = scanner.nextInt();
                isInt = true;

            }
            else
            {
                System.out.println("ERROR: NON INTEGER INPUT GIVEN");
                scanner.next();
            }
        }
        return output;
    }
    
    public static void main(String[] args) 
    {
        final Candidate[] AllCandidates = A3.getCandidateArray();
        Candidate[] votes = new Candidate[AllCandidates.length];
        
        int numCandidates = printInt("Number Of candidates do you want to enter?: ");
        Candidate[] userCandidates = new Candidate[numCandidates];
        
        for (int i = 0; i < numCandidates; i++) 
        {
            String candidateUsername = printString("Please enter a username.");
            Candidate individual = A3.getByUsername(candidateUsername, AllCandidates);

            if (individual == null) 
            {
                System.out.println("ERROR: USER NOT FOUND");
                i--;
            }
            
            else 
            {
                userCandidates[i] = individual;
            }
        }
        
        System.out.println("Candidates are");
        for (int x = 0; x < userCandidates.length; x++) 
        {
            System.out.println((x + 1) + ". " + userCandidates[x].getName());
        }
        
        Candidate check = new Candidate_ec22551();
        String usernameCounter;
        boolean isRational = false;
        
        while (!isRational) 
        {
            usernameCounter = printString("Who should count the votes?");
            check = A3.getByUsername(usernameCounter, userCandidates);

            if (check == null) {
                System.out.println("ERROR: USER NOT FOUND");

            } else {
                isRational = true;

            }
        }
        
        boolean runs = false;
        int numRuns = 0;
        while (!runs) 
        {
            numRuns = printInt("How many times shall we run the election?");

            if (numRuns > 0) {
                runs = true;
            } else {
                System.out.println("Number is Positive. Try Again");
            }

        }
        
        Candidate[] Winners = new Candidate[numRuns];

        for (int y = 0; y < numRuns; y++) {
            for (int x = 0; x < AllCandidates.length; x++) {
                try {
                    votes[x] = AllCandidates[x].vote(userCandidates);
                } catch (Exception e) {
                    System.out.println("ERROR WITH USERNAME:" + AllCandidates[x]);
                    x++;
                }
            }

            Winners[y] = check.selectWinner(votes);
        }
        
        int highest = 0;
        int normal = 0;

        Candidate largestWinner = Winners[0];
        for (int i = 0; i < Winners.length; i++) {
            normal = 1;
            for (int j = 0; j < Winners.length; j++) {
                if (Winners[i] == Winners[j]) normal++;
            }


            if (normal > highest) {
                highest = normal;
                largestWinner = votes[i];
            }

        }
        System.out.println("Most common winner is " + largestWinner.getName());
     
    }
    
}
