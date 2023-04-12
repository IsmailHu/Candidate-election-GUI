package OOP.ec22529.MP.contributions;// File Candidate_ec22419.java
//
// Machine generated stub for Assignment 2

import java.util.Random;
import java.util.Scanner;

class Candidate_ec22419 extends Candidate {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean val = true;
        while (val) {
            System.out.print(
                    "Would you like to a) add a specific candidate b) add a candidate at random c) run the election? d)exit ");
            String ans = scanner.nextLine();
            if (ans.equals("d")) {
                val = false;
            } else {
                requiredTask(ans);
            }
        }
    }

    public static void requiredTask(String option) {
        Candidate[] allContributions = A3.getCandidateArray();
        Candidate[] addCandidates = new Candidate[allContributions.length];
        int x = 0;
        if (option.equals("a")) {
            addCandidates = addCandidate(allContributions, addCandidates, x);
            x++;
        } else if (option.equals("b")) {
            addCandidates = addRandomCandidate(allContributions, addCandidates, x);
            x++;
        } else if (option.equals("c")){
            runElection(allContributions,x,addCandidates);
        } else {
            System.out.println("Invalid input.");
        }
    }

    public static Candidate[] addCandidate(Candidate[] allCandidates, Candidate[] addCandidates, int x) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the candidate's username: ");
        String inputReceived = scanner.nextLine();
        Candidate CandidateName = A3.getByUsername(inputReceived, allCandidates);
        addCandidates[x] = CandidateName;
        return addCandidates;
    }

    public static Candidate[] addRandomCandidate(Candidate[] allCandidates, Candidate[] addCandidates, int x) {
        Random random = new Random();
        int ranNum = random.nextInt(allCandidates.length);
        addCandidates[x] = allCandidates[ranNum];
        return addCandidates;
    }

    public static void runElection(Candidate[] allCandidates, int x, Candidate[] addCandidates) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username who should count votes: ");
        String inputReceived = scanner.nextLine();
        Candidate voteCounter = A3.getByUsername(inputReceived, allCandidates);

        

        System.out.print("How many times should we run the election? ");
        int noTimes = scanner.nextInt();

        Candidate[] listOfVotes = new Candidate[noTimes * allCandidates.length];


        for (int electionNum = 0; electionNum < noTimes; electionNum++) {

            for (int i = 0; i < allCandidates.length; i++) {
                try {
                    listOfVotes[(electionNum * allCandidates.length) + i] = allCandidates[i].vote(addCandidates);
                } catch (Exception e) {
                    listOfVotes[(electionNum * allCandidates.length) + i] = new Candidate_ec22419();
                }
            }
        }
        Candidate winner = voteCounter.selectWinner(listOfVotes);
        System.out.println("The winner is: " + winner.getName());
    }
    
    public String getName() {
        return "Naomi";
    }
    
    public String getSlogan() {
        return "End Global Warming!";
    }
    
    public Candidate vote(Candidate[] candidates) {
            
         if (candidates.length == 0){
            return new Candidate_ec22419();
        }
        
        for (Candidate c : candidates){
            if (c.getSlogan().equals("End Global Warming!")){
                return c;
            }
        }
        
        // Otherwise, search for a friend.
        for (Candidate c : candidates)
            if (c.getName().equals("David")){
                return c;
            }
        
        // Otherwise, default to last candidate on list.
        return candidates[candidates.length-1];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        if (votes.length == 0){
            return new Candidate_ec22419();
        }
        
        // Default to first vote, but this will be over-written.
        Candidate currentWinner = votes[0];
        
        // Count the votes for each object in the array,
        // selecting one with the most.
        int highestCount = 0;
        for (Candidate c : votes) {
            
            int count = 0;
            for (Candidate x : votes){
                if (x == c){
                    count++;
                }
            }
            if (count > highestCount) {
                highestCount = count;
                currentWinner = c;
            }
        }
        
        return currentWinner;
    }
    
}
