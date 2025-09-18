/*Name: Sarah Petz
Date:12/10/24
Honors Advanced Programming
Project Description: Create a game */

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class FinalProject2 extends JPanel {
  
     
   int[][] pegCoordinates = {
      {260, 80},
      {220, 140},
      {300, 140},
      {180, 200},
      {260, 200},
      {340, 200},
      {140, 260},
      {220, 260},
      {300, 260},
      {380, 260},
      {100, 320},
      {180, 320},
      {260, 320},
      {340, 320},
      {420, 320},

   };
   
   int[][] okMoves = {
      {1,2,4},
      {1,3,6},
      {2,4,7},
      {2,5,9},
      {3,5,8},
      {3,6,10},
      {4,7,11},
      {4,8,13},
      {5,8,12},
      {5,9,14},
      {6,9,13},
      {6,10,15},
      {11,12,13},
      {12,13,14},
      {13,14,15},
      {4,5,6},
      {7,8,9},
      {8,9,10}
      
   };
  
   public static void main(String[] args) { 
      System.out.println("Written by: Sarah Petz");
      
      JFrame frame = new JFrame("Java Graphics Demo");
      FinalProject panel = new FinalProject();
      
      frame.add(panel);
      frame.setSize(600, 600);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      }

      public void paintComponent(Graphics g) {
      super.paintComponent(g); 
      // board
      g.setColor(Color.ORANGE);
      int[] xPoints = {40, 280, 520};
      int[] yPoints = {380, 30, 380};
      
      g.fillPolygon(xPoints, yPoints, 3);
      
     
      //System.out.println("What peg would you like to start empty?");
      //Scanner kb = new Scanner(System.in);
      //int emptyPeg = kb.nextInt();
      //System.out.println(pegCoordinates[emptyPeg-1][0]);
      //System.out.println(pegCoordinates[emptyPeg-1][1]);
      //System.out.println(emptyPeg);
     
      for (int[] coordinate: pegCoordinates){
      //System.out.println(coordinate[0]);
      //System.out.println(coordinate[1]);
      
      // print empty peg coordinates black
      
      g.setColor(Color.RED);
      g.fillOval(coordinate[0], coordinate[1], 40, 40);

      }
      //g.setColor(Color.BLACK);
      //g.fillOval(pegCoordinates[emptyPeg-1][0],pegCoordinates[emptyPeg-1][1], 40, 40);
      g.setColor(Color.BLACK);
      g.fillOval(260,80,40,40);


            System.out.println("What peg do you want to move?");
            //int startPeg = kb.nextInt();
            
            System.out.println("Where do you want to move it?");
            //int endPeg = kb.nextInt();
         }
     
   

     
  }
      
     
      
      
      
      //set peg # to location
      
      
          
     //add array of moves and positions
     // ask which one to be empty, change empty one to black
     //  
       
   
