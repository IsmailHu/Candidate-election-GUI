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
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

import static OOP.ec22529.MP.contributions.A3.getCandidateArray;


public class MP_ec22529 extends JFrame implements ActionListener {

    private JPanel panelMain;
    private JFrame newWindow = null;

    private JFrame frameElection;
    private JTextField textField;
    private boolean isWindowCreated = false;
    private JButton addButton, randomButton, runButton, displayButton, uploadButton, submitButton, clearButton, saveButton;
    private boolean validated = false;
    private ArrayList<Candidate> list;

    private JTextArea displayField;

    private static JTextArea electionField;

    private static JTextArea sloganField;

    private JScrollPane scrollPane;
    private int num = 1;
    private static int numOfErrors = 0;
    private static int numOfElections;
    private static JProgressBar progressBar;

    public MP_ec22529() {
        this.list = new ArrayList<Candidate>();
        setTitle("Election");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        textField = new JTextField(20);
        panel.add(textField);

        //colour
        Color customColor = new Color(128, 64, 200);
        panel.setBackground(customColor);

        //SUBMIT BUTTON
        submitButton = new JButton("Submit Candidate");
        submitButton.addActionListener(this);
        panel.add(submitButton);

        //RANDOM BUTTON
        randomButton = new JButton("Add 1 random candidate");
        randomButton.addActionListener(this);
        panel.add(randomButton);

        //DISPLAY BUTTON
        displayButton = new JButton("Add 50 random");
        displayButton.addActionListener(this);
        panel.add(displayButton);

        //RUN ELECTION BUTTON
        runButton = new JButton("Run Election");
        runButton.addActionListener(this);
        panel.add(runButton);

        //clear Button
        clearButton = new JButton("Clear all");
        clearButton.addActionListener(this);
        panel.add(clearButton);

        //save Button
        saveButton = new JButton("Save Winners");
        saveButton.addActionListener(this);
        panel.add(saveButton);

        //EXIT BUTTON
        uploadButton = new JButton("Upload Candidates");
        uploadButton.addActionListener(this);
        panel.add(uploadButton);

        progressBar = new JProgressBar();
        progressBar.setMinimum(0);
        progressBar.setLayout(new FlowLayout(FlowLayout.RIGHT, 1 ,1));
        progressBar.setMaximum(100);
        progressBar.setStringPainted(true); // Shows progress percentage
        progressBar.setPreferredSize(new Dimension(50, 30));
        panel.add(progressBar);

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

            // Code to add a candidate at random
            String userID ="";
            Candidate randCandidate;
            for(int i=0; i<50; i++) {
                randCandidate = getRandomCandidate();
                list.add(randCandidate);
                userID = randCandidate.un;
                displayField.append("(" + userID + ")" + " " + randCandidate.getName() + "\n");
            }
        } else if (e.getSource() == uploadButton) {
            JOptionPane.showMessageDialog(null, "Please upload a text file which has\n\n= Each candidate's username on a separate line \n= The username should be within brackets\n\n So for example, my candidate username would be (ec22529)");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt")); // add file filter
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        // process each line here
                        System.out.println(line);
                        displayField.append(line+"\n");
                        if (line.contains("(") && line.contains(")")) {
                            // extract the string within the brackets
                            String extractedString = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
                            // execute code on the extracted string here
                            for(int i =0; i<getCandidateArray().length; i++) {
                                if (extractedString.equals(getCandidateArray()[i].un)) {
                                    System.out.println(extractedString + " was successfully found");
                                    list.add(getCandidateArray()[i]);
                                    //add progress bar here
                                }
                                else{

                                }
                            }
                        }

                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error reading file: " + ex.getMessage());
                }
            }
        }
        else if (e.getSource() == clearButton){
            sloganField.setText("LIST OF CANDIDATE SLOGANS: \n\n");
            displayField.setText("LIST OF CANDIDATES: \n\n");
            electionField.setText("LIST OF ELECTION WINNERS: \n\n");
            list.clear();
            textField.setText("");
        }
        else if (e.getSource() == runButton) {
            if(textField.getText().equals("") && (list.isEmpty())){
                JOptionPane.showMessageDialog(null,"You are attempting an election with no candidates. Unwise!");
            }
            else{
                //START OF ELECTION
                //START LOADING BAR HERE
                progressBar.setValue(0);
                String printWinner = "";
                Candidate[] winners = tallyCandidates(list.toArray(new Candidate[0]));
                Candidate winner = findActualWinner(winners);
                printWinner=("The Winner was: (" + winner.un +") "+ " " + winner.getName() + "!");
                electionField.append(num + ". " + printWinner + "\n");
                electionField.append("There was a total of " + numOfErrors + " incorrect vote methods across " + numOfElections + " runs" +"\n");

                num++;
                numOfElections = 0;

                //other winners
                int otherWinners = 0;
                for(Candidate c : winners) {
                    if(!c.getName().equals(winner.getName())) {
                        otherWinners++;
                    }
                }

                String otherWinnersPresent = otherWinners > 0 ? "There were no other winners." : "There were " + otherWinners + " votes for other winners!";
                System.out.println(otherWinnersPresent);
                electionField.append(otherWinnersPresent + "\n\n");
            }
        }
        else if(e.getSource() == saveButton){
            JOptionPane.showMessageDialog(null, "Please choose a destination to save a text file\ncontaining all the winners from the elections ran");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt")); // add file filter
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (!file.getName().endsWith(".txt")) {
                    file = new File(file.getAbsolutePath() + ".txt"); // add .txt extension
                }
                try (PrintWriter writer = new PrintWriter(file)) {
                    //CHANGE THIS
                    writer.print(electionField.getText());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
                }
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
                    JOptionPane.showMessageDialog(null,"Cannot run election 0 times.");
                    doNotDo = true;

                }
            }
        }
        numOfElections = number;
// At this point, number contains a valid numeric value
        if(doNotDo){
            throw new RuntimeException("0 frequency election exception");
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
                progressBar.setValue(i);
                votes[i] = getCandidateArray()[i].vote(array);
                String printable = "("+getCandidateArray()[i].un+")" +":" + " chose " + getCandidateArray()[i].getName() + "\twith slogan: " + getCandidateArray()[i].getSlogan();
               sloganField.append(printable +"\n");


            } catch(Exception e) {
                numOfErrors++;

            }
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


