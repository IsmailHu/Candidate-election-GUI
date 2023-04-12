package OOP.ec22529.MP.contributions;

import java.util.Random;
import java.util.Scanner;
class Candidate_ec22872 extends Candidate{
    
    public String getName() {
        return "Harry Potter";
    }
    
    public String getSlogan() {
        return "More magic teaching";
    }
    
    public Candidate vote(Candidate[] candidates) {
        
        
        if (candidates.length == 0) 
        {
            return new Candidate_ec22872();
        }
        for (Candidate c : candidates)
            {
                if (c.getName().equals("Jett"))
                {return c;}
                
            }
                
        Random r = new Random();
        int c = r.nextInt(candidates.length);
        return candidates[c]; 
        // Add code that inspects the array candidates
        // calling the various methods of the Candidate objects
        // and finds a Candidate object to vote for.
        
    }
    
    public Candidate selectWinner(Candidate[] votes) {
        
        
        if (votes.length == 0) return new Candidate_ec22872();
        
        Candidate currentWinner = votes[0];

        int highestvotes = 0;
        for(Candidate c : votes){
            int count = 0;
            for( Candidate x : votes){
                if(x==c){
                    count++;
                }
            }
            if(count >= highestvotes)
            {
                highestvotes = count;
                currentWinner = c;
            }
        }
        // Add code that either counts the votes
        // or uses some other way to return an element 
        // of the array vote as the winner of an election.
        
        return currentWinner;
    }
    



    public static void print(String message)
    {
        System.out.println(message);
        return;
    }

    public static String si(String message)
    {
        String input;
        Scanner scanner = new Scanner(System.in); 
        
        System.out.println(message);
        input = scanner.nextLine();
        
        return input;
    }
    public static void runvotes(Candidate[] current_candidates, int times, Candidate counter, Candidate[] allcandidates)
    {
        int total_candidates = 0;
        for(int i = 0; i< allcandidates.length;i++)
        {
            if(current_candidates[i] != null)
            {
                total_candidates = total_candidates +1;
            }
        }
        Candidate[] current_options = new Candidate[total_candidates];
        for(int i = 0; i<total_candidates; i++)
        {
            current_options[i] = current_candidates[i];
        }
        Candidate[] current_winners = new Candidate[times];

        for(int i = 0; i<times; i++)
        {
            Candidate[] voting = new Candidate[allcandidates.length];
            for(int j = 0; j< allcandidates.length; j++)
            {
                try
                {
                    voting[j] = allcandidates[j].vote(current_options);
                }
                catch (Exception e)
                {

                }
            }
            current_winners[i] = counter.selectWinner(voting);
        }
        Candidate[] winners = new Candidate[allcandidates.length];
        int highestcount = 0;
        for(int i = 0; i<allcandidates.length; i++)
        {
            int count = 0;
            for(int j = 0; j<current_winners.length; j++)
            {
                if(current_winners[j].equals(allcandidates[i]))
               {
                   count++;
               }
            }
            if(count>highestcount)
            {
                highestcount = count;
                winners[0] = allcandidates[i];
            }
        }
        System.out.println("the most common winner was: " + winners[0] + ".");
        return;
    }


 
    public static void election()
    {
        Candidate[] allcandidates = A3.getCandidateArray();
        Candidate[] current_candidates = new Candidate[allcandidates.length];
    
        boolean quit = false; 
        String choice = si("Would you like to a) add a specific candidate b) add a candidate at random c) run the election?");
        while(!quit)
        {
            
            if(choice.equals("a"))
            {
                String username = si("please enter a username");
                Candidate new_spec_c = A3.getByUsername(username, allcandidates);
                if(new_spec_c == null)
                {
                    print("Invalid username");

                }
                else
                {
                    for(int i = 0; i<current_candidates.length; i++)
                    {
                        if(current_candidates[i]==null)
                        {
                            current_candidates[i] = new_spec_c;
                        }
                    }
                    for(int i = 0; i<current_candidates.length; i++)
                    {
                        if(current_candidates[i]!=null)
                        {
                            print((i+1) + ")" + current_candidates[i]);
                        }
                    }

                }
                
                
            }
            else if(choice.equals("b"))
            {
                Random r = new Random();
                int x = r.nextInt(current_candidates.length);
                for(int i =0; i<current_candidates.length; i++)
                {
                    if(current_candidates[i] == null)
                    {
                        current_candidates[i] = allcandidates[x];
                    }
                }
                for(int i = 0; i<current_candidates.length; i++)
                {
                    if(current_candidates[i]!=null)
                    {
                        print((i+1) + ")" + current_candidates[i]);
                    }
                }
                
                
            }
            else if(choice.equals("c"))
            {
                String who_count = si("Who should count the votes");
                Candidate counter = A3.getByUsername(who_count, allcandidates);
                int times = Integer.parseInt(si("How many times should the election be run?"));
                runvotes(current_candidates, times, counter, allcandidates);
                boolean repeat = false;
                while(repeat == false)
                {
                    String option = si("would you like to: a) exit b) run same election many times");
                    if(option.equals("a"))
                    {
                        repeat = true;
                    }
                    else if(option.equals("b"))
                    {
                        times = Integer.parseInt(si("How many times should the election be run?"));
                        runvotes(current_candidates, times, counter, allcandidates);
                        repeat = false;
                
                    }
                    else
                    {
                        repeat = false;
                        print("enter a valid option");
                    }
                    choice = si("Would you like to a) add a specific candidate b) add a candidate at random c) run the election?");
                }
                
            }
            else
            {
                print("please enter a valid option");
            }
        }
        return;
    }
    

    public static void main (String [] args) 
{
    election(); 
    System.exit(0);
}
}
