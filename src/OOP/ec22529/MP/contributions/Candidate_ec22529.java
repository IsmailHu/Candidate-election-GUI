package OOP.ec22529.MP.contributions;// File Candidate_ec22529.java
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Candidate_ec22529 extends Candidate {
    
    public String getName() {
        return "Ismail";
    }
    
    public String getSlogan() {
        return "Ismail for President";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
        if (candidates.length == 0)
        {  
            return new Candidate_ec22529();
        }

        for (Candidate c : candidates)
            if (c.getSlogan().equals("Ismail for president"))
            {
                return c;
            }
        for (Candidate c : candidates)
            if (c.getName().equals("Ismail"))
                return c;
	    
        return candidates[candidates.length-1];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        
        if (votes.length == 0) 
            return new Candidate_ec22529();
        
        Candidate currentWinner = votes[0];
        
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
    //this code below is credit to ec22761
    private static boolean candidateNameInArray(String username, Candidate[] candidates) {

        boolean isValid = false;
        for(Candidate c : candidates) {
            if(c.un.equals(username)) {
                isValid = true; break;
            }
        }

        return isValid;
    }

    public static int askIntQuestion(String question, Scanner scanner) {
        System.out.println(question);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter your response as an integer.");
            System.out.println();
            return askIntQuestion(question, scanner);
        }
    }

    private static Candidate[] tallyCandidates(Candidate[] array) {
        String name = askStringQuestion("Who should count the votes?");
        while(!candidateNameInArray(name, A3.getCandidateArray())) {
            System.out.println("Not a valid candidate!");
            name = askStringQuestion("Who should count the votes?");
        }
        Candidate counter = A3.getByUsername(name, A3.getCandidateArray());

        Scanner scanner = new Scanner(System.in);
        int numberOfTimes = askIntQuestion("How many times should we run the election?", scanner);
        Candidate[] winners = new Candidate[numberOfTimes];

        for(int i = 0; i < numberOfTimes; i++) {
            winners[i] = findWinner(array, counter);
        }

        return winners;
    }

    private static Candidate findWinner(Candidate[] array, Candidate counter) {
        Candidate[] votes = new Candidate[A3.getCandidateArray().length];

        // Populate array with votes
        for(int i = 0; i < A3.getCandidateArray().length; i++) {
            try {
                votes[i] = A3.getCandidateArray()[i].vote(array);
            } catch(Exception e) {
                // Log that the candidate could not vote
            }
        }

        // Find most present candidate in array
        return counter.selectWinner(votes);
    }

    private static Candidate findActualWinner(Candidate[] votes) {

        Candidate currentWinner = votes[0];
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

    private static Candidate getRandomCandidate() {
        Random r = new Random();
        return A3.getCandidateArray()[r.nextInt(A3.getCandidateArray().length - 1)];
    }

    private static void displayCandidates(Candidate[] candidates) {
        System.out.println("Candidates are:");
        for(Candidate c : candidates) {
            System.out.println(c.getName());
        }
    }
    private static String askStringQuestion(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        return scanner.nextLine();
    }
    private static char selectOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to... \nA) Add a specific candidate \nB)"
                + " Add a candidate at random \nC) Run the election? \nD) Display the current candidates slogans? \nE) Exit");
        return scanner.nextLine().charAt(0);
    }
    public static void main(String[] args) {

        char selection = selectOption();
        ArrayList<Candidate> list = new ArrayList<Candidate>();

        while (selection != 'e' && selection != 'E') {


            if(selection == 'a' || selection == 'A') {

                String name = askStringQuestion("What is the username of the candidate?");
                while(!candidateNameInArray(name, A3.getCandidateArray())) {
                    System.out.println("Not a valid candidate!");
                    name = askStringQuestion("What is the username of the candidate?");
                }

                list.add(A3.getByUsername(name, A3.getCandidateArray()));
                displayCandidates(list.toArray(new Candidate[0]));
            }
            else if(selection == 'b' || selection == 'B') {
                list.add(getRandomCandidate());
                displayCandidates(list.toArray(new Candidate[0]));
            }
            else if(selection == 'c' || selection == 'C') {

                if(list.size() > 0) {
                    Candidate[] winners = tallyCandidates(list.toArray(new Candidate[0]));
                    Candidate winner = findActualWinner(winners);
                    System.out.println("The most present winner was: " + winner.getName() + "!");

                    int otherWinners = 0;
                    for(Candidate c : winners) {
                        if(!c.getName().equals(winner.getName())) {
                            otherWinners++;
                        }
                    }

                    String otherWinnersPresent = otherWinners > 0 ? "There were no other winners." : "There were " + otherWinners + " votes for other winners!";
                    System.out.println(otherWinnersPresent);



                } else {
                    System.out.println("No-one to vote for!");
                }


            }
            else if (selection == 'd' || selection == 'D') {
                if(list.size() > 0) {
                    list.forEach(c -> {
                        if(c.getSlogan()!=null) System.out.println(c.getName() + "'s slogan is: " + c.getSlogan());
                    });
                } else {
                    System.out.println("No-one to listen to!");
                }
            }


            else if(selection != 'e' && selection != 'E') {
                System.out.println("Not a valid option.");
            }

            selection = selectOption();
        }
    }
}
