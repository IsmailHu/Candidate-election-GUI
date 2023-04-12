package OOP.ec22529.MP.contributions;// File Candidate_ex21299.java
import java.util.Random;
import java.util.Scanner;

class Candidate_ex21299 extends Candidate {
    public static String inputstring(String question) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        String answer = scanner.nextLine();
        return answer;
    }

    public static int inputint(String question) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        String answer = scanner.nextLine();
        return Integer.parseInt(answer);
    }


    public static void main (String[] args) 
    {
        Candidate[] all_candidates = A3.getCandidateArray(); 
        Candidate[] voted_candidates = new Candidate[all_candidates.length]; 
        int count = 0; 

        String answer = inputstring("Would you like to a) add a specific candidate b) add a candidate at random c) run the election?");
        while(answer != "exit") 
        {
            if (answer.equals("a")) {
                String username = inputstring("Please enter a username.");
                voted_candidates[count] = A3.getByUsername(username, all_candidates); 
                count++;

                for(int i=0;i<count; i++) {
                    if(voted_candidates[i] != null) 
                        System.out.println((i+1) + "." + voted_candidates[i].getName()); 
                }
                answer = inputstring("Would you like to a) add a specific candidate b) add a candidate at random c) run the election?");
            }
            else if (answer.equals("b")) {

                int random_num = (new Random()).nextInt(all_candidates.length);
                voted_candidates[count] = all_candidates[random_num]; 
                count++;

                for(int i=0;i<count; i++) {
                    if(voted_candidates[i] != null) 
                        System.out.println((i+1) + "." + voted_candidates[i].getName()); 
                }
                answer = inputstring("Would you like to a) add a specific candidate b) add a candidate at random c) run the election?");
            }
            else if (answer.equals("c")) {
                String user_counter = inputstring("Who should count the votes?");
                Candidate counter = A3.getByUsername(user_counter, all_candidates);
                int x_times = inputint("How many times shall we run the election?");

                runElection(all_candidates, voted_candidates, counter, x_times, count);
                answer = "exit";
            }
        }
    }
    
    public static void runElection (Candidate[] all_candidates, Candidate[] voted_candidates, Candidate counter, int x_times, int count)
    {
        Candidate[] people_voted = new Candidate[count];
      
        for (int i=0; i<count; i++) {
            people_voted[i] = voted_candidates[i];
        }

        Candidate[] winners = new Candidate[x_times];
        Candidate[] evryones_votes = new Candidate[all_candidates.length];

        for (int i=0; i<x_times; i++) {
            for (int j=0; j<all_candidates.length; j++) {
                evryones_votes[j] = (all_candidates[j]).vote(people_voted); 
            }
            winners[i] = counter.selectWinner(evryones_votes);
        }

        Candidate actual_winner = counter.selectWinner(winners);
        System.out.println("The winner is " + actual_winner.getName());
    }
    
    public String getName() {
        return "Yash K";
    }
    
    public String getSlogan() {
        return "Save the oceans!";
    }
    
    public Candidate vote(Candidate[] candidates) {
        Candidate r = new Candidate_ex21299();
        
        if (candidates.length != 0) r = candidates[0];
 
        if (candidates.length == 0) 
            return new Candidate_ex21423();
        
        for (Candidate x : candidates)
            if (x.getSlogan().equals("No more university fees!"))
                return x;
        
        for (Candidate x : candidates)
            if (x.getName().equals("David J"))
                return x;
        
        
        return r;
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        Candidate r = new Candidate_ex21299();
        
        if (votes.length != 0) r = votes[0];
        
        int highestCount = 0;
        
        if (votes.length == 0) 
            return new Candidate_ex21423();
        
        for (Candidate c : votes) {
            
            int count = 0;
            for (Candidate x : votes)
                if (x == c)
                    count++;
            if (count > highestCount) {
                highestCount = count;
                r = c;
            }
        }
        
        return r;
    }
    
}
