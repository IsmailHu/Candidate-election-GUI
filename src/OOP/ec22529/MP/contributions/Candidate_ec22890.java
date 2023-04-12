package OOP.ec22529.MP.contributions;// File Candidate_ec22890.java
//
// Machine generated stub for Assignment 2

import java.util.Scanner;
import java.util.Random;

class Candidate_ec22890 extends Candidate{
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        boolean finished = false;
        Candidate[] all_Candidates = A3.getCandidateArray();
        Candidate[] all_votes = new Candidate[600];
        int j = 0;

        while(!finished)
        {
            String user_input = store_string("Would you like to a) add a specific candidate b) add a candidate at random c) run the election?");

            if (user_input.equals("a"))
            {
                String username = store_string("Please enter a username.");

                Candidate temp = A3.getByUsername(username, all_Candidates);
    
                if (temp != null)
                {
                    all_votes[j] = temp.vote(all_Candidates);
                    j++;
                }
                
                else
                {
                    System.out.println("please enter a valid username next time");
                }
            }
            else if (user_input.equals("b"))
            {
                Random random = new Random();

                int num_candidates = store_integer("How many random candidates do you want to add?");

                for(int i = 0; i < num_candidates; i++)
                { 
                    all_votes[j] = all_Candidates[random.nextInt(all_Candidates.length)].vote(all_Candidates);
                    j++;
                }
            }
            else if (user_input.equals("c"))
            {
                String username = store_string("Who do you want to run the election?");
                Candidate main_election_runner = A3.getByUsername(username, all_Candidates);

                int num_times = store_integer("How many times shall we run the election?");

                Candidate[] winners = new Candidate[num_times];
                    
                for(int i = 0; i < num_times; i++)
                {
                    winners[i] = main_election_runner.selectWinner(all_votes);
                }
                

                Candidate final_winner = final_winner(winners);

                System.out.println("Most common winner is " + final_winner.getName());
                System.out.println("There were no other winners");
            }
        }
    }

    public static Candidate final_winner(Candidate[] winners)
    {
        int current_highest = 0;
        int index = 0;

        for(int i = 0; i<winners.length; i++)
        {
            int count = 0;

            for(int j = 0; j<winners.length;j++)
            {
                if ((winners[i] == winners[j]))
                {
                    count++;
                }
            }
            
            if ((count > current_highest) && (index != i))
            {
                index = i;
            }

        }

        return (winners[index]);
    }

    public static int store_integer(String message){        
        Scanner scanner = new Scanner(System.in);
        int number = 0;

        System.out.println(message);

        if (scanner.hasNextInt())
        {
            number = Integer.parseInt(scanner.nextLine());

            if (number>0)
            {
                return number;
            }
            number = store_integer(message);
        }

        else
        {
            number = store_integer("please enter a valid number");
        }
    
        return number;
    }

    public static String store_string(String message)
    {
        Scanner scanner = new Scanner(System.in);

        String string;
            
        System.out.println(message);  

        string = scanner.nextLine();

        return string;
    }

    public String getName() {
        return "Mathew";
    }
    
    public String getSlogan() {
        return "Enjoy life!";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
        if (candidates.length == 0) 
            return new Candidate_ec22890();
        
        for (Candidate c : candidates)
            if (c.getSlogan().equals("Enjoy life!"))
                return c;
        
        for (Candidate c : candidates)
            if (c.getName().equals("kim"))
                return c;
        
        return candidates[candidates.length-1];
        
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        
       if (votes.length == 0) 
        {
            return new Candidate_ec22890();
        }

        int most_votes = 0;
        Candidate winning_candinate = votes[0]; 
    
        for(int i = 0; i < votes.length; i++)
        {
            int total_votes = 0;

            for(int j = 0; j < votes.length; j++)
            {
                if((votes[i] == votes[j]) && (votes[i] != null))
                {
                    total_votes++;
                }
            }

            if(total_votes >= most_votes)
            {
                winning_candinate = votes[i];
                most_votes = total_votes;
            } 
        }

        return winning_candinate;
    }
    

    
}
