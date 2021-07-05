package com.tic_tac_toe;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;


public class TicTacToe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame(); //window to hold our game's GUI inplace.
    JPanel title_panel = new JPanel(); //panel to hold title of our game.
    JPanel button_panel = new JPanel(); //panel to hold buttons inplace.
    JLabel text_field = new JLabel(); //to hold text field.
    JButton[] buttons = new JButton[9]; //An array of 9 buttons of the 3X3 Tic Tac Toe game
    boolean player1_turn; //true signifies player1 turn else signifies player2 turn;

    TicTacToe(){
        //designing the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,600);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //designing the text-field
        text_field.setBackground(new Color(25,25,25));
        text_field.setForeground(new Color(25,250,0));
        text_field.setFont(new Font("Ink Free",Font.BOLD,55));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic-Tac-Toe");
        text_field.setOpaque(true);

        //adding text-field to title panel.
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,50,40);
        title_panel.add(text_field);

        //creating the button panel
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for(int i=0;i<9;i++){
            buttons[i]=new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD,80));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        //adding components of to frame
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText().equalsIgnoreCase("")){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn=false;
                        text_field.setText("O turn");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText().equalsIgnoreCase("")){
                        buttons[i].setForeground(new Color(0,255,0));
                        buttons[i].setText("O");
                        player1_turn=true;
                        text_field.setText("X turn");
                        check();
                    }

                }
            }
        }

    }

    public void firstTurn(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(random.nextInt(2)==0)
        {
            player1_turn=true;
            text_field.setText("X turn");
        }
        else
        {
            player1_turn=false;
            text_field.setText("O turn");
        }

    }

    public void check(){
        // X wins combination
        if( buttons[0].getText().equalsIgnoreCase("X") &&  buttons[1].getText().equalsIgnoreCase("X") &&
                        buttons[2].getText().equalsIgnoreCase("X"))
        {
            xWins(0,1,2);
        }
        if( buttons[3].getText().equalsIgnoreCase("X") &&  buttons[4].getText().equalsIgnoreCase("X") &&
                buttons[5].getText().equalsIgnoreCase("X"))
        {
            xWins(3,4,5);
        }
        if( buttons[6].getText().equalsIgnoreCase("X") &&  buttons[7].getText().equalsIgnoreCase("X") &&
                buttons[8].getText().equalsIgnoreCase("X"))
        {
            xWins(6,7,8);
        }

        if( buttons[0].getText().equalsIgnoreCase("X") &&  buttons[3].getText().equalsIgnoreCase("X") &&
                buttons[6].getText().equalsIgnoreCase("X"))
        {
            xWins(0,3,6);
        }
        if( buttons[1].getText().equalsIgnoreCase("X") &&  buttons[4].getText().equalsIgnoreCase("X") &&
                buttons[7].getText().equalsIgnoreCase("X"))
        {
            xWins(1,4,7);
        }
        if( buttons[2].getText().equalsIgnoreCase("X") &&  buttons[5].getText().equalsIgnoreCase("X") &&
                buttons[8].getText().equalsIgnoreCase("X"))
        {
            xWins(2,5,8);
        }
        if( buttons[0].getText().equalsIgnoreCase("X") &&  buttons[4].getText().equalsIgnoreCase("X") &&
                buttons[8].getText().equalsIgnoreCase("X"))
        {
            xWins(0,4,8);
        }
        if( buttons[2].getText().equalsIgnoreCase("X") &&  buttons[4].getText().equalsIgnoreCase("X") &&
                buttons[6].getText().equalsIgnoreCase("X"))
        {
            xWins(2,4,6);
        }
        
        //O wins combination
        if( buttons[0].getText().equalsIgnoreCase("O") &&  buttons[1].getText().equalsIgnoreCase("O") &&
                buttons[2].getText().equalsIgnoreCase("O"))
        {
            oWins(0,1,2);
        }
        if( buttons[3].getText().equalsIgnoreCase("O") &&  buttons[4].getText().equalsIgnoreCase("O") &&
                buttons[5].getText().equalsIgnoreCase("O"))
        {
            oWins(3,4,5);
        }
        if( buttons[6].getText().equalsIgnoreCase("O") &&  buttons[7].getText().equalsIgnoreCase("O") &&
                buttons[8].getText().equalsIgnoreCase("O"))
        {
            oWins(6,7,8);
        }

        if( buttons[0].getText().equalsIgnoreCase("O") &&  buttons[3].getText().equalsIgnoreCase("O") &&
                buttons[6].getText().equalsIgnoreCase("O"))
        {
            oWins(0,3,6);
        }
        if( buttons[1].getText().equalsIgnoreCase("O") &&  buttons[4].getText().equalsIgnoreCase("O") &&
                buttons[7].getText().equalsIgnoreCase("O"))
        {
            oWins(1,4,7);
        }
        if( buttons[2].getText().equalsIgnoreCase("O") &&  buttons[5].getText().equalsIgnoreCase("O") &&
                buttons[8].getText().equalsIgnoreCase("O"))
        {
            oWins(2,5,8);
        }
        if( buttons[0].getText().equalsIgnoreCase("O") &&  buttons[4].getText().equalsIgnoreCase("O") &&
                buttons[8].getText().equalsIgnoreCase("O"))
        {
            oWins(0,4,8);
        }
        if( buttons[2].getText().equalsIgnoreCase("O") &&  buttons[4].getText().equalsIgnoreCase("O") &&
                buttons[6].getText().equalsIgnoreCase("O"))
        {
            oWins(2,4,6);
        }

    }

    public void xWins(int a,int b,int c){

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        text_field.setText("X Wins");

    }
    public void oWins(int a,int b,int c){

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        text_field.setText("O Wins");

    }


}
