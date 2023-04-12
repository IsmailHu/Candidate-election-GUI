package OOP.ec22529.MP.contributions;// File Candidate_ec22532.java
//
// Machine generated stub for Assignment 2

import java.util.Random;
import java.util.Scanner;

class Candidate_ec22532 extends Candidate {
    public String getName(){
        return "Usman"; //The string returned by your class's getName() method must not be longer than 15 characters.
    }

    public String getSlogan() {
        return "Deez Nuts"; //The string returned by your getSlogan() must not be longer than 40 characters.
    }

    public Candidate vote(Candidate[] candidates) {
        if (candidates.length == 0){ //When passed an empty array, your vote(Candidate[]) and selectWinner(Candidate[]) methods must not throw an exception.
            return new Candidate_ec22532();
        }

        //When passed a non-empty array, your vote(Candidate[]) and selectWinner(Candidate[]) must return an object from that array, so no write-in votes or surprise winners. (This will be tested.)

        boolean selfFound = false;
        Candidate toReturn = null;
        for (int c = 0; c < candidates.length; c ++){
            if (candidates[c].getName().equals("Usman")){
                selfFound = true;
                toReturn = candidates[c];
            }
        }

        if (selfFound = true){
            return toReturn;
        }
        else {
            Random r = new Random();
            int randomToReturn = r.nextInt(candidates.length);
            return candidates[randomToReturn];
        }
        
    }

    
    public Candidate selectWinner(Candidate[] votes) {
        if (votes.length == 0) { //When passed an empty array, your vote(Candidate[]) and selectWinner(Candidate[]) methods must not throw an exception.
            return new Candidate_ec22532();
        }

        //When passed a non-empty array, your vote(Candidate[]) and selectWinner(Candidate[]) must return an object from that array, so no write-in votes or surprise winners. (This will be tested.)
        
        //Chooses winner with the longest name
        Candidate toReturn = null;
        int largestSize = 0;
        for (Candidate v: votes){
            if (v.getName().length() > largestSize){
                largestSize = v.getName().length();
                toReturn = v;
            }
        }

        return toReturn;
    }

    

    public static void main(String[] args){
    
        Candidate[] candidates = A3.getCandidateArray(); //Create an array of candidates
        Candidate[] candidates2 = new Candidate[candidates.length]; //Create another of same size
        //int c = 0;
        //String name = "";

        boolean optionA = false;
        char chosenOption = ' ';


        while (optionA = false){
            chosenOption = inputChar("Would you like to \n a) exit \n b) add a specific candidate \n c) add a random candidate \n d) run the election");
            
            
            if (chosenOption == 'a'){
                optionA = true;
            }
            else if (chosenOption == 'b'){
                try{
                    candidates2 = optionB(candidates, candidates2, 1000);
                }
                catch(Exception e){
                    
                }
            }
            else if (chosenOption == 'c'){
                try{
                    candidates2 = optionC(candidates, candidates2, 1000);
                }
                catch(Exception e){
                    
                }
            }
            else if (chosenOption == 'd'){
                try{
                    optionD(candidates, candidates2, 1000);
                }
                catch(Exception e){

                }
                
            }


        }
        



    }

    public static Candidate[] optionB(Candidate[] candidates, Candidate[] candidates2, int index){ //specific cand
        String nameToAdd = inputString("Please enter a username.");
        Candidate toAdd = A3.getByUsername(nameToAdd, candidates2);

        if (toAdd != null){
            candidates[index] = toAdd;
        }
        else{
            System.out.println("Unknown candidate.");
        }

        return candidates;
    }

    public static Candidate[] optionC(Candidate[] candidates, Candidate[] candidates2, int index){ //random cand
        Candidate toAdd = candidates2[randomInt(candidates2.length)];
        candidates[index] = toAdd;
        return candidates;
    }

    public static void optionD(Candidate[] candidates, Candidate[] candidates2, int index){ //election
        Candidate[] allCandidates = new Candidate[index];

        for (int i = 0; i < index; i++){
            allCandidates[i] = candidates[i];
        }  

        String name = inputString("Who will count the votes? ");
        Candidate CounterCandidate = A3.getByUsername(name, allCandidates);

        int electionCycles = inputInt("How many times will the election run?");
        Candidate[] winners = new Candidate[electionCycles];

        for (int e = 0; e < electionCycles; e++){
            Candidate[] votes = new Candidate[candidates2.length];
            for (int i = 0; i < candidates2.length; i ++){
                votes[i] = candidates2[i].vote(allCandidates);
            }
            winners[e]= CounterCandidate.selectWinner(votes);
        }

        Candidate[] mostCommonWinners = new Candidate[allCandidates.length];
        mostCommonWinners = findMostCommoWinner(winners, candidates, allCandidates);
        
        if (mostCommonWinners.length == 1){
            System.out.println("The most common winner is: " + mostCommonWinners[0] );

        }
        else if (mostCommonWinners.length > 1){
            System.out.println("The most common winners are: ");
                for (int w = 0; w < mostCommonWinners.length; w++){
                    System.out.println(mostCommonWinners[w]);
                }
        }
        else{
            System.out.println("There were no winners");
        }



    }

    public static Candidate[] findMostCommoWinner(Candidate[] winners, Candidate[] candidates, Candidate[] allCandidates){
        if (winners == null){
            return null;
        }

        int mostWins = 0;
        int noWinners = 1;
        Candidate[] finalWinners = new Candidate[allCandidates.length];
        
        for (int i = 0; i < allCandidates.length; i++){
            int c = 0;
            for (int j = 0; j < winners.length; j ++){
                if(winners[j].equals(allCandidates[i])){
                    c ++;
                }
            }


            if (c > mostWins){ //if another winner has more than the previously thought highest winner
                mostWins = c;
                finalWinners[0] =  candidates[i];
                noWinners = 1;
            }
            else if(c == mostWins){ //if two or more winners have the same number of wins
                noWinners ++;
                finalWinners[noWinners - 1] = candidates[i];
            }
        }

        return finalWinners;


    }



    public static int randomInt(int param){
        Random r = new Random();
        int n = r.nextInt(param);
        return n;
    }


    public static char inputChar(String msg){
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        char c = scanner.nextLine().charAt(0);
        return c;
    }

    public static String inputString(String msg){
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        String s = scanner.nextLine();
        return s;
    }

    public static int inputInt(String msg){
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        int n = scanner.nextInt(0);
        return n;
    }

}
