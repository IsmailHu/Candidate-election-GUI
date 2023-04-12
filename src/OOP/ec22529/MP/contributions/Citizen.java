package OOP.ec22529.MP.contributions;

interface Citizen extends Person {
    Candidate vote(Candidate[] candidates);
    Candidate selectWinner(Candidate[] votes);
}
