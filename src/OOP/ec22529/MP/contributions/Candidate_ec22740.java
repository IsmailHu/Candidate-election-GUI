package OOP.ec22529.MP.contributions;// File Candidate_ec22740.java
//
import java.util.Random;
import java.util.Scanner;

class Candidate_ec22740 extends Candidate {
    
    public static void main(String[] args) {
        boolean valid = true;
        
        while (valid) {
            String choice = inputString("Would you like to a) add a specific candidate b) add a candidate at random c) run the election?");
            
            if (choice.equals("a") || choice.equals("b") || choice.equals("c")) {
                valid = false;
            }
            else {
                userChoices(choice);
            }
        }
        
        return;
    }
    
    
    public static String inputString(String q) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(q);
        String a = scanner.nextLine();

    return a;
    }
    
    
    public static int inputInt(String q) {
        int input = Integer.parseInt(inputString(q));
        
        return input;
    }
    
    
    public static void userChoices(String choice) {
        Candidate[] allCandidates = A3.getCandidateArray();
        Candidate[] voteCandidates = new Candidate[allCandidates.length];
        
        int count = 0;
        
        if (choice.equals("a")) {
            voteCandidates = addSpecificCandidate (allCandidates, voteCandidates, count);
        }
         else if (choice.equals("b")){
            voteCandidates = addRandomCandidate (allCandidates, voteCandidates, count);
        } 
        else if (choice.equals("c")){
            runElections(allCandidates, voteCandidates, count);
        }
        
        return;
    }
    
    public static Candidate[] addSpecificCandidate (Candidate[] allCandidates, Candidate[] voteCandidates, int count) {
        String username = inputString("Please enter the username: ");
        Candidate newCandidate = A3.getByUsername(username, allCandidates);
            
        voteCandidates[count] = newCandidate;
        count++;
        
        return voteCandidates;
    }

    
    public static Candidate[] addRandomCandidate (Candidate[] allCandidates, Candidate[] voteCandidates, int count) {
        Random random = new Random();
        int randomInt = random.nextInt(allCandidates.length);

        voteCandidates[count] = allCandidates[randomInt];
        count++;
        
        return voteCandidates;
    }
    
    public static void runElections (Candidate[] allCandidates, Candidate[] voteCandidates, int count) {
        String voteCounter = inputString("Who should count the votes?");
        Candidate counter = A3.getByUsername(voteCounter, allCandidates);

        int timesRunElection = inputInt("How many times shall we run the election?");
        
        Candidate[] newElection = new Candidate[count];
        
        for (int i = 0; i < count; i++)
        {
            newElection[i] = voteCandidates[count];
        }
        
        Candidate[] winners = new Candidate[timesRunElection * (count -1)];
        
        for (int i = 0; i <= timesRunElection; i++)
        {
            for (int j = 0; j < count; j++)
            {
                try {
                    winners[(count * i) + j] = newElection[j].vote(newElection);
                }
                catch (Exception e) {
                    winners[j] = new Candidate_ec22740();
                }
            }
        }
        
        Candidate actualWinner = counter.selectWinner(winners);
        System.out.println("Most common winner is: " + actualWinner.getName());
        
        return;
    }

    public String getName() {
        return "Madara";
    }
    
    public String getSlogan() {
        return "Have fun!";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
        if (candidates.length == 0) {
            Candidate r = new Candidate_ec22740();
        }
    
        // Search for a like minded candidate.
        for (Candidate c:candidates)
            if (c.getSlogan().equals("Vote me for hacker points!"))
                return c;
        
        // Otherwise, search for a friend.
        for (Candidate c:candidates)
            if (c.getName().equals("Francois"))
                return c;
        
        // Otherwise, default to last candidate on list.
        return candidates[candidates.length-1];
    }
        
 
    public Candidate selectWinner(Candidate[] votes) {
        
        // If array is empty, return instance of this class.
        if (votes.length == 0) 
            return new Candidate_ec22740();
        
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
            if (count >= highestCount) {
                highestCount = count;
                currentWinner = c;
            }
        }
        
        return currentWinner;
    }
    
}
