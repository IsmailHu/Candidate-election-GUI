package OOP.ec22529.MP.contributions;

import java.util.Random;
import java.util.Scanner;

class Candidate_ec22406 extends Candidate {

    // Candidate's name
    public String getName() {
        return "Big Smoke";
    }

    // Candidate's slogan
    public String getSlogan() {
        return "A number 9 large";
    }

    // Voting method
    public Candidate vote(Candidate[] candidates) {
        Random rand = new Random();

        // If array is empty, add myself
        if (candidates.length <= 0) {
            return new Candidate_ec22406();
        }

        // Check for Big Smoke
        for (Candidate x : candidates) {
            if (x.getName().equals("Big Smoke")) {
                return x;
            }
        }

        // Else, pick a random candidate
        int x = rand.nextInt(candidates.length);
        return candidates[x];
    }

    // Method to select the winner
    public Candidate selectWinner(Candidate[] candidates) {
        int topVote = 0;
        Candidate winner = new Candidate_ec22406();

        if (candidates.length <= 0) {
            return new Candidate_ec22406();
        }

        for (Candidate x : candidates) {
            int count = 0;

            // Go through array to count all the same votes
            for (Candidate y : candidates) {
                if (x == y) {
                    count = count + 1;
                }
            }

            // Takes the first candidate with the highest vote as the winner
            if (count > topVote) {
                topVote = count;
                winner = x;
            }
        }

        return winner;
    }

    // Helper method to get input from the user
    public static String getInputString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Helper method to get input from the user
    public static int getInputInt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }

    // Main method
    public static void main(String[] args) {
        Candidate[] allCandidates = A3.getCandidateArray();
        String candidateName;
        int numCandidates;

        numCandidates = getInputInt("How many candidates in the election?");
        Candidate[] candidatesList = new Candidate[numCandidates];

        for (int i = 0; i < numCandidates; i++) {
            System.out.println("Add candidates to the election: ");
            candidateName = getInputString("Enter a username");
            candidatesList[i] = A3.getByUsername(candidateName, allCandidates);
        }

        // Running the election
        // Selecting the candidate who will count the votes
        String voteCounterName = getInputString("Who should count the votes?");
        Candidate voteCounter = A3.getByUsername(voteCounterName, candidatesList);

        // Candidates vote
        int numElections = getInputInt("How many times should you run the election?");
        Candidate[] votes = new Candidate[numCandidates * numElections];

        for (int x = 0; x < numElections; x++) {
            for (int i = 0; i < numCandidates; i++) {
                votes[i + (x * numCandidates)] = candidatesList[i].vote(candidatesList);
            }
        }

        // Choosing the winner
        Candidate winner = voteCounter.selectWinner(votes);
        System.out.println("The winner was " + winner.getName());
    }
}
