package OOP.ec22529.MP.contributions;// File Candidate_ec22548.java
//
import java.util.Random;
import java.util.Scanner;

       
class Candidate_ec22548 extends Candidate {
    //main calls the starting method
    public static void main(String[] args) {
        openingMenu();
    }
    
    public static void print(String string) {
        System.out.println(string);
    }
    
    //starting method
    public static void openingMenu() {
        print("= Running Repeated Elections =");
        A3 newA3 = new A3();
        Candidate[] candidates = newA3.getCandidateArray();
        Candidate[] candidatesToVote = new Candidate[0];
        mainMenu(candidates, candidatesToVote);
        return;
    }
    
    //main menu
    public static void mainMenu(Candidate[] candidates, Candidate[] candidatesToVote) {
        print("Candidates are");
        if (candidates.length == 0) {
            print("None");
        } else {
            for (int i=0; i<candidates.length; i++) {
                candidates[i].getName();
            }
        } 
        
        Scanner scanner = new Scanner(System.in);
        print("Would you like to a) add a specific candidate b) add a candidate at random c) run the election?");
        String option = scanner.nextLine();
        option = option.toLowerCase();
        
        if (option.equals("a")) {
            Candidate[] addCandidate = addCandidate(candidates, candidatesToVote);
        } else if (option.equals("b")) {
            Candidate[] randomCandidate = randomCandidate(candidates, candidatesToVote);
        }else if (option.equals("c")) {
            print("How many times shall we run the election?");
            int numberTimes = scanner.nextInt();
            Candidate[] runElection = runElection(candidates, candidatesToVote, numberTimes);
        }
        
        return;
    }
    
    //adds a candidate to the voting pool              
    public static Candidate[] addCandidate(Candidate[] candidates, Candidate[] candidatesToVote) {
        Scanner scanner = new Scanner(System.in);
        print("Please enter a username.");
        String username = scanner.nextLine();
        
        //searches for said candidate
        Candidate newCandidate = new Candidate_ec22548();  
        for (int i=0; i<candidates.length; i++) {
            if (candidates[i].un.equals(username)) {
            newCandidate = candidates[i];
                break;
            }
        }
        
        //if candidate not in list
        if (!(newCandidate.getName().equals("Eula Lawrence") && newCandidate.un.equals("ec22548"))) {
            Candidate[] randomCandidate = randomCandidate(candidates, candidatesToVote);
        }
        
        //adds candidate to list extended
        Candidate[] candidatesToVotesNew = extendCandidateList(candidates, candidatesToVote, newCandidate);
        return candidatesToVotesNew;
    }
    
    public static Candidate[] randomCandidate(Candidate[] candidates, Candidate[] candidatesToVote) {
        //gets a random item for the vote
        Random random = new Random();
        int randomNum = random.nextInt(candidates.length);
        Candidate newCandidate = candidates[randomNum];
        
        //adds candidate to list extended
        Candidate[] candidatesToVotesNew = extendCandidateList(candidates, candidatesToVote, newCandidate);
        return candidatesToVotesNew;
    }
    
    //adds candidate to list extended
    public static Candidate[] extendCandidateList(Candidate[] candidates, Candidate[] candidatesToVote, Candidate newCandidate) {
        Candidate[] candidatesToVotesNew = new Candidate[candidatesToVote.length + 1];
        for (int i=0; i<candidatesToVote.length; i++) {
            candidatesToVotesNew[i] = candidatesToVote[i];
        }
        candidatesToVotesNew[candidatesToVotesNew.length] = newCandidate;
        mainMenu(candidates, candidatesToVotesNew);
        return candidatesToVotesNew;
    }
    
    //main voting method
    public static Candidate[] runElection(Candidate[] candidates, Candidate[] candidatesToVote, int numberTimes) {
        //works out who is counting the votes
        Scanner scanner = new Scanner(System.in);
        print("Who should count the votes?");
        String username = scanner.nextLine();
        Candidate candidateCounter = new Candidate_ec22548();
        for (int i=0; i<candidates.length ;i++) {
            if (candidates[i].un.equals(username)) {
                candidateCounter = candidates[i];
                break;
            }
        }
        
        //does the counter with selected person as many times as was input
        Candidate[] winnerList = new Candidate[numberTimes];
        for (int x=0; x<numberTimes; x++) {
            Candidate[] votes = new Candidate[candidates.length];
            for (int y=0; y<candidates.length; y++) {
                votes[y] = candidates[y].vote(votes);
            }
            winnerList[x] = candidateCounter.selectWinner(votes);
        }

        //finds most common winner
        Candidate winner = new Candidate_ec22548();
        int highestFreq = 0;
        for (int x=0; x<numberTimes; x++) {
            int count = 1;
            for (int y=0; y<numberTimes; y++) {
                if (winnerList[x]==winnerList[y]) { 
                    count += 1;
                }
            }
            if (count>highestFreq) { 
                winner = winnerList[x];
                highestFreq = count;
            }
        }
        print("The winner overall is "+winner.getName()+" ("+winner.un+"): "+winner.getSlogan());
        
        return candidatesToVote;
    }
    
    public String getName() {
        return "Eula Lawrence";
    }
    
    public String getSlogan() {
        return "Cats should be promoted as gods";
    }
    
    public Candidate vote(Candidate[] candidates) {
        Candidate me = new Candidate_ec22548();
        
        //checks if the list is empty, if so returns a random candidate
        if (candidates.length==0) {
            return me;
        }
        
        //checks if name matches specific candidate in the list
        for (int c = 0; c<candidates.length; c++)
            if (candidates[c].getSlogan().equals("Cats should be promoted as gods"))
                return candidates[c];
        
        // Otherwise, choose at random from list.
        Random r = new Random();
        int c = r.nextInt(candidates.length);
        return candidates[c];
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        Candidate me = new Candidate_ec22548();
        
        if (votes.length == 0) {
            return me;
        }
        
        //creates a winner so when votes counted has an item to input intos
        Candidate winner = votes[0];
        int highestFreq = 0;
        
        //if it isn't empty does a nested loop to check
        for (int x=0; x<votes.length; x++) { 
            int count = 1;
            for (int y=0; y<votes.length; y++) {
                //if votes matches in both for loops adds a vote
                if (votes[x]==votes[y]) { 
                    count += 1;
                }
            }
            //after first for checks if the max votes has been surpassed, if it has replace it
            if (count>highestFreq) { 
                winner = votes[x];
                highestFreq = count;
            }
        }
        
        return winner;
    }  
}
