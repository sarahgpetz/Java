/*Name: Sarah Petz
Date:12/10/24
Honors Advanced Programming
Project Description: Peg Solitaire */

import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FinalProject extends JPanel {

// arrray of peg coordinates and starting color. red= peg, black= emtpy
    static Object[][] pegCoordinates = {
        {260, 80, Color.RED},
        {220, 140, Color.RED},
        {300, 140, Color.RED},
        {180, 200, Color.RED},
        {260, 200, Color.RED},
        {340, 200, Color.RED},
        {140, 260, Color.RED},
        {220, 260, Color.RED},
        {300, 260, Color.RED},
        {380, 260, Color.RED},
        {100, 320, Color.RED},
        {180, 320, Color.RED},
        {260, 320, Color.RED},
        {340, 320, Color.RED},
        {420, 320, Color.RED}
    };
//array of possible moves to identify middle peg
    static int[][] okMoves = {
        {1, 2, 4}, {4, 2, 1},
        {1, 3, 6}, {6, 3, 1},
        {2, 4, 7}, {7, 4, 2},
        {2, 5, 9}, {9, 5, 2},
        {3, 5, 8}, {8, 5, 3},
        {3, 6, 10}, {10, 6, 3},
        {4, 7, 11}, {11, 7, 4},
        {4, 8, 13}, {13, 8, 4},
        {5, 8, 12}, {12, 8, 5},
        {5, 9, 14}, {14, 9, 5},
        {6, 9, 13}, {13, 9, 6},
        {6, 10, 15}, {15, 10, 6},
        {11, 12, 13}, {13, 12, 11},
        {12, 13, 14}, {14, 13, 12},
        {13, 14, 15}, {15, 14, 13},
        {4, 5, 6}, {6, 5, 4},
        {7, 8, 9}, {9, 8, 7},
        {8, 9, 10}, {10, 9, 8}
    };

    public static void main(String[] args) {
        
        System.out.println("Written by: Sarah Petz");
        JFrame frame = new JFrame("Sarah's Final Project");
        
        FinalProject panel = new FinalProject();
        
        frame.add(panel);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
// control variable to check if more moves left
        boolean stillPlaying = true;

        Scanner kb = new Scanner(System.in);

        int emptyPeg = 0;
        System.out.println("What peg do you want start with empty (select a number or type random)?");
        String pegSelection = kb.next();
        // have empty hole chosen randomly for the user
        if (pegSelection.toLowerCase().equals("random")){
            emptyPeg = (int)(Math.random()*16);
        }
        else{ 
            emptyPeg= Integer.parseInt(pegSelection);//change string to int
        }

        // set the chosen empty peg as black
        pegCoordinates[emptyPeg-1][2] = Color.BLACK;
        frame.repaint();

        // start player moves
        while (stillPlaying)
        {    
            System.out.println("What peg do you want to move?");
            int startPeg = kb.nextInt();

            if(startPeg > 0 && startPeg < 16)//prevent too large numbers
            {
                System.out.println("Where do you want to move it to?");
                int movePeg = kb.nextInt();

                //boolean to check if it is a valid move
                boolean success = false;
                //removes start peg
                if(pegCoordinates[startPeg-1][2]==Color.RED && pegCoordinates[movePeg-1][2] == Color.BLACK)
                {
                    //find the middle peg in the sequences of possible moves
                    for(int[] move : okMoves)
                    {
                        if(move[0] == startPeg && move[2] == movePeg){
                            
                            //find second peg and set it to black
                            pegCoordinates[move[1]-1][2] = Color.BLACK;
                            success = true;
                        }
                    }
                
                    //sets start peg as black 
                    pegCoordinates[startPeg-1][2] = Color.BLACK;
                    //set move/end to peg as red
                    pegCoordinates[movePeg-1][2] = Color.RED;
                }
                if (success == false){
                    System.out.println("Invalid move please try again.");
                }
                int counter = 0;
                //find out if there are any remaining moves and if are add to a counter
                for(int[] remainingMoves : okMoves){
                    if (pegCoordinates[remainingMoves[0]-1][2]==Color.RED && pegCoordinates[remainingMoves[1]-1][2]==Color.RED && pegCoordinates[remainingMoves[2]-1][2]==Color.BLACK){
                        counter++;
                    }
                }
                if (counter == 0){
                    stillPlaying = false;
                    //end the game if counter is not 0
                }
                frame.repaint();
                //update the graphics
            }
            else {
                  //if not a valid move
                System.out.println("Thats not a valid peg.");
            } 

        }
        System.out.println("Game Over");
        // create final peg counter
        int finalPegCount = 0;
        // count pegs left based on those that are still red and add them to the counter
        for (Object[] finalPegs : pegCoordinates){
            if (finalPegs[2]== Color.RED){
                finalPegCount++;
            }
        }
        System.out.println("Remaining Pegs:" + finalPegCount);
         //print the iconic statements from cracker barrel
        if (finalPegCount>=4){
            System.out.println("You're just plain EG-NO-RA-MOOSE");
            }
            else if (finalPegCount==3){
            System.out.println("You're just plain dumb.");
                }
              else if (finalPegCount == 2){
                System.out.println("You're purty smart.");
              }
                else{
                    System.out.println("You're genius.");  
                }

            
        }
    

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // board settup
        g.setColor(Color.ORANGE);
        int[] xPoints = {40, 280, 520};
        int[] yPoints = {380, 30, 380};
        g.fillPolygon(xPoints, yPoints, 3);
        //pegs settup
        int counter = 1;
        for (Object[] coordinate : pegCoordinates) { //use the peg coordinates to paint them into red ovals
            g.setColor((Color)coordinate[2]);
            g.fillOval((int)coordinate[0], (int)coordinate[1], 40, 40);
           // add the numbers of the wholes next to them for ease of play
            g.setColor(Color.BLACK);
            g.drawString("#" + counter,(int)coordinate[0]+40, (int)coordinate[1]+40);
            counter++;
        }

    }

   
}
