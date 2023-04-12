package OOP.ec22529.MP;

import OOP.ec22529.MP.contributions.A3;
import OOP.ec22529.MP.contributions.Candidate;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.Timer;

import static OOP.ec22529.MP.contributions.A3.getCandidateArray;

public class MP_ec22529 extends JFrame implements ActionListener {

    private JPanel panelMain;
    private JFrame newWindow = null;

    private JFrame frameElection;
    private JTextField textField;
    private boolean isWindowCreated = false;
    private JButton addButton, randomButton, runButton, displayButton, exitButton, submitButton;
    private boolean validated = false;
    private ArrayList<Candidate> list;

    private JTextArea displayField;

    private static JTextArea electionField;

    private static JTextArea sloganField;

    private JScrollPane scrollPane;
    private int num = 1;
    private static int numOfErrors = 0;

    public MP_ec22529() {
        this.list = new ArrayList<Candidate>();
        setTitle("Election");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        JLabel optionA = new JLabel("Add a specific candidate:");
        panel.add(optionA);
        textField = new JTextField(20);
        panel.add(textField);

        //SUBMIT BUTTON
        submitButton = new JButton("Submit specific Candidate");
        submitButton.addActionListener(this);
        panel.add(submitButton);

        //RANDOM BUTTON
        randomButton = new JButton("Add a candidate at random");
        randomButton.addActionListener(this);
        panel.add(randomButton);

        //DISPLAY BUTTON
        displayButton = new JButton("Add 50 Random");
        displayButton.addActionListener(this);
        panel.add(displayButton);

        //RUN ELECTION BUTTON
        runButton = new JButton("Run The Election");
        runButton.addActionListener(this);
        panel.add(runButton);

        //EXIT BUTTON
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        panel.add(exitButton);

        displayField = new JTextArea("LIST OF CANDIDATES: \n\n");
        displayField.setFont(new Font("Arial", Font.PLAIN, 15));
        displayField.setPreferredSize(new Dimension(200, 10000));
        displayField.setEditable(false);
        displayField.setLineWrap(true); // enable line wrapping
        displayField.setWrapStyleWord(true); // wrap lines on word boundaries
        panel.add(displayField);

        scrollPane = new JScrollPane(displayField);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(200, 700));
        panel.add(scrollPane);


        electionField = new JTextArea("LIST OF ELECTION WINNERS: \n\n");
        electionField.setFont(new Font("Arial", Font.PLAIN, 15));
        electionField.setPreferredSize(new Dimension(370, 10000));
        electionField.setEditable(false);
        electionField.setLineWrap(true);
        electionField.setWrapStyleWord(true);
        panel.add(electionField);

        scrollPane = new JScrollPane(electionField);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(370, 700));
        panel.add(scrollPane);

        sloganField = new JTextArea("LIST OF CANDIDATE SLOGANS: \n\n");
        sloganField.setFont(new Font("Arial", Font.PLAIN, 15));
        sloganField.setPreferredSize(new Dimension(540, 100000));
        sloganField.setEditable(false);
        sloganField.setLineWrap(true);
        sloganField.setWrapStyleWord(true);
        panel.add(sloganField);

        scrollPane = new JScrollPane(sloganField);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(540, 700));
        panel.add(scrollPane);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == randomButton) {
            // Code to add a candidate at random
            String userID ="";
            Candidate randCandidate = getRandomCandidate();
            list.add(randCandidate);
            userID = randCandidate.un;
            displayField.append("(" + userID + ")" + " " + randCandidate.getName() + "\n");


        } else if (e.getSource() == submitButton) {
            // Code to submit a candidate

            if(textField.getText().equals("")){

                JOptionPane.showMessageDialog(null,"Please enter the name of a candidate");
            }
            else {
                String name = "";
                try {
                    name = textField.getText();
                }
                catch(Exception t)
                {
                    //never executes
                    System.out.println("nothing in search box");
                    JOptionPane.showMessageDialog(null,"unknown error occured gathering your candidate input");
                }
                if(!candidateNameInArray(name, getCandidateArray())) {
                    //doesnt exist in the scope of candidates
                    System.out.println("Not a valid candidate!");
                    System.out.println(list.toString());
                    JOptionPane.showMessageDialog(null,"Unknown candidate.. Are you attempting a write in????");
                }
                else{
                    //allow candidatei nto array
                    String userID ="";
                    Candidate chosenCandidate = A3.getByUsername(name, getCandidateArray());
                    list.add(chosenCandidate);
                    System.out.println("election good to go");
                    System.out.println(list.toString());
                    textField.setText("");

                    userID = chosenCandidate.un;
                    displayField.append("(" + userID + ")" + " " + chosenCandidate.getName() + "\n");
                }
            }
        } else if (e.getSource() == displayButton) {
            // Code to display the current candidates' list
            if(list.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "No Candidates selected", "No of Candidates", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                StringBuilder message = new StringBuilder();
                int counter = 0;
                for (Candidate candidate : list) {
                    message.append(candidate.getName()).append(", ");
                    counter++;
                }
                String noOfCandidates = "No of candidates selected: " + String.valueOf(counter);
                JOptionPane.showMessageDialog(null, message.toString(), noOfCandidates, JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
        else if (e.getSource() == runButton) {
            if(textField.getText().equals("") && (list.isEmpty())){
                JOptionPane.showMessageDialog(null,"You are attempting an election with no candidates. Unwise!");
            }
            else{
                //START OF ELECTION

                String printWinner = "";
                Candidate[] winners = tallyCandidates(list.toArray(new Candidate[0]));
                Candidate winner = findActualWinner(winners);
                printWinner=("The Winner was: (" + winner.un +") "+ " " + winner.getName() + "!");
                electionField.append(num + ". " + printWinner + "\n");
                num++;

                //other winners
                int otherWinners = 0;
                for(Candidate c : winners) {
                    if(!c.getName().equals(winner.getName())) {
                        otherWinners++;
                    }
                }

                String otherWinnersPresent = otherWinners > 0 ? "There were no other winners." : "There were " + otherWinners + " votes for other winners!";
                System.out.println(otherWinnersPresent);
            }
        }
    }

    public static void main(String[] args) {
        new MP_ec22529();

    }

    private static Candidate getRandomCandidate() {
        Random r = new Random();
        return getCandidateArray()[r.nextInt(getCandidateArray().length - 1)];
    }


    //CODE LOGIC FROM a3 ec22761 credit to this user for their implementation
    private static Candidate[] tallyCandidates(Candidate[] array) {

        String name = JOptionPane.showInputDialog(null, "Candidate name who should count the votes?");
        while(!candidateNameInArray(name, getCandidateArray())) {
            name = JOptionPane.showInputDialog(null, "Enter a valid Candidate name who should count the votes?");
        }
        Candidate counter = A3.getByUsername(name, getCandidateArray());
        int number = 0;
        boolean isValid = false;
        boolean doNotDo = false;

        while (!isValid) {
            try {
                number = Integer.parseInt(JOptionPane.showInputDialog(null, "Number of times we should run the election?"));
                isValid = true; // set isValid to true if parsing succeeds
            }
            catch(Exception failed){
                JOptionPane.showMessageDialog(null,"Enter a valid numeric please");
            }
            finally{
                if(number == 0)
                {
                    JOptionPane.showMessageDialog(null,"The election ran for 0 times. No Winners of course.");
                    doNotDo = true;
                }
            }
        }
// At this point, number contains a valid numeric value
        if(doNotDo){
            throw new RuntimeException("Exiting program due to 0 frequency election");
        }
        Candidate[] winners = new Candidate[number];

        for(int i = 0; i < number; i++) {
            winners[i] = findWinner(array, counter);
        }

        return winners;
    }
    private static Candidate findWinner(Candidate[] array, Candidate counter) {

        Candidate[] votes = new Candidate[getCandidateArray().length];

        // Populate array with votes
        for(int i = 0; i < getCandidateArray().length; i++) {
            try {
                votes[i] = getCandidateArray()[i].vote(array);
                String printable = getCandidateArray()[i].un + "\tchose " + getCandidateArray()[i].getName() + "\twith slogan: " + getCandidateArray()[i].getSlogan();
                //System.out.println(printable);
               sloganField.append(printable +"\n");

            } catch(Exception e) {
                System.out.println("error in " + getCandidateArray()[i] + "code");
                numOfErrors++;

            }

            //electionField.append("There were " + numOfErrors + " classes with incorrect vote methods");

        }

        // Find most present candidate in array
        return counter.selectWinner(votes);
    }
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
    private static String askStringQuestion(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        return scanner.nextLine();
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
}


