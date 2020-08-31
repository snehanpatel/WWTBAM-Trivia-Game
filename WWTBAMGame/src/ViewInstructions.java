import java.awt.event.*;
import javax.swing.*;

public class ViewInstructions extends JFrame{
    private JLabel instructionsLabel = new JLabel();
    private JScrollPane jScrollPane = new JScrollPane ();
    private JTextArea instructions = new JTextArea();
    private JButton closeButton = new JButton("Close Instructions");
    
    public ViewInstructions () {
        jFrameComponents();
    }
    
    private void jFrameComponents () {
        setTitle ("WWTBAM Trivia Game | Instructions Window");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        instructionsLabel.setFont(new java.awt.Font("Corbel", 0, 20)); // NOI18N
        instructionsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        instructionsLabel.setText("Game Instructions:");

        instructions.setColumns(20);
        instructions.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        instructions.setRows(5);
        instructions.setText("• The game consists of 12 general knowledge questions that become increasingly difficult. The\nmoney value and difficulty of questions increase as you progress through the levels.\n\n• Each level will display a question, along with 4 possible answers, to which you must\nclick the correct answer. If the answer is correct, you will win the money prize for that level.\n\n• If the answer is incorrect, but you have reached one of the safety net levels, you will leave \nthe game with that amount as your prize.\n\n• You can choose to quit the game at anytime and will win the money earned until that level.\n\n• You will be given 4 lifelines to aid in answering a question. Each lifeline may only be used \nonce. However, lifelines may not be used during the last two levels.\n\n• The first lifeline, 50:50, will eliminate two incorrect answers.\nThis will leave you with two answers to choose between as your final answer.\n  \n• The second lifeline, Double Dip, will allow you to choose two answers as your final.\nOne of them must be correct for you to progress to the next level.\n  \n• The third lifeline, Audience Poll, will simulate an audience voting, and will display the voting\nresults as a percentage.\n\n• The fourth lifeline, Ask The Host, will provide a hint given by the host to assist you in finding\nthe correct answer out of the four given choices.");
        jScrollPane.setViewportView(instructions);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(instructionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(closeButton)
                        .addGap(242, 242, 242))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(instructionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(closeButton)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        
        closeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
               
        pack();
        setVisible(true);
    }
    
    
}