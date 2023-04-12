package OOP.ec22529.MP.contributions;

import java.util.Random;
import java.util.Scanner;

class Candidate_ec22697 extends Candidate {
    
    public static void main(String[] args) {
        askChoice();
    }

    // Asks the user a question and returns their answer
    public static String askQ(String question)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(question);
        
        return scanner.nextLine();
    }

    // Prints the given string
    public static void print(String s) {
        System.out.println(s);
        return;
    }

    // Asks user for their choice
    public static void askChoice() {
        boolean valid = false;

        while (!valid) {
            print("Would you like to");
            print("a) exit");
            print("b) run same election many times"); //They should only be ablle to do a and b
            print("c) check who counts honestly");
            print("d) run all possible two-candidate elections");
            print("e) run a higher-order election");
            print("f) ...\n");

            String choice = askQ("");

            if (choice.equalsIgnoreCase("a")) {
                valid = true; // a doesn't need its own method
            } else if (choice.equalsIgnoreCase("b")) {
                choiceB();
                valid = true;
            } else if (choice.equalsIgnoreCase("c")) {
                return;
            } else if (choice.equalsIgnoreCase("d")) {
                return;
            } else if (choice.equalsIgnoreCase("e")) {
                return;
            }
            else if (choice.equalsIgnoreCase("f")) {
                return;
            }
            else {
                print("Sorry. Please enter a, b, c, d, e or f.");
            }
        }
        return;
    }

    // Prints all the candidates currently in an election
    public static void printElectionCandidates(Candidate[] electionCandidates, int candidatesAdded) {
        if (electionCandidates[0] == null) {
            print("None");
            return;
        }
        else {
            for (int i = 0; i < candidatesAdded; i++) {
                print((i+1) + ". " + electionCandidates[i].getName());
            }
        }
        print("");
        return;
    }

    // Allows the user to run an election as many times as they specifiy
    public static void choiceB() {
        Candidate[] allContributions = A3.getCandidateArray();
        final int MAX_NUM_CANDIDATES = allContributions.length;
        boolean valid = false;
        int candidatesAdded = 0;

        Candidate[] electionCandidates = new Candidate[MAX_NUM_CANDIDATES];

        print("= Running Repeated Elections =");

        while(!valid) {

            print("\nCandidates are");
            printElectionCandidates(electionCandidates, candidatesAdded);  // should print all the candidates currently in the election

            // HOW WILL THE LIST OF CANDIDATES BE CREATED?
            // GET MAX SIZE OF ARRAY BY FINDING OUT HOW MANY DIFFERENT CANDIDATES THERE ARE
            // THEN INIT ARRAY OF CANDIDATES OF THIS SIZE
            // KEEP TRACK OF NUMBER OF CANDIDATES ADDED USING VAR

            // THEN IF C CHOSEN, 
            // ONLY LOOP FROM BEGINNING OF ARRAY TO VALUE OF CANDIDATES ADDED - USE <?
            // THEN DO C!


            String choice = askQ("Would you like to a) add a specific candidate b) add a candidate at random c) run the election?\n> ");

            if (choice.equalsIgnoreCase("a") & candidatesAdded < MAX_NUM_CANDIDATES) {
                candidatesAdded = addSpecificCandidate(allContributions, electionCandidates, candidatesAdded); // ADD THIS TO ARRAY
            } else if (choice.equalsIgnoreCase("b") & candidatesAdded < MAX_NUM_CANDIDATES) {
                candidatesAdded = pickRandomCandidate(allContributions, electionCandidates, MAX_NUM_CANDIDATES, candidatesAdded);
            } else if (choice.equalsIgnoreCase("c") & candidatesAdded > 0) {
                // c - only return/valid = true here

                int numOfElections = numberOfElections();
                Candidate candidateDoingElection = askCandidateRunElection(allContributions);

                runElection(numOfElections, candidatesAdded, candidateDoingElection, electionCandidates);

                return;
            } else {
                print("\nSorry, that's an invalid choice. Please enter a, b or c.\n");
            }
        }
        return;
    }

    // Allows the user to add a specified candidate to an election
    public static int addSpecificCandidate (Candidate[] allContributions, Candidate[] electionCandidates, int indexToAdd) { // CURRENTLY DOESN'T RETURN A CANDIDATE
        boolean valid = false;
        Candidate userCandidate = allContributions[0]; // Just so java can be happy - name of this is John Cena

        while (!valid) {
            String candidateName = askQ("Please enter a username\n> ");
            userCandidate = A3.getByUsername(candidateName, allContributions);
            
            if (userCandidate == null) print("\nSorry, invalid username. Please try again.");
            else {
                valid = true;
            } 
        }

        electionCandidates[indexToAdd] = userCandidate;

        indexToAdd += 1;

        return indexToAdd;
    }

    // Picks a random candidate for an election
    public static int pickRandomCandidate(Candidate[] allContributions, Candidate[] electionCandidates, int TOTAL_NUM_CANDIDATES, int indexToAdd) { // SHOULD HAVE RETURN TYPE OF CANDIDATE
        Random random = new Random();

        int index = random.nextInt(TOTAL_NUM_CANDIDATES);

        electionCandidates[indexToAdd] = allContributions[index];

        indexToAdd += 1;

        return indexToAdd;
    }

    // Checks if user's input is an int (and greater than 0) and prompts them until it is
    public static int validateIntInput(String question, String answer) {
        boolean validAns = false;
        int intAns = 0;

        while (!validAns) {
            try {
                intAns = Integer.parseInt(answer);
            } catch (Exception e) {
                print("Sorry, please enter an integer greater than 0.");
                answer = askQ(question + "\n> ");
            }

            if (intAns <= 0) {
                print("Sorry. You must enter an integer greater than 0");
                answer = askQ(question + "\n> ");
            } else {
                validAns = true;
            }
        }

        return intAns;
    }

    // Runs an election based on given candidates
    public static void runElection(int numOfTimes, int numCandidatesAdded, Candidate winnerSelector, Candidate[] electionCandidates) {
        Candidate[] electionWinners = new Candidate[numOfTimes];

        int numOfWinners = 0;


        for (int i = 0; i < numOfTimes; i++) {

            try {
                electionWinners[numOfWinners] = winnerSelector.selectWinner(electionCandidates);
                numOfWinners += 1;
            }
            catch (Exception e) {
                print(e + "");
                print("Oops. Something went wrong");
                return;
            }
            // run election
            // add winner to array
        }

        countMostFrequentW(electionWinners);
        // count most frequent winner in array
        // print their name

        return;
    }

    // Counts the most frequent candidate in an array and prints their name
    public static void countMostFrequentW(Candidate[] winners) {
        
        // if (votes.length == 0) { --- shouldn't be able to have an empty winners array right???
        //     return new Candidate();
        // }
        // else {

        int largestNumOfVotes = 0;
        Candidate mostPopularCandidate = winners[0];

        for (int i = 0; i < winners.length; i++) {
            int numberOfVotes = 0;

            for (int j = 0; j < winners.length; j++) {
                if (winners[j] == winners[i]) {
                    numberOfVotes += 1;
                }
            }

            if (numberOfVotes > largestNumOfVotes) {
                largestNumOfVotes = numberOfVotes;
                mostPopularCandidate = winners[i];
            }
        }


        try {
            print("Most common winner is " + mostPopularCandidate.getName());
            print("There were no other winners.");

        }
        catch (Exception e) {
            print("Sorry something went wrong");
        }

        // what to do if more than 1 winner?
        //}
        
        return;
    }

    // Asks the user to name a candidate to run an election
    public static Candidate askCandidateRunElection(Candidate[] allContributions) {
        boolean valid = false;
        Candidate c = allContributions[0]; // yet again to make java happy

        while (!valid) {
            String candidateName = askQ("Who should count the votes?\n> ");
            c = A3.getByUsername(candidateName, allContributions);
            
            if (c == null) print("\nSorry, invalid username. Please try again.");
            else {
                valid = true;
            } 
        }

        return c;
    }



    // Asks the user how many times they want to run an election
    public static int numberOfElections() {
        print("How many times shall we run the election?");
        String choice = askQ("> "); // make new method to validate ints

        int intChoice = validateIntInput("How many times shall we run the election?", choice);

        return intChoice;
    }

    public String getName() {
        return "Palpatine";
    }
    
    public String getSlogan() {
        return "Vote for me - I AM the Senate after all";
    }
    
    // Votes for Palpatine - who said liberty is dead anyway?
    public Candidate vote(Candidate[] candidates) {
        Candidate emperor = new Candidate_ec22697(); 

        return emperor;
    }
    
    // Counts the number of candidates which begin with a C and selects the candidate found at that position in the votes array as the winner
    // Or it just returns Palpatine as the winner if the votes array is empty
    public Candidate selectWinner(Candidate[] votes) {
        Candidate winner = new Candidate_ec22697();
        
        if (votes.length == 0) return winner;

        int numberOfCs = 0;
        
        for (int i = 0; i < votes.length; i++) {
            if (votes[i].getName().charAt(0) == 'C') {
                numberOfCs += 1;
            }
        }

        winner = votes[numberOfCs];
        
        return winner;
    }
    
}
