package OOP.ec22529.MP.contributions;// File Candidate_ec22789.java
//
import java.util.Random;

public class Candidate_ec22789 extends Candidate {
    public String getName() {
        return "Kristoph";
    }

    public String getSlogan() {
        return "Keep Your Phone on Silent!";
    }

    public Candidate vote(Candidate[] candidates) {

        // If array is empty, return instance of friend's class.
        if (candidates.length == 0)
            return new Candidate_ec22790();

        // choose at random from list.
        Random luckyCandidate = new Random();
        return candidates[luckyCandidate.nextInt(candidates.length) ];
    }

    public Candidate selectWinner(Candidate[] votes) {

        // If array is empty, return instance of friend's class.
        if (votes.length == 0)
            return new Candidate_ec22790();

        // Default to first vote, but this will be over-written.
        Candidate winningCandidate = votes[0];

        // Count the votes for each object in the array,
        // selecting one with the most.
        int mostVotes= 0;
        for (Candidate c : votes) {

            int count = 0;
            for (Candidate x : votes)
                if (x == c)
                    count++;
            if (count >= mostVotes) {
                mostVotes = count;
                winningCandidate = c;
            }
        }

        return winningCandidate;
    }
}
