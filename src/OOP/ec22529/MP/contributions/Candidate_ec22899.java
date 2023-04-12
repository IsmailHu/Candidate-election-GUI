package OOP.ec22529.MP.contributions;

import java.util.Scanner;

class Candidate_ec22899 extends Candidate
{
    public static void main(String args[])
    {

        int counter = 0;

        Candidate[] allCandidates = A3.getCandidateArray();

        int ARRAY_SIZE = allCandidates.length;
        Candidate[] votes = new Candidate[ARRAY_SIZE];



        System.out.println("Would you like to a) add a specific candidate b) run the election?");

        Scanner scanner = new Scanner(System.in);
        String y = scanner.nextLine();

        if (y.equals("a"))
        {
            counter++;
            addSpecificCandidate(scanner,votes,allCandidates);
        }
        else if (y.equals("b"))
        {
            runElection(scanner,votes,allCandidates,counter);
        }

    }

    public static void runElection(Scanner scanner,Candidate[] votes, Candidate[] allCandidates, int counter)
    {
        Boolean quit = false;
        Candidate voteCounter = null;

        while (quit == false)
        {

            System.out.println("Who should count the votes?");
            String username = scanner.nextLine();

            voteCounter = A3.getByUsername(username, allCandidates);

            if (voteCounter == null)
            {
                System.out.println("user not found");
            }
            else
            {
                quit = true;
            }
            
        }

        System.out.println("How many times shall we run the election?");
        int NumOfRuns = scanner.nextInt();


        // inspired by ec22763
        Candidate[] newElec = new Candidate[counter];

        for(int i = 0; i < counter; i++){
        newElec[i] = votes[counter];
        }

        Candidate[] winner = new Candidate[NumOfRuns * (counter -1)];

        for (int i = 0; i <= NumOfRuns; i++){
            for (int j = 0; j < counter; j++){
                winner[(counter*i) + j] = newElec[j].vote(newElec);
            }
        }

        Candidate actualWinner = voteCounter.selectWinner(winner);
        System.out.println("Most common winner is: " + actualWinner.getName());


    }

    public static void addSpecificCandidate(Scanner scanner,Candidate[] votes, Candidate[] allCandidates)
    {
        Boolean quit = false;

        while (quit == false)
        {
            System.out.println("Please enter a username.");
            String username = scanner.nextLine();
    
            Candidate votee = A3.getByUsername(username, allCandidates);
    
            if (votee == null)
            {
                System.out.println("user not found");
            }
            else
            {
                quit = true;
                addToArray(votes,votee);
            }
    
            
    
        }
        
    }

    public static void addToArray(Candidate[] array,Candidate item) // adds an item to the array
    {
        for (int i = 0; i <= 1000; i++)
        {
            if (array[i] == null)
            {
                array[i] = item;
                break;
            }
        }    
    }

    
    public String getName() {
        return "Eren";
    }
    
    public String getSlogan() {
        return "Tatakae";
    }
    
    public Candidate vote(Candidate[] candidates)
    {        
        // if array is empty return object of my class
        if (candidates.length == 0)
        {
           return new Candidate_ec22899();
        }

        // search for an identical candidate
        for (Candidate c : candidates)
        {
            if (c.getName().equals("Eren") && c.getSlogan().equals("Tatakae"))
            {
                return c;
            }
        }
        
        // returns first item if identical item doesnt exist
        return candidates[0];
    }
    
    public Candidate selectWinner(Candidate[] votes)
    {

        // returns instnace of my class if array is empty
        if (votes.length == 0) 
            return new Candidate_ec22899();
 
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
    
}
