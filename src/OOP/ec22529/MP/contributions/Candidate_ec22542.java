package OOP.ec22529.MP.contributions;// File Candidate_ec22542.java
//
/// Machine generated stub for Assignment 2

class Candidate_ec22542 extends Candidate {

    public String getName() {
        return "BM";
    }

    public String getSlogan() {
        return "Just do it";
    }

    public Candidate vote(Candidate[] candidates) {
        Candidate r = new Candidate_ec22542();

        if (candidates.length != 0) r = candidates[0];

        for (Candidate a: candidates){
		if(a.getName().equals("Mike")){
			r=a;
		}
	}



        return r;
    }

    public Candidate selectWinner(Candidate[] votes) {

      // If array is empty, return instance of this class.
      if (votes.length == 0)
          return new Candidate_ec22542();

      // Default to first vote, but this will be over-written.
      Candidate currentWinner = votes[0];

      // Count the votes for each object in the array,
      // selecting one with the most.
      int highestCount = 0;
      for (Candidate c : votes) {

          int count = 0;
          for (Candidate x : votes)
              if (x == c)
                  count++;
          if (count >= highestCount) {
              highestCount = count;
              currentWinner = c;
          }
      }

      return currentWinner;

    }

}
