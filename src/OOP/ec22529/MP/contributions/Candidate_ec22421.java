package OOP.ec22529.MP.contributions;// File Candidate_ec22421.java
//
// Machine generated stub for Assignment 2

import java.util.Random;

class Candidate_ec22421 extends Candidate {

    public String getName() {
        return "Yagiz Halil";
    }

    public String getSlogan() {
        return "Vote for me.";
    }

    public Candidate vote(Candidate[] c) {

        for(Candidate candidate : c)
        {
            if(candidate.getName().equals("Yagiz Halil")) {
                return candidate;
            }
        }

        Random random = new Random();
        int x = random.nextInt(c.length);

        return c[x];
    }

    public Candidate selectWinner(Candidate[] votesCast) {

        if(votesCast.length == 0) {
            return new Candidate_ec22421();
        }

        Candidate winner = votesCast[0];

        int highest_vote = 0;

        for(Candidate candidate : votesCast) {

            int vote = 0;
            for(Candidate candidate_2 : votesCast) {
                if(candidate == candidate_2) {
                    vote++;
                }
                if(vote >= highest_vote) {
                    highest_vote = vote;
                    winner = candidate;
                }
            }
        }

        return winner;
    }
}
