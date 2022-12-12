
package guessnum;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.*;




public class GuessNum extends JComponent{

    private JFrame frame = new JFrame(); // FRAME FOR RANDOM NUMBER
    private JPanel panelMain = new JPanel(); //MAIN PANEL
    
    
    
    //FIRST PANEL
   
    private JPanel panelRand = new JPanel(); //PANEL TO ACTUALLY GET RANDOM NUMBER
    private JLabel labelTitle = new JLabel("Press Button to Generate a Random Number Between 1-100!");
    private JButton btnNext = new JButton("Next"); //SWITCH TO NEXT PANEL
    private JButton btnRandNum = new JButton("Generate a Random Number");
    private int randomNum;
    
    
    
    
    
    // SECOND PANEL
     private JPanel panelGuessNum = new JPanel(); //PANEL TWO
     private JButton btnReturn = new JButton("Return");
     private JButton btnEnter = new JButton("Enter");
     private JButton btnGiveUp = new JButton("Give Up");
     private JLabel labelInput = new JLabel("Enter You Guess");
     private JLabel labelOutput = new JLabel("");
     private JTextField txtInput = new JTextField(10);
    
    
    private CardLayout cl = new CardLayout(5,5);
    
    public GuessNum(){
        
        panelMain.setLayout(cl);
        panelMain.setPreferredSize(new Dimension(500,500));
        
        // FIRST PANEL//
        
        // set VERTICAL layout for panelRand//
        panelRand.setLayout(new BoxLayout(panelRand, BoxLayout.Y_AXIS));
        
        //title sub-panel//
        JPanel panelTitle = new JPanel();
        panelTitle.setLayout(new BoxLayout(panelTitle, BoxLayout.X_AXIS));
        
        //btns sub-panel//
        
        JPanel panelRandBtns = new JPanel();
        panelRandBtns.setLayout(new BoxLayout(panelRandBtns, BoxLayout.X_AXIS));
        
        panelTitle.add(labelTitle);
        panelRandBtns.add(btnNext);
        panelRandBtns.add(btnRandNum);
        
        panelRand.add(panelTitle);
        panelRand.add(panelRandBtns);
        
        panelRand.setBackground(Color.BLUE);
        
        btnNext.setEnabled(false);
        
        
        btnNext.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cl.show(panelMain, "2");
            }
        });
        
        btnRandNum.addActionListener(new ActionListener(){
          @Override
            public void actionPerformed(ActionEvent e){
            randomNum = 1  + (int)(Math.random() * 100);
//            labelRandNum.setText(randomNum + "");
            btnRandNum.setEnabled(false);
            btnNext.setEnabled(true);
            }  
            
            
        });
        
        
        //SECOND PANEL
        // set VERTICAL layout for panelGuessNum
        panelGuessNum.setLayout(new BoxLayout(panelGuessNum, BoxLayout.Y_AXIS));
        
        // label and textbox sub-panel
        JPanel labelTextboxPanel = new JPanel();
        txtInput.setMaximumSize(new Dimension(Integer.MAX_VALUE, txtInput.getMinimumSize().height));
        add(txtInput);
        
        labelTextboxPanel.setLayout(new BoxLayout(labelTextboxPanel, BoxLayout.X_AXIS));
        
        // buttons sub-panel
        JPanel panelBtns = new JPanel();
        panelBtns.setLayout(new BoxLayout(panelBtns, BoxLayout.X_AXIS));
        
        // output sub-panel
        JPanel panelOutput = new JPanel();
        panelOutput.setLayout(new BoxLayout(panelOutput, BoxLayout.X_AXIS));
        

        
           
       //adding buttons and labels to their panels
        
        labelTextboxPanel.add(labelInput);
        labelTextboxPanel.add(txtInput);
        panelBtns.add(btnReturn);
        panelBtns.add(btnEnter);
        panelBtns.add(btnGiveUp);
        panelOutput.add(labelOutput);
        
        
        //add labelTextboxPanel and buttonsPanel to panelGuessNum

        panelGuessNum.add(labelTextboxPanel);
        panelGuessNum.add(panelBtns);
        panelGuessNum.add(panelOutput);
        
        panelGuessNum.setBackground(Color.GREEN);
        labelTextboxPanel.setBackground(Color.RED);
        panelBtns.setBackground(Color.BLUE);
        
       
        btnReturn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cl.show(panelMain, "1");
                btnRandNum.setEnabled(true);
                btnNext.setEnabled(false);
                labelOutput.setText("");
            }
        });
        
        
        btnEnter.addActionListener(new ActionListener(){
          @Override
            public void actionPerformed(ActionEvent e){
            if (Integer.parseInt(txtInput.getText()) < randomNum){
                labelOutput.setText(txtInput.getText()+ " is too low");
                
            } else if(Integer.parseInt(txtInput.getText()) > randomNum){
                labelOutput.setText(txtInput.getText() +" is too high");
            } else{
                labelOutput.setText("You got it right! The number is: " + randomNum+"!");
                
            }
            
            txtInput.setText("");
           
            }  
        });
        
          btnGiveUp.addActionListener(new ActionListener(){
          @Override
            public void actionPerformed(ActionEvent e){
            labelOutput.setText("The numer is "+ randomNum);
            txtInput.setText("");
            
            
            btnEnter.setEnabled(false); 
            }
        });
        
        panelMain.add(panelRand,"1");
        panelMain.add(panelGuessNum,"2");
        
        cl.show(panelMain,"1" );
        
        frame.add(panelMain);
        
   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        
        
        
        
    
    
    }

    
    public static void main(String[] args) {
        
         SwingUtilities.invokeLater(new Runnable() {
        
            @Override
            public void run(){
            new GuessNum();
        
            }
        });
    }
    
     
        
        
    
    
}
