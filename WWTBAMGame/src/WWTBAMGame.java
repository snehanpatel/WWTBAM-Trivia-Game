import java.awt.event.*; 
import java.io.*;
import javax.swing.*;

public class WWTBAMGame extends JFrame {
    // declaring variables for JFrame
    private static JLabel questionNumLabel = new JLabel();
    private static JLabel prizeLabel = new JLabel();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private static JTextArea questionTextArea = new JTextArea();
    public static JButton optionA = new JButton();
    public static JButton optionB = new JButton();
    public static JButton optionC = new JButton();
    private static JButton optionD = new JButton();
    private JLabel lifelinesLabel = new JLabel();
    private static JButton fiftyFifty = new JButton(); 
    private static JButton audiencePoll = new JButton();
    private static JButton askTheHost = new JButton();
    private JLabel incorrectAnswerLabel = new JLabel();
    private static JTextField lostPrizeField = new JTextField();
    private JLabel nextQuestionLabel = new JLabel();
    private static JTextField nextQuestionField = new JTextField();
    private JScrollPane jScrollPane2 = new JScrollPane();
    private static JTextArea messageTextArea = new JTextArea();
    private static JButton quitGame = new JButton();
    private JButton viewInstructions = new JButton();
    private JLabel wwtbamLabel = new JLabel();
    private JLabel triviaLabel = new JLabel();
    
    // declaring variables for the trivia game functions
    static String questions[][] = new String[12][7];
    static int moneyPrize [] = {500, 1000, 2000, 5000, 10000, 20000, 75000, 150000, 250000, 5000000, 1000000};
    static boolean answerCheck = false;
    static boolean tierOne = false;
    static boolean tierTwo = false;
    static int levelTracker = 0;
    static int moneyWon = 0;
    
    
    public WWTBAMGame () {
        jFrameComponents();  // calling method to create JFrame
    }
    
    /**
     * method that creates JFrame application
     */
    private void jFrameComponents () {
        setTitle("WWTBAM Trivia Game");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        questionNumLabel.setFont(new java.awt.Font("Corbel", 0, 18)); 
        questionNumLabel.setText("Question #1");

        prizeLabel.setFont(new java.awt.Font("Corbel", 0, 18)); 
        prizeLabel.setText("Prize Value: $");

        questionTextArea.setColumns(20);
        questionTextArea.setFont(new java.awt.Font("Corbel", 0, 16)); 
        questionTextArea.setRows(5);
        jScrollPane1.setViewportView(questionTextArea);

        optionA.setFont(new java.awt.Font("Corbel", 0, 14)); 
        optionA.setText("jButton1");

        optionB.setFont(new java.awt.Font("Corbel", 0, 14)); 
        optionB.setText("jButton2");

        optionC.setFont(new java.awt.Font("Corbel", 0, 14)); 
        optionC.setText("jButton3");

        optionD.setFont(new java.awt.Font("Corbel", 0, 14)); 
        optionD.setText("jButton4");

        lifelinesLabel.setFont(new java.awt.Font("Corbel", 0, 14)); 
        lifelinesLabel.setText("LIFELINES:");
              
        fiftyFifty.setFont(new java.awt.Font("Corbel", 0, 14)); 
        fiftyFifty.setText("50:50");

        audiencePoll.setFont(new java.awt.Font("Corbel", 0, 14)); 
        audiencePoll.setText("Audience Poll");
        audiencePoll.setMaximumSize(new java.awt.Dimension(109, 25));
        audiencePoll.setMinimumSize(new java.awt.Dimension(109, 25));

        askTheHost.setFont(new java.awt.Font("Corbel", 0, 14)); 
        askTheHost.setText("Ask The Host");
        askTheHost.setPreferredSize(new java.awt.Dimension(110, 25));

        incorrectAnswerLabel.setFont(new java.awt.Font("Corbel", 0, 14)); 
        incorrectAnswerLabel.setText("If Incorrect Answer, You Win:");

        lostPrizeField.setFont(new java.awt.Font("Corbel", 0, 14)); 

        nextQuestionLabel.setFont(new java.awt.Font("Corbel", 0, 14)); 
        nextQuestionLabel.setText("Prize Value of Next Question:");

        nextQuestionField.setFont(new java.awt.Font("Corbel", 0, 14)); 

        messageTextArea.setColumns(20);
        messageTextArea.setFont(new java.awt.Font("Corbel", 0, 14)); 
        messageTextArea.setRows(5);
        jScrollPane2.setViewportView(messageTextArea);

        quitGame.setFont(new java.awt.Font("Corbel", 0, 14)); 
        quitGame.setText("Quit Game");

        wwtbamLabel.setFont(new java.awt.Font("Corbel", 0, 24)); 
        wwtbamLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wwtbamLabel.setText("WHO WANTS TO BE A MILIONAIRE");
        wwtbamLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        wwtbamLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        triviaLabel.setFont(new java.awt.Font("Corbel", 1, 24)); 
        triviaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        triviaLabel.setText("TRIVIA GAME");
        triviaLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        viewInstructions.setFont(new java.awt.Font("Corbel", 0, 14)); 
        viewInstructions.setText("View Instructions");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(triviaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(wwtbamLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(questionNumLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(prizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(optionC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(optionA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(optionB, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(optionD, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(nextQuestionLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(nextQuestionField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(incorrectAnswerLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(lostPrizeField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(297, 297, 297))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lifelinesLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(fiftyFifty, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57)
                                        .addComponent(audiencePoll, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)
                                        .addComponent(askTheHost, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(viewInstructions, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                    .addComponent(quitGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(wwtbamLabel)
                .addGap(1, 1, 1)
                .addComponent(triviaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prizeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(questionNumLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optionA)
                    .addComponent(optionB))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optionC)
                    .addComponent(optionD))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lifelinesLabel)
                    .addComponent(askTheHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiftyFifty)
                    .addComponent(audiencePoll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(incorrectAnswerLabel)
                            .addComponent(lostPrizeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nextQuestionLabel)
                            .addComponent(nextQuestionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quitGame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewInstructions))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        // adding actionlisterner to View Instructions Button that will create instrucations window when button is clicked
        viewInstructions.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewInstructions();
            }
        });
        
        // adding actionlistener to all option buttons and sending event as argument to method that controls option buttons
        optionA.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                optionButtonActionPerformed(e);
            }
        });
        optionB.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                optionButtonActionPerformed(e);
            }
        });
        optionC.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                optionButtonActionPerformed(e);
            }
        });
        optionD.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                optionButtonActionPerformed(e);
            }
        });
        
        // adding action listener to each of the lifeline and sending event as argument to respective method
        fiftyFifty.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                fiftyFiftyActionPerformed(e);
            }
        });
        
        audiencePoll.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                audiencePollActionPerformed(e);
            }
        });
        
        askTheHost.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                askTheHostActionPerformed(e);
            }
        });

        quitGame.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed (ActionEvent e) {
                quitGameActionPerformed(e);
            }
        });
        
        pack();
        setVisible(true);
    }
    
    /** 
     * method that reads questions and answers from file and stores values into questions array
     */
    static void StoringInformation ()
        throws java.io.IOException {
        
        FileReader fr = new FileReader("C:\\Users\\patel\\OneDrive\\Desktop\\WWTBAMGame\\src\\WWTBAMQuestions.txt");
        BufferedReader bfr = new BufferedReader(fr);
        
        // for loop that reads each line of question and answer text file into questions array
        for (int row=0; row <=11; row++) {
            for (int col=0; col<= 6; col++) {
                questions [row][col] = bfr.readLine();
            }
        }
        
        fr.close();
    }
    
    /**
     * method that displays the question and answer options
     */
    static void QuestionsandAnswers () {
        messageTextArea.setText(" ");
        optionA.setEnabled(true);
        optionB.setEnabled(true);
        optionC.setEnabled(true);
        optionD.setEnabled(true);
        questionNumLabel.setText("Question #"+ (levelTracker + 1));
        prizeLabel.setText("Prize Value: $"+ moneyPrize[levelTracker]);
        questionTextArea.setText("\n" + questions[levelTracker][0]);
        optionA.setText("A. " + questions[levelTracker][1]);
        optionB.setText("B. " + questions[levelTracker][2]);
        optionC.setText("C. " + questions[levelTracker][3]);
        optionD.setText("D. " + questions[levelTracker][4]);
        
        // outputs the money value of next question except for if user is on last question
        if (levelTracker < 10) {
            nextQuestionField.setText("$" + moneyPrize[levelTracker + 1]);
        } else {
            nextQuestionField.setText(" ");
        }
        
        // checks if user has passed the either of guarantee questions (ie. the two tiers) and changes respective
        // boolean variable to true
        if (levelTracker == 4) {
            tierOne = true;
        }
        if (levelTracker == 8) {
            tierTwo = true;
        }

        // displays the amount of money user will win if they answer question incorrectly based on which tier they have passed
        if (tierOne == false && tierTwo == false) {
            lostPrizeField.setText("$0");
        } else if (tierOne == true && tierTwo == false) {
            lostPrizeField.setText("$" + moneyPrize[3]);
        } else if (tierTwo == true) {
            lostPrizeField.setText("$" + moneyPrize[7]);
        }
        
    }
    
    /**
     * method that runs if user answers question incorrectly
     */
    static void incorrectAnswer() {
        // sets question text area and option buttons to blank and disables all the buttons so user may not answer again
        questionTextArea.setText(" ");
        optionA.setText(" ");
        optionA.setEnabled(false);
        optionB.setText(" ");
        optionB.setEnabled(false);
        optionC.setText(" ");
        optionC.setEnabled(false);
        optionD.setText(" ");
        optionD.setEnabled(false);
        
        fiftyFifty.setEnabled(false);
        audiencePoll.setEnabled(false);
        askTheHost.setEnabled(false);
        quitGame.setEnabled(false);
        
        // outputs amount won by user based on which tier they have passed
        if (tierOne == false && tierTwo == false) {
            messageTextArea.setText("Sorry, the answer was incorrect. Unfortunately, you have not won anything today. Better luck next time.");
        } else if (tierOne == true && tierTwo == false) {
            messageTextArea.setText("Sorry the answer was incorrect. As you have already answered question 4 correctly, you have won $" + moneyPrize[3] + " today.");
        } else if (tierOne == true && tierTwo == true) {
            messageTextArea.setText("Sorry the answer was incorrect. As you have already answered question 8 correctly, you have won $" + moneyPrize[7] + " today.");
        } 
    }
    
    /**
     * method that runs if user has correctly answered the last question
     */
    void lastLevel() {
        // displays a congraduatoins message
        messageTextArea.setText("Congradulations, you have won $" + moneyPrize[levelTracker-1]);
        
        // sets question text area and option buttons to blanks and displays all buttons to indicate the game is finished
        questionTextArea.setText(" ");
        optionA.setText(" ");
        optionA.setEnabled(false);
        optionB.setText(" ");
        optionB.setEnabled(false);
        optionC.setText(" ");
        optionC.setEnabled(false);
        optionD.setText(" ");
        optionD.setEnabled(false);
        lostPrizeField.setText(" ");
        
        fiftyFifty.setEnabled(false);
        audiencePoll.setEnabled(false);
        askTheHost.setEnabled(false);
        quitGame.setEnabled(false);
    }
    
    /**
     * method that checks if user answered question correctly and if so then outputting questions and
     * answer options for next level
     */
    private void optionButtonActionPerformed (ActionEvent e) {
        // checks if option button clicked matches the correct answer stored in array
        if (e.getSource() == optionA && questions[levelTracker][5].equals("A")) {
            moneyWon = moneyPrize[levelTracker];
            levelTracker += 1;
            answerCheck = true;
            if (levelTracker < 11) {
                QuestionsandAnswers();
            } else {
                lastLevel();
            }
        } else if (e.getSource() == optionB && questions[levelTracker][5].equals("B")) {
            moneyWon = moneyPrize[levelTracker];
            levelTracker += 1;
            answerCheck = true;
            if (levelTracker < 11) {
                QuestionsandAnswers();
            } else {
                lastLevel();
            }
        } else if (e.getSource() == optionC && questions[levelTracker][5].equals("C")) {
            moneyWon = moneyPrize[levelTracker];
            levelTracker += 1;
            answerCheck = true;
            if (levelTracker < 11) {
                QuestionsandAnswers();
            } else {
                lastLevel();
            } 
        } else if (e.getSource() == optionD && questions[levelTracker][5].equals("D")) {
            moneyWon = moneyPrize[levelTracker];
            levelTracker += 1;
            answerCheck = true;
            if (levelTracker < 11) {
                QuestionsandAnswers();
            } else {
                lastLevel();
            } 
        } else { // if answer is incorrect, then runs the incorrect answer method
            incorrectAnswer();
        }
    }
    
    /**
     * method that handles the 50:50 lifeline
     */
    private void fiftyFiftyActionPerformed (ActionEvent e) {
        int randNum1, randNum2;
        String randOption1 = null;
        String randOption2 = null;
        
        // loop that generates a random number between 1-4 (corresponding to A-D respectively)
        do {
            randNum1 =(int)((Math.random() * 4) + 1);
            if (randNum1 == 1) {
                randOption1 = "A";
            } else if (randNum1 == 2) {
                randOption1 = "B";
            } else if (randNum1 == 3) {
                randOption1 = "C";
            } else if (randNum1 == 4) {
                randOption1 = "D";
            }
            // checks that random number does not match the associated correct answer option
            if (!randOption1.equals(questions[levelTracker][5])) {
                break;
            }
        } while (true);
        
        // loop that generates another random number between 1-4 corresponding to A-D respectively
        do {
            randNum2 =(int)((Math.random() * 4) + 1);
            if (randNum2 == 1) {
                randOption2 = "A";
            } else if (randNum2 == 2) {
                randOption2 = "B";
            } else if (randNum2 == 3) {
                randOption2 = "C";
            } else if (randNum2 == 4) {
                randOption2 = "D";
            }
            // checks that random number does not match associated correct answer option or the first random number
            if (!randOption2.equals(questions[levelTracker][5]) && !randOption2.equals(randOption1)) {
                break;
            }
        } while (true);
        
        // gets rid of the two options corresponding on the two random numbers generated
        if (randOption1.equals("A") || randOption2.equals("A")) {
            optionA.setText(" ");
            optionA.setEnabled(false);
        }
        if (randOption1.equals("B") || randOption2.equals("B")) {
            optionB.setText(" ");
            optionB.setEnabled(false);
        }
        if (randOption1.equals("C") || randOption2.equals("C")) {
            optionC.setText(" ");
            optionC.setEnabled(false);
        }
        if (randOption1.equals("D") || randOption2.equals("D")) {
            optionD.setText(" ");
            optionD.setEnabled(false);
        }
        fiftyFifty.setEnabled (false); // disables 50:50 option button so lifeline can not be used again
    }
    
    /**
     * method that handles the Audience Poll lifeline
     */
    private void audiencePollActionPerformed (ActionEvent e) {
        int optA, optB, optC, optD;
        int range = 100;
        
        // generates 4 random numbers to act as survey/poll results
        // the poll result of correct answer will always be greater than 50 and greater than the other 3 options
        // the results are displayed in message text area
        if (questions[levelTracker][5].equals("A")) {
            optA = (int)(Math.random() * 50) + 50;
            range -= optA;
            optB = (int)(Math.random() * range) + 1;
            range -= optB;
            optC = (int)(Math.random() * range) + 1;
            optD = (range - optC);
            messageTextArea.setText("Results of the Audience Poll:\nOption A: " + optA + "%\nOption B: " + optB + "%\nOption C: " + optC + "%\nOption D: " + optD + "%");
        } else if (questions[levelTracker][5].equals("B")) {
            optB = (int)(Math.random() * 50) + 50;
            range -= optB;
            optA = (int)(Math.random() * range) + 1;
            range -= optA;
            optC = (int)(Math.random() * range) + 1;
            optD = (range - optC);
            messageTextArea.setText("Results of the Audience Poll:\nOption A: " + optA + "%\nOption B: " + optB + "%\nOption C: " + optC + "%\nOption D: " + optD + "%");
        } else if (questions[levelTracker][5].equals("C")) {
            optC = (int)(Math.random() * 50) + 50;
            range -= optC;
            optA = (int)(Math.random() * range) + 1;
            range -= optA;
            optB = (int)(Math.random() * range) + 1;
            optD = (range - optB);
            messageTextArea.setText("Results of the Audience Poll:\nOption A: " + optA + "%\nOption B: " + optB + "%\nOption C: " + optC + "%\nOption D: " + optD + "%");
        } else if (questions[levelTracker][5].equals("D")) {
            optD = (int)(Math.random() * 50) + 50;
            range -= optD;
            optA = (int)(Math.random() * range) + 1;
            range -= optA;
            optB = (int)(Math.random() * range) + 1;
            optC = (range - optB);
            messageTextArea.setText("Results of the Audience Poll:\nOption A: " + optA + "%\nOption B: " + optB + "%\nOption C: " + optC + "%\nOption D: " + optD + "%");
        }

        audiencePoll.setEnabled (false); // disables the Audience Poll option button so lifeline can not be used again
    }
    
    /**
     * method that handles the Ask the Host lifeline
     */
    private void askTheHostActionPerformed (ActionEvent e) {
        // displays the hint associated with the question that is stored in question array
        messageTextArea.setText (questions[levelTracker][6]);
        askTheHost.setEnabled (false); // disables the Ask the Host option button so lifeline can not be used again
    }
    
    /**
     * method that runs when user chooses to quit the game
     */
    private void quitGameActionPerformed (ActionEvent e) {
        // sets question text area and option button to blank and disables all the buttons so user may not continue the game
        questionTextArea.setText(" ");
        optionA.setText(" ");
        optionA.setEnabled(false);
        optionB.setText(" ");
        optionB.setEnabled(false);
        optionC.setText(" ");
        optionC.setEnabled(false);
        optionD.setText(" ");
        optionD.setEnabled(false);
        
        fiftyFifty.setEnabled(false);
        audiencePoll.setEnabled(false);
        askTheHost.setEnabled(false);
        quitGame.setEnabled(false);
        // displays amount of money won which is the money value of the last question
        messageTextArea.setText("As you have choosen to quit the game, you get to keep the amount of money you have won until this question. So, you have won $" + moneyWon + ".");
    }
    
    /**
     * main method
     */
    public static void main (String args[])
        throws java.io.IOException {
        WWTBAMGame frame = new WWTBAMGame(); // creates object for this file
        StoringInformation(); // runs method to store question and answers from file
        QuestionsandAnswers(); // runs question and answer method
    }
}
